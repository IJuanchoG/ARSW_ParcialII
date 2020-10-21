package edu.eci.arsw.parcial_weather.models;

import java.util.ArrayList;
import java.util.List;

public class World {
    List<City> cities;

    public World() {
        this.cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city){
        this.cities.add(city);
    }
}
