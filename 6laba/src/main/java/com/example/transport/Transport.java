
package com.example.transport;

public interface Transport {
    String getRegistrationNumber();
    void setRegistrationNumber(String registrationNumber);

    String getBrand();
    void setBrand(String brand);

    String getModel();
    void setModel(String model);

    String getVinNumber();
    void setVinNumber(String vinNumber);

    String getOwner();
    void setOwner(String owner);

    String getPowerType();
    void setPowerType(String powerType);

    void refuel();
    void repair();
    void service();
    void passInspection();
}
