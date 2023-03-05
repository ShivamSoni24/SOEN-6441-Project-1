package service;

public class ContractSvcInterface {
    private PropertySvcInterface propertySvc;
    private UserSvcInterface userSvc;
    public ContractSvcInterface(PropertySvcInterface propertySvc, UserSvcInterface userSvc) {
        this.propertySvc = propertySvc;
        this.userSvc = userSvc;
    }
}
