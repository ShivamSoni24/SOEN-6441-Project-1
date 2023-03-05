package repository;

import domain.Contract;
import domain.property.Property;

import java.util.List;

public interface PropertyRepoInterface {
    boolean isPropertyExists(String id);
    String addProperty(Property p);
    boolean deleteProperty(String id);
    Property getProperty(String id);
    boolean addInterest(String propertyId, String tenantId);
    List<String> getInterestedTenants(String propertyId);
    boolean isContractExists(String id);
    void addContract(Contract c);
    boolean deleteContract(String id);
    Contract getContract(String id);
}
