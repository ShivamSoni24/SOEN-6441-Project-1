package service;

import models.property.Apartment;
import models.property.Condo;
import models.property.House;
import models.property.Property;
import repository.Filter;

import java.util.List;

public interface PropertySvcInterface {
    String add(Property p);
    Property getProperty(String id);
    List<House> getHouses(Filter f);
    List<Condo> getCondos(Filter f);
    List<Apartment> getApartments(Filter f);
    List<Property> getProperties(Filter f);
}
