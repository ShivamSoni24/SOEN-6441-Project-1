package Main.service;

import Main.models.property.Apartment;
import Main.models.property.Condo;
import Main.models.property.House;
import Main.models.property.Property;
import Main.repository.Filter;

import java.util.List;

public interface PropertySvcInterface {
    String add(Property p);
    Property getProperty(String id);
    List<House> getHouses(Filter f);
    List<Condo> getCondos(Filter f);
    List<Apartment> getApartments(Filter f);
    List<Property> getProperties(Filter f);


}
