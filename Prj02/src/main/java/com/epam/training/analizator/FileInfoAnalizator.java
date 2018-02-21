package com.epam.training.analizator;

import com.epam.training.model.FileInfo;

import java.util.List;

public interface FileInfoAnalizator {

    List<List<FileInfo>> getDuplicates(List<FileInfo> fileInfos);

    List<List> getDuplicatesByFileds(List<FileInfo> fileInfos);
}
