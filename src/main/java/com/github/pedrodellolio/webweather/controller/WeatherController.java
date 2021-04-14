package com.github.pedrodellolio.webweather.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pedrodellolio.webweather.model.City;
import com.github.pedrodellolio.webweather.model.Day;
import com.github.pedrodellolio.webweather.model.Week;
import com.github.pedrodellolio.webweather.service.WeatherAPIService;

@Controller
@RequestMapping
public class WeatherController {

	private WeatherAPIService weatherAPIService;

	WeatherController(WeatherAPIService weatherAPIService) {
		this.weatherAPIService = weatherAPIService;
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/weather/find")
	public String recebeCity(@RequestParam("name") String cityName, Model model) throws Exception {
		try {
			City todayInfo = weatherAPIService.findForecastByName(cityName);
			Double cityLat = todayInfo.getCoord().getLat();
			Double cityLon = todayInfo.getCoord().getLon();
			Week weekInfo = weatherAPIService.findWeekForecastByCoord(cityLat, cityLon);
			
			
			//gerando os dias da semana
			int daysWeek = 7;
			for (int i = 0; i <= daysWeek; i++) {
				LocalDateTime date = LocalDateTime.now().plusDays(i);
				Day day = new Day(DayOfWeek.from(date), date.getDayOfMonth());
				weekInfo.getWeek().add(day);
			}
			
			model.addAttribute("todayInfo", todayInfo);
			model.addAttribute("weekInfo", weekInfo);
			
			return "city";
			
		} catch (Exception e) {
			return "redirect:/";
		}
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
    	return "redirect:/";
    }

}
