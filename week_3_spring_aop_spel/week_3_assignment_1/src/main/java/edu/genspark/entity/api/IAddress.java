package edu.genspark.entity.api;

public interface IAddress {

    String getCity();
    void setCity(String city);

    String getState();
    void setState(String state);

    String getCountry();
    void setCountry(String country);

    String getZipcode();
    void setZipcode(String zipcode);
}
