package controller;

import domain.property.Apartment;
import domain.property.Condo;
import domain.property.House;
import service.PropertySvcInterface;

public class PropertyController {

    private PropertySvcInterface propertySvc;

    public PropertyController(PropertySvcInterface propertySvc) {
        this.propertySvc = propertySvc;
    }

    public String addHouse(String streetName, String city, String postalCode, String province, String country,
                           int houseNo, int streetNo) {
        House h = new House(streetName, city, postalCode, province, country, houseNo, streetNo);
        return propertySvc.add(h);
    }

    public String addApartment(String streetName, String city, String postalCode, String province, String country,
                               int aptNo){
        Apartment a = new Apartment(streetName, city, postalCode, province, country, aptNo);
        return propertySvc.add(a);
    }

    public String addCondo(String streetName, String city, String postalCode, String province, String country, int condoNo){
        Condo c = new Condo(streetName, city, postalCode, province, country, condoNo);
        return propertySvc.add(c);
    }
}
