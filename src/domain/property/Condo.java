package domain.property;

public class Condo extends BuildingUnit {
    int condoNo;

    public Condo(String streetName, String city, String postalCode, String province, String country, int condoNo, int noOfBedrooms, int noOfBathrooms, double squareFootArea) {
        super(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootArea);
        this.condoNo = condoNo;
    }

    public int getCondoNo() {
        return condoNo;
    }

    public void setCondoNo(int condoNo) {
        this.condoNo = condoNo;
    }

    @Override
    public String toString() {
        return "Condo{" +
                "id='" + id +
                ", condoNo=" + condoNo + '\'' +
                ", noOfBedrooms=" + noOfBedrooms +
                ", noOfBathrooms=" + noOfBathrooms +
                ", squareFootArea=" + squareFootArea +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
