package service;

import models.Contract;
import models.property.Property;
import models.user.Tenant;
import models.user.User;
import repository.ContractRepoInterface;
import repository.PropertyRepoInterface;
import repository.UserRepoInterface;

import java.util.List;

public class ContractService implements ContractSvcInterface {
    private UserRepoInterface userRepo;
    private PropertyRepoInterface propertyRepo;
    private ContractRepoInterface contactRepo;

    public ContractService(UserRepoInterface userRepo, PropertyRepoInterface propertyRepo, ContractRepoInterface contractRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.contactRepo = contractRepo;
    }

    private Property getPropertyAndCheckUser(String propertyId, String tenantId) throws Exception{
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
        Property p =  getPropertyAndCheckUser(c.getPropertyId(), c.getPropertyId());

        p.setOccupied(true);

        // set property as occupied as we add a contract
        propertyRepo.updateProperty(c.getPropertyId(), p);

        return contactRepo.addContract(c);
    }

    public boolean deleteContract(String propertyId, String tenantId) throws Exception {
        Property p = getPropertyAndCheckUser(propertyId, tenantId);

        Contract c = contactRepo.getContract(propertyId, tenantId);
        if(c==null) {
            throw new Exception("contract not found");
        }

        // set property as not occupied as we add a contract
        p.setOccupied(false);
        propertyRepo.updateProperty(propertyId, p);

        p.notifyListeners();

        return contactRepo.deleteContract(c.getId());
    }

    public Contract getContractBy(String id) {
        return contactRepo.getContract(id);
    }

    public Contract getContractBy(String propertyId, String tenantId) throws Exception{
        getPropertyAndCheckUser(propertyId, tenantId);
        return contactRepo.getContract(propertyId, tenantId);
    }

    public List<Contract> getContracts() {
        return contactRepo.getContracts();
    }
}
