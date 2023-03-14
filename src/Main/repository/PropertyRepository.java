package Main.repository;

import Main.models.property.Property;
import Main.models.user.Tenant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRepository implements PropertyRepoInterface {
    private final Map<String,Property> properties;

    public PropertyRepository() {
        properties = new HashMap<>();
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
    public void addInterest(String propertyId, Tenant t) {
        Property p = properties.get(propertyId);
        p.addListener(t);
    }

    @Override
    public List<Property> getAll(Filter f) {
        List<Property> propertyList = new ArrayList<>();

        for(Property p: properties.values()){
            if(f.equals(Filter.RENTED) && p.isOccupied()){
                propertyList.add(p.clone());
            } else if(f.equals(Filter.VACANT) && !p.isOccupied()){
                propertyList.add(p.clone());
            } else if(f.equals(Filter.ALL)){
                propertyList.add(p.clone());
            }
        }

        return propertyList;
    }

    @Override
    public void notifyAll(String propertyId) {
        Property p = properties.get(propertyId);

        p.notifyListeners();
    }
}
