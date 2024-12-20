 package com.example.transport;

public class Car implements Transport {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vinNumber;
    private String owner;
    private String powerType;

    public Car(String registrationNumber, String brand, String model, String vinNumber, String owner, String powerType) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.powerType = powerType;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getVinNumber() {
        return vinNumber;
    }

    @Override
    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String getPowerType() {
        return powerType;
    }

    @Override
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    @Override
    public void refuel() {
        System.out.println("Автомобиль заправлен.");
    }

    @Override
    public void repair() {
        System.out.println("Автомобиль отремонтирован.");
    }

    @Override
    public void service() {
        System.out.println("Автомобиль обслужен.");
    }

    @Override
    public void passInspection() {
        System.out.println("Автомобиль прошел техосмотр.");
    }

    public void displayInfo() {
        System.out.println("Информация об автомобиле:");
        System.out.println("Регистрационный номер: " + registrationNumber);
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("VIN-номер: " + vinNumber);
        System.out.println("Владелец: " + owner);
        System.out.println("Тип движущей силы:  " + powerType);
    }
}
