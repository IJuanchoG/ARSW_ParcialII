package edu.eci.arsw.parcial_weather.controller;

import edu.eci.arsw.parcial_weather.models.City;
import edu.eci.arsw.parcial_weather.models.Weather;
import edu.eci.arsw.parcial_weather.services.WeatherStatServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1")
public class WeatherStatsController {


    @GetMapping("weather")
    public ResponseEntity<?> getWeatherByCity(@RequestParam String name) {
        try {
            City city = WeatherStatServices.getWeatherByCity(name);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("weather")
    public ResponseEntity<?> getWeatherById(@RequestParam String id) {
        try {
            City city = WeatherStatServices.getWeatherById(id);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("weather")
    public ResponseEntity<?> getWeatherByCoord(@RequestParam String lat, @RequestParam String lon) {
        try {
            City city = WeatherStatServices.getWeatherByCoord(lat,lon);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
