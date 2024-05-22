package com.example.demo.example_bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class JazzMusic implements Music {

    List<String> musicList = new ArrayList<>();

    @PostConstruct
    public void init() {
        musicList.add("Jazz Music 1");
        musicList.add("Jazz Music 2");
        musicList.add("Jazz Music 3");
    }

    @Override
    public String getSong() {
        return "Some Jazz music";
    }

    @Override
    public List<String> getSongs() {
        return musicList;
    }
}
