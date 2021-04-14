package com.github.pedrodellolio.webweather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.github.pedrodellolio.webweather.model.City;
import com.github.pedrodellolio.webweather.model.Week;
import com.google.gson.Gson;

@Service
public class WeatherAPIService {
	private String url = "http://api.openweathermap.org/data/2.5/";
	private String metric = "&units=metric";
	private String lang = "&lang=pt_br";
	private String apiKey = "{API_KEY}"; //no lugar de {API_KEY} insira a sua key
				
	public City findForecastByName(String name) throws Exception {
		String urlString = url + "weather?q=" + name + metric + lang + "&appid=" + apiKey;
		
		//testando conexão
		try {
			URL url = new URL(urlString);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());
			}

			//recebendo a resposta e passando para o gson
			BufferedReader resp = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonString = jsonToString(resp);
			Gson gson = new Gson();
			City city = gson.fromJson(jsonString, City.class);
			return city;

		} catch (Exception e) {
			throw new Exception("Error: " + e);
		}
	}

	public Week findWeekForecastByCoord(Double lat, Double lon) throws Exception {
		String urlString = url + "onecall?" + "lat=" + lat + "&lon=" + lon + "&exclude=minutely,hourly,alerts" + metric
				+ lang + "&appid=" + apiKey;

		try {
			URL url = new URL(urlString);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());
			}

			BufferedReader resp = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonString = jsonToString(resp);

			Gson gson = new Gson();
			Week week = gson.fromJson(jsonString, Week.class);

			return week;

		} catch (Exception e) {
			throw new Exception("Error: " + e);
		}
	}

	public static String jsonToString(BufferedReader bufferedReader) throws IOException {
		String resp, jsonString = "";
		
		while ((resp = bufferedReader.readLine()) != null) {
			jsonString += resp;
		}
		return jsonString;
	}

}
