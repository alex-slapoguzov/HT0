package com.epam.training.printer;

import com.epam.training.model.FileInfo;

import java.io.IOException;
import java.util.List;

public interface FileInfoPrinter<T extends FileInfo> {

    void print(List<T> fileInfos) throws IOException;

    void printDuplicates(List<List<T>> fileInfos) throws IOException;

    void printDuplicatesByFields(List<List<T>> fileInfos) throws IOException;

}
