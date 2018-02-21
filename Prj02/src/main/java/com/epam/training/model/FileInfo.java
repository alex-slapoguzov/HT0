package com.epam.training.model;

public class FileInfo {

    private String name;
    private String path;


    public FileInfo(String name, String path) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
