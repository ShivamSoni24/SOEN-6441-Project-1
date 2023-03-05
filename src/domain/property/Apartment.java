package domain.property;

public class Apartment extends BuildingUnit{
    int aptNo;

    public Apartment(String streetName, String city, String postalCode, String province, String country, int aptNo) {
        super(streetName, city, postalCode, province, country);
        this.aptNo = aptNo;
    }
}
