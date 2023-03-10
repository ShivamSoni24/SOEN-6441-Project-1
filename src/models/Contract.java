package models;

import java.time.LocalDate;

public class Contract {
    private static int counter = 0;
    String id;
    String tenantId;
    String propertyId;
    LocalDate startDate;
    LocalDate endDate;
    double monthlyRate;

    public Contract(String tenantId, String propertyId, LocalDate startDate, LocalDate endDate, double monthlyRate) {
        this.id = String.valueOf(++counter);
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRate = monthlyRate;
    }

    public String getId() {
        return id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

}
