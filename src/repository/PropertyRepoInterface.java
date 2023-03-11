package repository;

import models.property.Property;
import models.user.Tenant;

import java.util.List;

public interface PropertyRepoInterface {
    boolean isPropertyExists(String id);
    String addProperty(Property p);
    void updateProperty(String id, Property p);
    boolean deleteProperty(String id);
    Property getProperty(String id);
    void addInterest(String propertyId, Tenant t);
    List<Property> getAll(Filter f);
    void notifyAll(String propertyId);
}
