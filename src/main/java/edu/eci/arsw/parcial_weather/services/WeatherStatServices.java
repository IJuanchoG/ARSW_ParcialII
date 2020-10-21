package edu.eci.arsw.parcial_weather.services;

import edu.eci.arsw.parcial_weather.models.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class WeatherStatServices {
    private static World world = new World();

    public static City getWeatherByCity(String name) throws IOException {

        JSONObject jsonObject = HttpConnectionServices.getWeather("weather?q=" + name);
        City city = buildCity(jsonObject);
        world.addCity(city);
        return city;
    }



    public static City getWeatherById(String id) throws IOException {
        JSONObject jsonObject = HttpConnectionServices.getWeather("weather?id="+id);
        City city = buildCity(jsonObject);
        world.addCity(city);
        return city;
    }

    public static City getWeatherByCoord(String lat, String lon) throws IOException {
        JSONObject jsonObject = HttpConnectionServices.getWeather("weather?lat="+lat+"&lon="+lon);
        City city = buildCity(jsonObject);
        world.addCity(city);
        return city;
    }

    private static City buildCity(JSONObject jsonObject) {
        String lon = jsonObject.getJSONObject("coord").getJSONObject("lon").toString();
        String lat = jsonObject.getJSONObject("coord").getJSONObject("lat").toString();
        System.out.println("lat: "+lat);
        System.out.println("lon: "+lon);
        Location location = new Location(Double.parseDouble(lon),Double.parseDouble(lat));

        int idWeather = Integer.parseInt(jsonObject.getJSONObject("weather").getJSONObject("id").toString());
        String mainWeather = jsonObject.getJSONObject("weather").getJSONObject("main").toString();
        String description = jsonObject.getJSONObject("weather").getJSONObject("description").toString();
        String icon = jsonObject.getJSONObject("weather").getJSONObject("icon").toString();
        Weather weather = new Weather(idWeather,mainWeather,description,icon);

        double temp = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("temp").toString());
        double feels_like = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("feels_like").toString());
        double temp_min = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("temp_min").toString());
        double temp_max = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("temp_max").toString());
        double pressure = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("pressure").toString());
        double humidity = Double.parseDouble(jsonObject.getJSONObject("main").getJSONObject("humidity").toString());
        Main main  = new Main(temp,feels_like,pressure,humidity,temp_min,temp_max);

        double speed = Double.parseDouble(jsonObject.getJSONObject("wind").getJSONObject("speed").toString());
        double deg = Double.parseDouble(jsonObject.getJSONObject("wind").getJSONObject("deg").toString());
        Wind wind = new Wind(speed,deg);

        int type = Integer.parseInt(jsonObject.getJSONObject("sys").getJSONObject("type").toString());
        int idSys = Integer.parseInt(jsonObject.getJSONObject("sys").getJSONObject("id").toString());
        int message = Integer.parseInt(jsonObject.getJSONObject("sys").getJSONObject("message").toString());
        String country = jsonObject.getJSONObject("sys").getJSONObject("country").toString();
        int sunrise = Integer.parseInt(jsonObject.getJSONObject("sys").getJSONObject("sunrise").toString());
        int sunset = Integer.parseInt(jsonObject.getJSONObject("sys").getJSONObject("sunset").toString());
        Sys sys = new Sys(type,idSys,message,country,sunrise,sunset);

        HashMap<String, Integer> clouds = new HashMap<>();
        jsonObject.getJSONObject("clouds").keySet().forEach(x -> clouds.put(x.toString(),Integer.parseInt(jsonObject.getJSONObject("clouds").getJSONObject(x.toString()).toString())));

        int cityId = Integer.parseInt(jsonObject.getJSONObject("id").toString());
        String cityName = jsonObject.getJSONObject("name").toString();
        String cityBase = jsonObject.getJSONObject("base").toString();
        int timezone = Integer.parseInt(jsonObject.getJSONObject("timezone").toString());
        int dt = Integer.parseInt(jsonObject.getJSONObject("dt").toString());
        int visibility = Integer.parseInt(jsonObject.getJSONObject("visibility").toString());

        return new City(cityId,cityName,timezone,cityBase,clouds,dt,visibility,location,weather,main,wind, sys);

    }
}
