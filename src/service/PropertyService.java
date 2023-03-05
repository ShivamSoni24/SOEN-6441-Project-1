package service;

import domain.property.Apartment;
import domain.property.Condo;
import domain.property.House;
import domain.property.Property;
import domain.user.Admin;
import domain.user.Tenant;
import domain.user.User;
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
    public List<House> getHouses() {
        List<House> houseList = new ArrayList<>();

        for(Property p:propertyRepo.getAll()){
            if(p instanceof House){
                houseList.add((House) p);
            }
        }

        return houseList;
    }

    @Override
    public List<Condo> getCondos() {
        List<Condo> condoList = new ArrayList<>();

        for(Property p:propertyRepo.getAll()){
            if(p instanceof Condo){
                condoList.add((Condo) p);
            }
        }

        return condoList;
    }

    @Override
    public List<Apartment> getApartments() {
        List<Apartment> apartmentList = new ArrayList<>();

        for(Property p:propertyRepo.getAll()){
            if(p instanceof Apartment){
                apartmentList.add((Apartment) p);
            }
        }

        return apartmentList;
    }

    @Override
    public List<Property> getProperties() {
        return propertyRepo.getAll();
    }
}
