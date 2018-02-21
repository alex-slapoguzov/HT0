package com.epam.training.reader;

import com.epam.training.exception.FileReaderException;
import com.epam.training.exception.Mp3FileFindException;
import com.epam.training.model.FileInfo;
import com.epam.training.model.Mp3FileInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MP3Reader implements FileReader {

    private static final String MP3_EXTENSION = "mp3";


    public List<FileInfo> read(String path) throws FileReaderException {
        List<File> files = getAllFiles(path);

        if (null == files || 0 == files.size()) {
            throw new Mp3FileFindException("Not exists mp3 files in those catalogs");
        }

        List<FileInfo> fileInfos = new ArrayList<FileInfo>();

        for (File file : files) {
            Metadata metadata = getFileMetadata(file);

            fileInfos.add(getFileInfo(metadata, file));
        }

        return fileInfos;
    }

    private Metadata getFileMetadata(File file) throws FileReaderException {
        Metadata metadata = new Metadata();
        try {
            BodyContentHandler handler = new BodyContentHandler();
            FileInputStream inputstream = new FileInputStream(file);
            ParseContext pcontext = new ParseContext();

            Mp3Parser Mp3Parser = new Mp3Parser();
            Mp3Parser.parse(inputstream, handler, metadata, pcontext);
        } catch (IOException | SAXException | TikaException e) {
            throw new FileReaderException("File read exception");
        }

        return metadata;
    }

    private FileInfo getFileInfo(Metadata metadata, File file) {
        String trackName = metadata.get(TikaCoreProperties.TITLE);
        String artistName = metadata.get(TikaCoreProperties.CREATOR);
        String filePath = metadata.get(file.getAbsolutePath());
        String fileName = metadata.get(file.getName());

        String duration = metadata.get("xmpDM:duration");
        int durationInSeconds = Integer.parseInt(duration.split(".")[0]);

        return new Mp3FileInfo(fileName, filePath, trackName, artistName, durationInSeconds);
    }

    private List<File> getAllFiles(String path) {
        List<String> paths = Arrays.asList(path.split(" "));

        List<File> files = new ArrayList<>();
        paths.forEach(p -> listf(p, files));
        return files;
    }

    private void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        if (fList == null) {
            return;
        }

        for (File file : fList) {
            if (file.isFile() && MP3_EXTENSION.equals(FilenameUtils.getExtension(file.getName()))) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
}
