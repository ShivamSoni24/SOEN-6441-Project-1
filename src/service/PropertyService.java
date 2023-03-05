package service;

import domain.property.Property;
import repository.PropertyRepoInterface;

public class PropertyService implements PropertySvcInterface{
    private PropertyRepoInterface propertyRepo;

    public PropertyService(PropertyRepoInterface propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public String add(Property p){
        if(propertyRepo.isPropertyExists(p.getId())){
            return null;
        }

        return propertyRepo.addProperty(p);
    }





}
