package org.example;



import java.util.List;

public class City {
    private String name;
    private int yearFounded;
    private double area;
    private List<ResidentType> residentTypes;

    public City(String name, int yearFounded, double area, List<ResidentType> residentTypes) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.area = area;
        this.residentTypes = residentTypes;
    }

    public String getName() {
        return name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public double getArea() {
        return area;
    }

    public List<ResidentType> getResidentTypes() {
        return residentTypes;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", area=" + area +
                ", residentTypes=" + residentTypes +
                '}';
    }
}
