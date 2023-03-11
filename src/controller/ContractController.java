package controller;

import models.Contract;
import service.ContractSvcInterface;

import java.time.LocalDate;
import java.util.List;

public class ContractController {
    private ContractSvcInterface contractSvc;
    public ContractController(ContractSvcInterface contractSvc) {
        this.contractSvc = contractSvc;
    }

    public String rentUnit(String tenantId, String propertyId, LocalDate endDate, double monthlyRate) throws Exception{
        Contract c = new Contract(tenantId, propertyId, endDate, monthlyRate);
        return contractSvc.createContract(c);
    }

    public List<Contract> getLeases(){
        return contractSvc.getContracts();
    }

    public boolean terminateContract(String propertyId, String tenantId) throws Exception{
        return contractSvc.deleteContract(propertyId, tenantId);
    }

    public void registerInterest(String propertyId, String tenantId) throws Exception{
        contractSvc.addInterest(propertyId, tenantId);
    }

    public boolean getRentStatus(String propertyId, String tenantId, int month, int year) throws Exception {
        return contractSvc.getRentStatus(propertyId, tenantId, month, year);
    }

    public void setRentStatus(String propertyId, String tenantId, int month, int year) throws Exception {
        contractSvc.setRentStatus(propertyId, tenantId, month, year);
    }
}
