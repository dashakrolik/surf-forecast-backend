package com.ordina.surfforecast.model;

import java.util.List;

public class Hour {
    private String time;
    private List<WaveHeight> waveHeight;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<WaveHeight> getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(List<WaveHeight> waveHeight) {
        this.waveHeight = waveHeight;

    }
}