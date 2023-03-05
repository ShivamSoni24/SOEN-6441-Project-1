package controller;

import service.ContractSvcInterface;

public class ContractController {
    private ContractSvcInterface contractSvc;
    public ContractController(ContractSvcInterface contractSvc) {
        this.contractSvc = contractSvc;
    }

}
