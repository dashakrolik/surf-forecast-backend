package com.ordina.surfforecast.model;

import java.time.LocalDateTime;
import java.util.List;




public class WaveHeightDTO {
    List<Hour> hours;

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }
}
