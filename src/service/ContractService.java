package service;

import models.Contract;

public class ContractService implements ContractSvcInterface {
    private UserSvcInterface userSvc;
    private PropertySvcInterface propertySvc;

    public ContractService(UserSvcInterface userSvc, PropertySvcInterface propertySvc) {
        this.propertySvc = propertySvc;
        this.userSvc = userSvc;
    }

    public boolean createContract(Contract c) {
        if (propertySvc.getProperty(c.getPropertyId()).isOccupied()) {
            return false;
        }

        if(userSvc.getTenant(c.getTenantId())==null) {
            return false;
        }

        //create contract

        return true;
    }
}
