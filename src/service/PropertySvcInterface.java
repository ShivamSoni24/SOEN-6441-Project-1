package service;

import models.property.Apartment;
import models.property.Condo;
import models.property.House;
import models.property.Property;

import java.util.List;

public interface PropertySvcInterface {
    String add(Property p);
    Property getProperty(String id);
    List<House> getHouses();
    List<Condo> getCondos();
    List<Apartment> getApartments();
    List<Property> getProperties();
}
