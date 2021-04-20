# Gerando uma API Key do OpenWeatherMap
Acesse o [OpenWeatherMap](https://openweathermap.org), crie uma conta e acesse a aba "My API Keys" para gerar sua key.


# Rodando o aplicativo localmente
* Instale o [Java SE](https://www.oracle.com/java/technologies/java-se-glance.html);

* Clone o repositório pelo Git:
```
git clone https://github.com/pedrodellolio/spring-weather-app.git
```

* Altere no arquivo [WeatherAPIService.java](https://github.com/pedrodellolio/spring-weather-app/blob/5a077591c565ac7a100cf6ea656a75774af52366/src/main/java/com/github/pedrodellolio/webweather/service/WeatherAPIService.java) o seguinte atributo:
```
private String apiKey = "{API_KEY}";
```
Onde ``{API_KEY}`` é a chave disponível a partir do cadastro no site do OpenWeatherMap. Mantenha as aspas substituindo apenas o conteúdo que está dentro!

* O aplicativo estará disponível no localhost na porta 8080:
```
http://localhost:8080
```

# Protótipo
É possível visualizar o protótipo do projeto no Figma. [Clique aqui](https://www.figma.com/file/15uWrBTW1U2rCXvIfobyuo/spring-weather-app?node-id=0%3A1)!


---
Por [Pedro Dell'Olio](https://github.com/pedrodellolio). Feito com a API do [OpenWeatherMap](https://openweathermap.org).

Entre em contato comigo pelo [Linkedin](https://www.linkedin.com/in/pedrodellolio/).
