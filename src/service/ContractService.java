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
    private ContractRepoInterface contractRepo;

    public ContractService(UserRepoInterface userRepo, PropertyRepoInterface propertyRepo, ContractRepoInterface contractRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.contractRepo = contractRepo;
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

        return contractRepo.addContract(c);
    }

    public boolean deleteContract(String propertyId, String tenantId) throws Exception {
        Property p = propertyRepo.getProperty(propertyId);
        if (p == null) {
            throw new Exception("property not found");
        }

        Contract c = contractRepo.getContract(propertyId, tenantId);
        if(c==null) {
            throw new Exception("contract not found");
        }

        // set property as not occupied as we add a contract
        p.setOccupied(false);
        propertyRepo.updateProperty(propertyId, p);

        propertyRepo.notifyAll(propertyId);

        return contractRepo.deleteContract(c.getId());
    }

    public Contract getContractBy(String id) {
        return contractRepo.getContract(id);
    }

    public Contract getContractBy(String propertyId, String tenantId) throws Exception{
        getPropertyAndCheckUser(propertyId, tenantId);
        return contractRepo.getContract(propertyId, tenantId);
    }

    public List<Contract> getContracts() {
        return contractRepo.getContracts();
    }

    public void addInterest(String propertyId, String tenantId) throws Exception {
        Property p = propertyRepo.getProperty(propertyId);
        if (p == null) {
            throw new Exception("property not found");
        }

        User u = userRepo.get(tenantId);
        if(!(u instanceof Tenant)) {
            throw new Exception("tenant not found");
        }

        propertyRepo.addInterest(propertyId, (Tenant) u);
    }

    public boolean getRentStatus(String propertyId, String tenantId, int month, int year) throws Exception {
        Contract c = this.getContractBy(propertyId, tenantId);
        return c.getRentStatus(month, year);
    }

    public void setRentStatus(String propertyId, String tenantId, int month, int year) throws Exception {
        Contract c = this.getContractBy(propertyId, tenantId);

        c.setRentStatus(month, year);
        contractRepo.updateContract(c);
    }
}
