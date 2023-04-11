package Main.observer;

import Main.models.user.Tenant;

import java.util.List;

public interface Subject {
    void addListener(Observer o);
    void removeListener(Observer o);
    List<Tenant> notifyListeners();
}
