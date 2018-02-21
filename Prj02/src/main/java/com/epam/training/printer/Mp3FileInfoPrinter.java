package com.epam.training.printer;

import com.epam.training.model.Mp3FileInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Mp3FileInfoPrinter implements FileInfoPrinter<Mp3FileInfo> {

    private static final String HTML_HEADER = "<html><body>";
    private static final String HTML_DIV = "<div>";
    private static final String HTML_DIV_END = "</div>";
    private static final String HTML_BR = "<br></br>";
    private static final String HTML_FOOTER = "</body></html>";

    @Override
    public void print(List<Mp3FileInfo> mp3FileInfos) throws IOException {
        String htmlString = HTML_HEADER;

        for (Mp3FileInfo mp3FileInfo : mp3FileInfos) {
            htmlString += HTML_DIV + mp3FileInfo.getArtistName() + " " + mp3FileInfo.getTrackName() + " " +
                    mp3FileInfo.getDuration() + " " + mp3FileInfo.getPath() + HTML_DIV_END + HTML_BR;
        }

        htmlString += HTML_FOOTER;

        writeStringToFile(htmlString);
    }

    @Override
    public void printDuplicates(List<List<Mp3FileInfo>> fileInfos) throws IOException {
        String htmlString = HTML_HEADER;

        for (int i = 0; i < fileInfos.size(); i++) {
            htmlString += HTML_DIV + "Duplicate " + i + HTML_BR;
            for (Mp3FileInfo mp3FileInfo : fileInfos.get(i)) {
                htmlString += "Full path to file: " + mp3FileInfo.getPath() + HTML_BR;
            }
        }

        htmlString += HTML_FOOTER;
        writeStringToFile(htmlString);
    }

    @Override
    public void printDuplicatesByFields(List<List<Mp3FileInfo>> fileInfos) throws IOException {
        String htmlString = HTML_HEADER;

        for (int i = 0; i < fileInfos.size(); i++) {
            htmlString += HTML_DIV + "Artist " + fileInfos.get(i) + "Track name " + fileInfos.get(i) + HTML_BR;
            for (Mp3FileInfo mp3FileInfo : fileInfos.get(i)) {
                htmlString += "Full path to file: " + mp3FileInfo.getPath() + HTML_BR;
            }
        }

        htmlString += HTML_FOOTER;
        writeStringToFile(htmlString);
    }

    private void writeStringToFile(String htmlString) throws IOException {
        File newHtmlFile = new File("result.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
    }

}
