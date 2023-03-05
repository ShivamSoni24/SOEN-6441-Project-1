package controller;

import service.PropertySvcInterface;

public class PropertyController {

    private PropertySvcInterface propertySvc;

    public PropertyController(PropertySvcInterface propertySvc) {
        this.propertySvc = propertySvc;
    }
}
