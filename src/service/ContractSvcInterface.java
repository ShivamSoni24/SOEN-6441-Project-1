package service;

import models.Contract;
import models.user.Tenant;

import java.util.List;

public interface ContractSvcInterface {
    String createContract(Contract c) throws Exception;
    boolean deleteContract(String propertyId, String tenantId) throws Exception;
    Contract getContractBy(String Id);
    Contract getContractBy(String propertyId, String tenantId) throws Exception;
    List<Contract> getContracts();
    void addInterest(String propertyId, String tenantId) throws Exception;
}
