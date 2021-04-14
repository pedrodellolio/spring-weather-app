package com.github.pedrodellolio.webweather.model;

import java.util.HashMap;
import java.util.List;

public class City {
	private String name;
	private Coordinates coord;
	private Temperature main;
	private List<Weather> weather;
	private HashMap<String, String> sys;

	private List<Day> daily;
	private Current current;

	public List<Day> getDaily() {
		return daily;
	}

	public Current getCurrent() {
		return current;
	}

	public HashMap<String, String> getSys() {
		return sys;
	}

	public String getName() {
		return name;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public Temperature getMain() {
		return main;
	}
}