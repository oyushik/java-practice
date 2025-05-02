package mylab.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm;

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    public void clean() {
        System.out.println("바이닐 레코드를 청소합니다.");
    }

    @Override
    public void play() {
        System.out.println("바이닐 레코드 '" + getTitle() + "'이(가) " + this.rpm + "rpm으로 재생됩니다.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("회전 속도: " + this.rpm + " rpm");
    }
}