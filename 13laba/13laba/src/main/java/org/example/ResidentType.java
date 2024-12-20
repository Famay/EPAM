package org.example;



public class ResidentType {
    private String name;
    private String language;
    private int population;

    public ResidentType(String name, String language, int population) {
        this.name = name;
        this.language = language;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "ResidentType{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", population=" + population +
                '}';
    }
}
