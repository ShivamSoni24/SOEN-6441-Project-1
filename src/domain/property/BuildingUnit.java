package domain.property;

public class BuildingUnit extends Property {
    int noOfBedrooms;
    int noOfBathrooms;
    double squareFootArea;

    public BuildingUnit(String streetName, String city, String postalCode, String province, String country) {
        super(streetName, city, postalCode, province, country);
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public double getSquareFootArea() {
        return squareFootArea;
    }

    public void setSquareFootArea(double squareFootArea) {
        this.squareFootArea = squareFootArea;
    }

}
