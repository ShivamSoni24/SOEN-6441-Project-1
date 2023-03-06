package controller;

import domain.Contract;
import service.ContractSvcInterface;

import java.time.LocalDate;

public class ContractController {
    private ContractSvcInterface contractSvc;
    public ContractController(ContractSvcInterface contractSvc) {
        this.contractSvc = contractSvc;
    }

    public boolean rentUnit(String tenantId, String propertyId, LocalDate startDate, LocalDate endDate, double monthlyRate) {
        Contract c = new Contract(tenantId, propertyId, startDate, endDate, monthlyRate);
        return contractSvc.createContract(c);
    }

}
