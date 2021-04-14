package com.github.pedrodellolio.webweather.model;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class Day {
	private Integer dayOfMonth;
	private String dayOfWeek;

	// API
	private Temperature temp;
	private List<Weather> weather;

	public Day(DayOfWeek dayOfWeek, Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

	public Temperature getTemp() {
		return temp;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}
}
