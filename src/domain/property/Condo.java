package domain.property;

public class Condo extends BuildingUnit {
    int condoNo;

    public Condo(String streetName, String city, String postalCode, String province, String country, int condoNo) {
        super(streetName, city, postalCode, province, country);
        this.condoNo = condoNo;
    }

    public int getCondoNo() {
        return condoNo;
    }

    public void setCondoNo(int condoNo) {
        this.condoNo = condoNo;
    }
}
