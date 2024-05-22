package com.example.demo.example_bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class RockMusic implements Music {

    List<String> musicList = new ArrayList<>();

    @PostConstruct
    public void init() {
        musicList.add("Rock music 1");
        musicList.add("Rock music 2");
        musicList.add("Rock music 3");
    }

    @Override
    public String getSong() {
        return "Some Rock music";
    }

    @Override
    public List<String> getSongs() {
        return musicList;
    }

}
