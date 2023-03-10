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
    private final Map<String,Contract> contracts;

    public PropertyRepository() {
        properties = new HashMap<>();
        tenantInterest = new HashMap<>();
        contracts = new HashMap<>();
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
    public boolean deleteProperty(String id){
        Property p = properties.remove(id);

        return p != null;
    }
    @Override
    public Property getProperty(String id){
        return properties.get(id);
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
    public boolean isContractExists(String id) {
        return contracts.containsKey(id);
    }

    @Override
    public void addContract(Contract c) {
        contracts.put(c.getId(), c);
    }

    @Override
    public boolean deleteContract(String id) {
        Contract c = contracts.remove(id);

        return c!=null;
    }

    @Override
    public Contract getContract(String id) {
        return contracts.get(id);
    }

    @Override
    public List<Property> getAll() {
        return new ArrayList<>(properties.values());
    }
}
