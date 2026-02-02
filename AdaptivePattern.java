// AdvancedMediaPalyer interface class
interface AdvancedMediaPalyer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}

// VlcPlayer class
class VlcPlayer implements AdvancedMediaPalyer {
    public void playVlc(String fileName){
        System.out.println(fileName + " is playing. FileType : VLC ");
    }
    public void playMp4(String fileName) { }
}

// Mp4Player class
class Mp4Player implements AdvancedMediaPalyer {
    public void playVlc(String fileName) { }
    public void playMp4(String fileName) {
        System.out.println(fileName + " is playing. FileType : MP4");
    }
}

// MediaPlayer interface class
interface MediaPlayer {
    public void play(String audioType, String fileName);
}

// MediaAdapter class 
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPalyer advancedMediaPalyer;
    
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPalyer = new Mp4Player();
        }
        else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPalyer = new VlcPlayer();
        }
    }
    public void play(String audioType , String fileName){
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPalyer.playMp4(fileName);
        }
        else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPalyer.playVlc(fileName);
        }
    }
}

// AudioPlayer class
class AudioPlayer implements MediaPlayer {

    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println(fileName + " is playing. Filetype : " + audioType);
        }
        else if(audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")){
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else {
            System.out.println("Invalid audioType. fileName:" + fileName + " FileType:" + audioType);
        }
    }
}

public class AdaptivePattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "Jarina");
        audioPlayer.play("mp4", "Sakina");
        audioPlayer.play("vlc", "Molom");
        audioPlayer.play("uradhura", "Fucking");

    }
}
