package Main.observer;

import Main.models.property.Property;
import Main.models.user.Tenant;

import java.util.List;

public interface Observer {
    Tenant update(Property p);
}
