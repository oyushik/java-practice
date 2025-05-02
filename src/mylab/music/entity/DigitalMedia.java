package mylab.music.entity;

public class DigitalMedia extends MusicMedia {
    private String format;

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public void play() {
        System.out.println(this.format + " 형식의 '" + getTitle() + "'이(가) 디지털로 재생됩니다.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("포맷: " + this.format);
    }
}