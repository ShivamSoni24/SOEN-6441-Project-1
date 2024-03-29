package Main.controller;

import Main.models.property.Apartment;
import Main.models.property.Condo;
import Main.models.property.House;
import Main.models.property.Property;
import Main.repository.Filter;
import Main.service.PropertySvcInterface;

import java.util.List;

public class PropertyController {

    private final PropertySvcInterface propertySvc;

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

    public List<Condo> getAllCondos(Filter f){
       return propertySvc.getCondos(f);
    }
    public List<House> getAllHouses(Filter f){
        return propertySvc.getHouses(f);
    }
    public List<Apartment> getAllApartments(Filter f){
        return propertySvc.getApartments(f);
    }

    public List<Property> getAllProperties(Filter f){
        return propertySvc.getProperties(f);
    }
}
