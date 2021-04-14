package com.github.pedrodellolio.webweather.model;

import com.google.gson.annotations.SerializedName;

public class Temperature {
	@SerializedName(value = "day", alternate = "temp")
	private Double day;
	@SerializedName(value = "min", alternate = "temp_min")
	private Double min;
	@SerializedName(value = "max", alternate = "temp_max")
	private Double max;

	public Integer getDay() {
		return day.intValue();
	}

	public Integer getMin() {
		return min.intValue();
	}

	public Integer getMax() {
		return max.intValue();
	}
}
