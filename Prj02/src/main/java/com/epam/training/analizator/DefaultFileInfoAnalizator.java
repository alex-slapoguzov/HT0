package com.epam.training.analizator;

import com.epam.training.model.FileInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DefaultFileInfoAnalizator implements FileInfoAnalizator {

    public List<List<FileInfo>> getDuplicates(List<FileInfo> fileInfos) {
        List<FileInfo> copyFileInfos = new ArrayList<FileInfo>(fileInfos);

        List<List<FileInfo>> duplicates = new ArrayList<>();

        for(FileInfo fileInfo : fileInfos) {
            duplicates.add(copyFileInfos.stream().filter(f -> fileInfo.hashCode() == f.hashCode()).collect(Collectors.toList()));
            copyFileInfos.removeIf(c -> fileInfo.hashCode() == c.hashCode());
        }
        return duplicates;
    }
}
