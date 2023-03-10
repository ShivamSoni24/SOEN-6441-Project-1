package repository;

import models.Contract;
import models.property.Property;

import java.util.List;

public interface PropertyRepoInterface {
    boolean isPropertyExists(String id);
    String addProperty(Property p);
    void updateProperty(String id, Property p);
    boolean deleteProperty(String id);
    Property getProperty(String id);
    boolean addInterest(String propertyId, String tenantId);
    List<String> getInterestedTenants(String propertyId);
    List<Property> getAll(Filter f);
}
