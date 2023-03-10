package repository;

import models.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractRepository implements ContractRepoInterface{
    private Map<String,Contract> contracts;

    public ContractRepository() {
        this.contracts = new HashMap<>();
    }

    @Override
    public String addContract(Contract c) {
        contracts.put(c.getId(), c.clone());

        return c.getId();
    }

    @Override
    public boolean deleteContract(String id) {
        Contract c = contracts.remove(id);

        return c!=null;
    }

    @Override
    public Contract getContract(String id) {
        return contracts.get(id).clone();
    }

    @Override
    public Contract getContract(String propertyId, String tenantId){
        for(Map.Entry<String, Contract> e:contracts.entrySet()){
            if(e.getValue().getPropertyId().equals(propertyId) && e.getValue().getTenantId().equals(tenantId)){
                return e.getValue().clone();
            }
        }

        return null;
    }
    @Override
    public boolean isContractExists(String id) {
        return contracts.containsKey(id);
    }

    @Override
    public List<Contract> getContracts() {
        List<Contract> contractList = new ArrayList<>();
        for(Contract c: contracts.values()){
            contractList.add(c.clone());
        }

        return contractList;
    }
}
