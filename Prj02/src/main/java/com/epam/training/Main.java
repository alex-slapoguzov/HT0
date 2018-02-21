package com.epam.training;

import com.epam.training.analizator.FileInfoAnalizator;
import com.epam.training.analizator.Mp3FileInfoAnalizator;
import com.epam.training.reader.MP3Reader;
import com.epam.training.model.FileInfo;
import com.epam.training.printer.FileInfoPrinter;
import com.epam.training.printer.Mp3FileInfoPrinter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        args = new String[]{"E:\\New Folder"};


        Set<String> specifiedFolder = null;
        if (args.length == 0) {
            System.out.println("Not enough parameters.");
            return;
        } else {
            specifiedFolder = new HashSet<String>();
            for (int i = 0; i < args.length; i++) {
                specifiedFolder.add(args[i]);
            }
        }

        for (String paths : specifiedFolder) {
            try {
                MP3Reader mp3Reader = new MP3Reader();
                List<FileInfo> fileInfoList = mp3Reader.read(paths);

                FileInfoPrinter fileInfoPrinter = new Mp3FileInfoPrinter();
                fileInfoPrinter.print(fileInfoList);

                FileInfoAnalizator fileInfoAnalizator = new Mp3FileInfoAnalizator();

                List<List<FileInfo>> duplicates = fileInfoAnalizator.getDuplicates(fileInfoList);
                fileInfoPrinter.printDuplicates(duplicates);

                List<List> duplicatesByFields = fileInfoAnalizator.getDuplicatesByFileds(fileInfoList);
                fileInfoPrinter.printDuplicatesByFields(duplicatesByFields);

           }catch (Exception e) {
               System.out.println("Catalog not found.");
            }


        }
    }
}
