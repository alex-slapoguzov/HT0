package com.epam.training.analizator;

import com.epam.training.model.FileInfo;
import com.epam.training.model.Mp3FileInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Mp3FileInfoAnalizator extends DefaultFileInfoAnalizator implements FileInfoAnalizator {


    public List<List> getDuplicatesByFileds(List<FileInfo> fileInfos) {
        List<FileInfo> copyFileInfos = new ArrayList<>(fileInfos);

        List<List> duplicates = new ArrayList<>();

        for(FileInfo fileInfo :  copyFileInfos) {
            List<FileInfo> duplicate = copyFileInfos.stream()
                    .filter(f -> isFileInfoSimilar((Mp3FileInfo) fileInfo, (Mp3FileInfo)f))
                    .collect(Collectors.toList());
            duplicates.add(duplicate);
            copyFileInfos.removeIf(c -> isFileInfoSimilar((Mp3FileInfo)fileInfo, (Mp3FileInfo)c));
        }
        return duplicates;
    }

    private boolean isFileInfoSimilar(Mp3FileInfo mp3FileInfo, Mp3FileInfo fileInfo) {
        return Objects.equals(fileInfo.getArtistName(), mp3FileInfo.getArtistName())
                && Objects.equals(fileInfo.getName(), mp3FileInfo.getName())
                && Objects.equals(fileInfo.getTrackName(), mp3FileInfo.getTrackName());
    }

}
