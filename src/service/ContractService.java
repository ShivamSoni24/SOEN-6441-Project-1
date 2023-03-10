package service;

import models.Contract;
import models.property.Property;
import models.user.Tenant;
import models.user.User;
import repository.ContractRepoInterface;
import repository.PropertyRepoInterface;
import repository.UserRepoInterface;

public class ContractService implements ContractSvcInterface {
    private UserRepoInterface userRepo;
    private PropertyRepoInterface propertyRepo;
    private ContractRepoInterface contactRepo;

    public ContractService(UserRepoInterface userRepo, PropertyRepoInterface propertyRepo, ContractRepoInterface contractRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.contactRepo = contractRepo;
    }

    private Property getPropertyBy(String propertyId, String tenantId) throws Exception{
        Property p = propertyRepo.getProperty(propertyId);
        if (p.isOccupied()) {
            throw new Exception("property is already occupied");
        }

        User u = userRepo.get(tenantId);
        if(!(u instanceof Tenant)) {
            throw new Exception("tenant not found");
        }

        return p;
    }

    public String createContract(Contract c) throws Exception {
        Property p =  getPropertyBy(c.getPropertyId(), c.getPropertyId());

        p.setOccupied(true);

        // set property as occupied as we add a contract
        propertyRepo.updateProperty(c.getPropertyId(), p);

        return contactRepo.addContract(c);
    }

    public boolean deleteContract(Contract c) throws Exception {
        Property p =  getPropertyBy(c.getPropertyId(), c.getPropertyId());

        p.setOccupied(false);

        // set property as not occupied as we add a contract
        propertyRepo.updateProperty(c.getPropertyId(), p);

        return contactRepo.deleteContract(c.getId());
    }

    public Contract getContractBy(String id) {
        return contactRepo.getContract(id);
    }

    public Contract getContractBy(String propertyId, String tenantId) throws Exception{
        getPropertyBy(propertyId, tenantId);
        return contactRepo.getContract(propertyId, tenantId);
    }
}
