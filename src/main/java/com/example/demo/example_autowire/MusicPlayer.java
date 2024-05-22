package com.example.demo.example_autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
@PropertySource("classpath:/application.properties")
public class MusicPlayer {

    @Value("${musicPlayer.volume}")
    private int volume;
    private String musicPlayerName;
    private Music rockMusic;
    private Music classicalMusic;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Value("${musicPlayer.musicPlayerName: jetAudio}") String musicPlayerName) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.musicPlayerName = musicPlayerName;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Closing music player");
    }

    public void playMusic(MusicType musicType) {

        Random rnd = new Random();
        List<String> musicList;

        if (musicType.equals(MusicType.ROCK)) {
            musicList = rockMusic.getSongs();
        } else if (musicType.equals(MusicType.CLASSICAL)) {
            musicList = classicalMusic.getSongs();
        } else {
            System.out.println("Music Player is broken");
            return;
        }

        int index = rnd.nextInt(musicList.size());
        System.out.println("Playing " + musicList.get(index) + " on " + musicPlayerName + ", volume is: " + volume);
    }
}
