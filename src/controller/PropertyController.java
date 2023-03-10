package controller;

import models.property.Apartment;
import models.property.Condo;
import models.property.House;
import models.property.Property;
import service.PropertySvcInterface;

import java.util.List;

public class PropertyController {

    private PropertySvcInterface propertySvc;

    public PropertyController(PropertySvcInterface propertySvc) {
        this.propertySvc = propertySvc;
    }

    public String addHouse(String streetName, String city, String postalCode, String province, String country, int streetNo) {
        House h = new House(streetName, city, postalCode, province, country, streetNo);
        return propertySvc.add(h);
    }

    public String addApartment(String streetName, String city, String postalCode, String province, String country,
                               int aptNo, int noOfBedrooms, int noOfBathrooms, double squareFootArea){
        Apartment a = new Apartment(streetName, city, postalCode, province, country, aptNo, noOfBedrooms, noOfBathrooms, squareFootArea);
        return propertySvc.add(a);
    }

    public String addCondo(String streetName, String city, String postalCode, String province, String country,
                           int condoNo, int noOfBedrooms, int noOfBathrooms, double squareFootArea){
        Condo c = new Condo(streetName, city, postalCode, province, country, condoNo, noOfBedrooms, noOfBathrooms, squareFootArea);
        return propertySvc.add(c);
    }

    public List<Condo> getAllCondos(){
       return propertySvc.getCondos();
    }
    public List<House> getAllHouses(){
        return propertySvc.getHouses();
    }
    public List<Apartment> getAllApartments(){
        return propertySvc.getApartments();
    }

    public List<Property> getAllProperties(){
        return propertySvc.getProperties();
    }
}
