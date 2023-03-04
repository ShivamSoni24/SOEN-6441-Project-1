package service;

import domain.property.Property;
import repository.PropertyRepoInterface;

public class PropertyService implements PropertySvcInterface{
    private PropertyRepoInterface propertyRepo;

    public PropertyService(PropertyRepoInterface propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public void add(Property p){
        if(propertyRepo.isPropertyExists(p.getId())){
            return;
        }

        propertyRepo.addProperty(p);
    }




}
