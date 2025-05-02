package mylab.music.entity;

import mylab.music.control.Playable;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, int fileSize) {
        this(title, artist, fileSize, 5);
    }

    public MP3(String title, String artist, int fileSize, int volume) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = volume;
    }

    public int getFileSize() {
        return fileSize;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("볼륨이 " + this.volume + "로 설정되었습니다.");
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }

    @Override
    public void play() {
        super.play();
        System.out.println("현재 볼륨: " + this.volume);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + this.fileSize + "MB");
    }
}