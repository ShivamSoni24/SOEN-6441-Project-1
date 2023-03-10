package controller;

import models.Contract;
import service.ContractSvcInterface;

import java.time.LocalDate;

public class ContractController {
    private ContractSvcInterface contractSvc;
    public ContractController(ContractSvcInterface contractSvc) {
        this.contractSvc = contractSvc;
    }

    public String rentUnit(String tenantId, String propertyId, LocalDate endDate, double monthlyRate) throws Exception{
        Contract c = new Contract(tenantId, propertyId, endDate, monthlyRate);
        return contractSvc.createContract(c);
    }

}
