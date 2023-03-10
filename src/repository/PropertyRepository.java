package repository;

import models.Contract;
import models.property.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRepository implements PropertyRepoInterface {
    private final Map<String,Property> properties;
    private final Map<String, List<String>> tenantInterest;

    public PropertyRepository() {
        properties = new HashMap<>();
        tenantInterest = new HashMap<>();
    }

    @Override
    public boolean isPropertyExists(String id) {
        return properties.containsKey(id);
    }
    @Override
    public String addProperty(Property p) {
        properties.put(p.getId(), p.clone());

        return p.getId();
    }

    @Override
    public void updateProperty(String id, Property p){
        properties.put(id, p.clone());
    }
    @Override
    public boolean deleteProperty(String id){
        Property p = properties.remove(id);

        return p != null;
    }
    @Override
    public Property getProperty(String id){
        return properties.get(id).clone();
    }
    @Override
    public boolean addInterest(String propertyId, String tenantId) {
        List<String> temp;
        if(!tenantInterest.containsKey(propertyId)){
            temp = new ArrayList<>();
        } else {
            temp = tenantInterest.get(propertyId);
            if(temp.contains(tenantId)){
                return false;
            }
        }
        temp.add(tenantId);
        tenantInterest.put(propertyId, temp);
        return true;
    }
    @Override
    public List<String> getInterestedTenants(String propertyId){
        return tenantInterest.get(propertyId);
    }


    @Override
    public List<Property> getAll() {
        List<Property> propertyList = new ArrayList<>();

        for(Property p: properties.values()){
            propertyList.add(p.clone());
        }

        return propertyList;
    }
}
