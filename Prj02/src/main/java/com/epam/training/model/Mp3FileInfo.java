package com.epam.training.model;

public class Mp3FileInfo extends FileInfo {

    private String trackName;
    private String artistName;
    private int durationInSeconds;

    public Mp3FileInfo(String name, String path, String trackName, String artistName, int durationInSeconds) {
        super(name, path);
        this.artistName = artistName;
        this.trackName = trackName;
        this.durationInSeconds = durationInSeconds;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getDuration() {
        return durationInSeconds;
    }

    public void setDuration(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mp3FileInfo that = (Mp3FileInfo) o;

        if (durationInSeconds != that.durationInSeconds) {
            return false;
        }
        if (!trackName.equals(that.trackName)){
            return false;
        }
        return artistName.equals(that.artistName);
    }


    public int hashCode() {
        int result = trackName.hashCode();
        result = 31 * result + super.getName().hashCode();
        result = 31 * result + super.getPath().hashCode();
        result = 31 * result + artistName.hashCode();
        result = 31 * result + durationInSeconds;
        return result;
    }
}
