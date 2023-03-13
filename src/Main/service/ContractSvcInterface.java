package Main.service;

import Main.models.Contract;

import java.util.List;

public interface ContractSvcInterface {
    String createContract(Contract c) throws Exception;
    boolean deleteContract(String propertyId, String tenantId) throws Exception;
    Contract getContractBy(String Id);
    Contract getContractBy(String propertyId, String tenantId) throws Exception;
    List<Contract> getContracts();
    void addInterest(String propertyId, String tenantId) throws Exception;
    boolean getRentStatus(String propertyId, String tenantId, int month, int year) throws Exception;
    void setRentStatus(String propertyId, String tenantId, int month, int year) throws Exception;
}
