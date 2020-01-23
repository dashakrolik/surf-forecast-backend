package com.ordina.surfforecast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_BEACHES")
public class BeachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="latitude")
    private String latitude;

	@Column(name="longitude")
	private String longitude;

	@Column(name="waveheight")
	private String waveheight;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getWaveHeight() {
		return waveheight;
	}

	public void setWaveHeight(String waveHeight) {
    	WaveHeightDTO dto = new WaveHeightDTO();
    	dto.setHours(waveHeight);
		this.waveheight = dto.getHours();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

    @Override
    public String toString() {
        return "BeachEntity [id=" + id + ", name=" + name +
                ", lat, lng=" + latitude + "," + longitude + "]";
    }
}