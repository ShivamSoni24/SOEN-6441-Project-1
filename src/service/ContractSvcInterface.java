package service;

import models.Contract;

public interface ContractSvcInterface {
    String createContract(Contract c) throws Exception;
    boolean deleteContract(Contract c) throws Exception;
    Contract getContractBy(String Id);
    Contract getContractBy(String propertyId, String tenantId) throws Exception;
}
