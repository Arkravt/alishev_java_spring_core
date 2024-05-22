package com.example.demo.example_autowire;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {

    List<String> musicList = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<String> musicList = new ArrayList<>();
        musicList.add("Rock music 1");
        musicList.add("Rock music 2");
        musicList.add("Rock music 3");
    }

    @Override
    public String getSong() {
        return "Some rock music";
    }

    @Override
    public List<String> getSongs() {
        return musicList;
    }

}
