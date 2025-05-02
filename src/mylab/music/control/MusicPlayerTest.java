package mylab.music.control;

import mylab.music.entity.MP3;
import mylab.music.entity.MusicMedia;
import mylab.music.entity.Vinyl;

public class MusicPlayerTest {

    public static void main(String[] args) {
        System.out.println("===== 음악 재생 시스템 테스트 =====");

        System.out.println("\n--- MP3 테스트 ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();

        System.out.println("\n--- Vinyl 테스트 ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        System.out.println("\n--- 다형성 테스트 ---");
        MusicMedia digitalMedia = new MP3("Butter", "BTS", 4);
        digitalMedia.displayInfo();
        digitalMedia.play();

        System.out.println("\n--- 캐스팅 테스트 ---");
        if (digitalMedia instanceof Playable) {
            Playable playableMedia = (Playable) digitalMedia;
            playableMedia.setVolume(3);
            digitalMedia.play();
            playableMedia.setVolume(7);
            playableMedia.stop();
        }
    }
}