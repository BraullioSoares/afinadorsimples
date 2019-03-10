package model;

import android.media.MediaPlayer;

public class NotasMusicais {

    private String title;
    private MediaPlayer audio;

    public NotasMusicais(String title, MediaPlayer audio) {
        this.title = title;
        this.audio = audio;
    }

    public String getTitle() {
        return title;
    }

    public MediaPlayer getAudio() {
        return audio;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }
}
