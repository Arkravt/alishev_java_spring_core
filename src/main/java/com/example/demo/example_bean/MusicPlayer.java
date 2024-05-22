package com.example.demo.example_bean;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer {

    @Value("${musicPlayer.musicPlayerName: JetAudio}")
    private String name;

    @Value("${musicPlayer.volume: 50}")
    private String volume;

    private List<Music> genreList;

    public MusicPlayer(List<Music> genreList) {
        this.genreList = genreList;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Closing music player");
    }

    public void playMusic(MusicType musicType) {

        Random rnd = new Random();

        Music music = genreList.get(rnd.nextInt(genreList.size()));
        int randomSongIdx = rnd.nextInt(music.getSongs().size());
        String song = music.getSongs().get(randomSongIdx);
        System.out.println("Playing song: " + song +
                "\non: " + name +
                "\nvolume: " + volume);
    }
}
