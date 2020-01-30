package com.ordina.surfforecast.model;

import com.fasterxml.jackson.annotation.JsonView;

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
	private double waveheightvalue;

	@Column(name="swellperiod")
	private double swellperiodvalue;

	@Column(name="winddirection")
	private double winddirectionvalue;

	@Column(name="windspeed")
	private double windspeedvalue;

	public double getWinddirectionvalue() {
		return winddirectionvalue;
	}

	public void setWinddirectionvalue(double winddirectionvalue) {
		this.winddirectionvalue = winddirectionvalue;
	}

	public double getWindspeedvalue() {
		return windspeedvalue;
	}

	public void setWindspeedvalue(double windspeedvalue) {
		this.windspeedvalue = windspeedvalue;
	}

	public double getSwellperiodvalue() {
		return swellperiodvalue;
	}

	public void setSwellperiodvalue(double swellperiodvalue) {
		this.swellperiodvalue = swellperiodvalue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public double getWaveheightvalue() {
		return waveheightvalue;
	}

	public void setWaveheightvalue(double waveheightvalue) {
		this.waveheightvalue = waveheightvalue;
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
	
}