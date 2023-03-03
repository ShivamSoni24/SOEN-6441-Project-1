package service;

import domain.property.Property;
import repository.PropertyRepoInterface;

public class PropertyService {
    private PropertyRepoInterface propertyRepo;

    public PropertyService(PropertyRepoInterface propertyRepository) {
        this.propertyRepo = propertyRepository;
    }

    public void add(Property p){
        if(propertyRepo.isPropertyExists(p.getId())){
            return;
        }

        propertyRepo.addProperty(p);
    }




}
