package service;

import domain.property.Apartment;
import domain.property.Condo;
import domain.property.House;
import domain.property.Property;

import java.util.List;

public interface PropertySvcInterface {
    String add(Property p);
    List<House> getHouses();
    List<Condo> getCondos();
    List<Apartment> getApartments();
    List<Property> getProperties();
}
