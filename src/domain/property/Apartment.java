package domain.property;

public class Apartment extends BuildingUnit{
    int aptNo;

    public Apartment(String streetName, String city, String postalCode, String province, String country, int aptNo, int noOfBedrooms, int noOfBathrooms, double squareFootArea) {
        super(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootArea);
        this.aptNo = aptNo;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "aptNo=" + aptNo +
                ", noOfBedrooms=" + noOfBedrooms +
                ", noOfBathrooms=" + noOfBathrooms +
                ", squareFootArea=" + squareFootArea +
                ", id='" + id + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
