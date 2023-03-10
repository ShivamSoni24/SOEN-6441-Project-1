package repository;

import models.Contract;

public interface ContractRepoInterface {
    String addContract(Contract c);
    boolean deleteContract(String id);
    Contract getContract(String id);
    Contract getContract(String propertyId, String tenantId);
    boolean isContractExists(String id);
}
