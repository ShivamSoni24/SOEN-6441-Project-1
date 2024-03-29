package Main.repository;

import Main.models.property.Property;
import Main.models.user.Tenant;

import java.util.List;

public interface PropertyRepoInterface {
    boolean isPropertyExists(String id);
    String addProperty(Property p);
    void updateProperty(String id, Property p);
    boolean deleteProperty(String id);
    Property getProperty(String id);
    void addInterest(String propertyId, Tenant t);
    List<Property> getAll(Filter f);
    List<Tenant> notifyAll(String propertyId);
}
