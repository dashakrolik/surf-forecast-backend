package com.ordina.surfforecast.model;

import java.util.List;

public class Hour {
    private String time;
    private List<WaveHeight> waveHeight;
    private List<SwellPeriod> swellPeriod;
    private List<WindSpeed> windSpeed;
    private List<WindDirection> windDirection;

    public List<WindSpeed> getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(List<WindSpeed> windSpeed) {
        this.windSpeed = windSpeed;
    }

    public List<WindDirection> getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(List<WindDirection> windDirection) {
        this.windDirection = windDirection;
    }

    public List<SwellPeriod> getSwellPeriod() {
        return swellPeriod;
    }

    public void setSwellPeriod(List<SwellPeriod> swellPeriod) {
        this.swellPeriod = swellPeriod;
    }

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