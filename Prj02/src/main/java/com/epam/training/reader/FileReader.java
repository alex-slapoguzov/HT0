package com.epam.training.reader;

import com.epam.training.model.FileInfo;

import java.util.List;

public interface FileReader {

    List<FileInfo> read(String paths) throws Exception;
}
