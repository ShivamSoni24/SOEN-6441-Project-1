package service;

import models.property.Apartment;
import models.property.Condo;
import models.property.House;
import models.property.Property;
import repository.Filter;
import repository.PropertyRepoInterface;

import java.util.ArrayList;
import java.util.List;

public class PropertyService implements PropertySvcInterface{
    private PropertyRepoInterface propertyRepo;

    public PropertyService(PropertyRepoInterface propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public String add(Property p){
        if(propertyRepo.isPropertyExists(p.getId())){
            return null;
        }

        return propertyRepo.addProperty(p);
    }

    @Override
    public List<House> getHouses(Filter f) {
        List<House> houseList = new ArrayList<>();

        for(Property p:propertyRepo.getAll(f)){
            if(p instanceof House){
                houseList.add((House) p);
            }
        }

        return houseList;
    }

    @Override
    public List<Condo> getCondos(Filter f) {
        List<Condo> condoList = new ArrayList<>();

        for(Property p:propertyRepo.getAll(f)){
            if(p instanceof Condo){
                condoList.add((Condo) p);
            }
        }

        return condoList;
    }

    @Override
    public List<Apartment> getApartments(Filter f) {
        List<Apartment> apartmentList = new ArrayList<>();

        for(Property p:propertyRepo.getAll(f)){
            if(p instanceof Apartment){
                apartmentList.add((Apartment) p);
            }
        }

        return apartmentList;
    }

    @Override
    public List<Property> getProperties(Filter f) {
        return propertyRepo.getAll(f);
    }

    @Override
    public Property getProperty(String id) {
        return propertyRepo.getProperty(id);
    }
}
