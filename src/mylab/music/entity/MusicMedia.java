package mylab.music.entity;

public abstract class MusicMedia {
    private String title;
    private String artist;

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public abstract void play();

    public void displayInfo() {
        System.out.println("제목: " + this.title + ", 아티스트: " + this.artist);
    }
}