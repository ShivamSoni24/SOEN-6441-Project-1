package repository;

import models.Contract;
import models.property.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRepository implements PropertyRepoInterface {
    private List<Property> properties;
    private Map<String, List<String>> tenantInterest;
    private List<Contract> contracts;

    public PropertyRepository() {
        properties = new ArrayList<>();
        tenantInterest = new HashMap<>();
        contracts = new ArrayList<>();
    }

    @Override
    public boolean isPropertyExists(String id) {
        for(Property p:properties){
            if(p.getId().equals(id)){
                return true;
            }
        }

        return false;
    }
    @Override
    public String addProperty(Property p) {
        properties.add(p.clone());

        return p.getId();
    }
    @Override
    public boolean deleteProperty(String id){
        for(int i=0; i<properties.size(); i++){
            if(properties.get(i).getId().equals(id)){
                properties.remove(i);
                return true;
            }
        }

        return false;
    }
    @Override
    public Property getProperty(String id){
        for(Property p:properties){
            if(p.getId().equals(id)){
                return p;
            }
        }

        return null;
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
        for(Contract c:contracts){
            if(c.getId().equals(id)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void addContract(Contract c) {
        contracts.add(c);
    }

    @Override
    public boolean deleteContract(String id) {
        for(int i=0; i<contracts.size(); i++){
            if(contracts.get(i).getId().equals(id)){
                contracts.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public Contract getContract(String id) {
        for(Contract c:contracts){
            if(c.getId().equals(id)){
                return c;
            }
        }

        return null;
    }

    @Override
    public List<Property> getAll() {
        return new ArrayList<>(properties);
    }
}
