package service;

import models.Contract;

import java.util.List;

public interface ContractSvcInterface {
    String createContract(Contract c) throws Exception;
    boolean deleteContract(Contract c) throws Exception;
    Contract getContractBy(String Id);
    Contract getContractBy(String propertyId, String tenantId) throws Exception;

    List<Contract> getContracts();
}
