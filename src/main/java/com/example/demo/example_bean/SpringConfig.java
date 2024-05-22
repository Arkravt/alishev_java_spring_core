package com.example.demo.example_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:/application.properties")
public class SpringConfig {

    @Bean
    public Music classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public Music rockMusic() {
        return new RockMusic();
    }

    @Bean
    public Music jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    public ArrayList<Music> genreList() {
        ArrayList<Music> genreList = new ArrayList<>();
        genreList.add(rockMusic());
        genreList.add(classicalMusic());
        genreList.add(jazzMusic());
        return genreList;
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(genreList());
    }

}
