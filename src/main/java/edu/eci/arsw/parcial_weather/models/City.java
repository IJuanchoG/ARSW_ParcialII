package edu.eci.arsw.parcial_weather.models;

import java.util.HashMap;

public class City {
    private int id;
    private String name;
    private int timezone;
    private String base;
    private HashMap<String, Integer> clouds;
    private long dt;
    private long visibility;
    private Location coord;
    private Weather weather;
    private Main main;
    private Wind wind;
    private Sys sys;

    public City(int id, String name, int timezone, String base, HashMap<String, Integer> clouds, long dt, long visibility, Location coord, Weather weather, Main main, Wind wind, Sys sys) {
        this.id = id;
        this.name = name;
        this.timezone = timezone;
        this.base = base;
        this.clouds = clouds;
        this.dt = dt;
        this.visibility = visibility;
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Integer> getClouds() {
        return clouds;
    }

    public void setClouds(HashMap<String, Integer> clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public Location getCoord() {
        return coord;
    }

    public void setCoord(Location coord) {
        this.coord = coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}
