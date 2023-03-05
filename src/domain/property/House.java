package domain.property;

public class House extends Property{
    int houseNo;
    int streetNo;

    public House(String streetName, String city, String postalCode, String province, String country,
                 int houseNo, int streetNo) {
        super(streetName, city, postalCode, province, country);
        this.houseNo = houseNo;
        this.streetNo = streetNo;
    }


    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }
}
