package models;

import models.user.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class Contract implements Cloneable{
    private static int counter = 0;
    String id;
    String tenantId;
    String propertyId;
    LocalDate startDate;
    LocalDate endDate;
    double monthlyRate;
    HashSet<String> rentStatus;

    public Contract(String tenantId, String propertyId, LocalDate endDate, double monthlyRate) {
        this.id = String.valueOf(++counter);
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.startDate = LocalDate.now();
        this.endDate = endDate;
        this.monthlyRate = monthlyRate;
        this.rentStatus = new HashSet<>();
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

    public boolean getRentStatus(int month, int year) {
        return rentStatus.contains(month+"-"+year);
    }

    public boolean setRentStatus(int month, int year) {
        if (rentStatus.contains(month+"-"+year)) return false;
        rentStatus.add(month+"-"+year);
        return true;
    }

    @Override
    public Contract clone() {
        try {
            return (Contract) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthlyRate=" + monthlyRate +
                '}';
    }
}
