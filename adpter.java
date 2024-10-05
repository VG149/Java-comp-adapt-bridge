// Interface esperada
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Classe legado que não é compatível com MediaPlayer
class LegacyAudioPlayer {
    void playMP3(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

// Adapter que adapta LegacyAudioPlayer para MediaPlayer
class AudioPlayerAdapter implements MediaPlayer {
    private LegacyAudioPlayer legacyAudioPlayer;

    public AudioPlayerAdapter(LegacyAudioPlayer legacyAudioPlayer) {
        this.legacyAudioPlayer = legacyAudioPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            legacyAudioPlayer.playMP3(fileName);
        } else {
            System.out.println("Invalid audio type.");
        }
    }
}

// Testando o Adapter
public class AdapterExample {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayerAdapter(new LegacyAudioPlayer());
        player.play("mp3", "song.mp3");
    }
}
