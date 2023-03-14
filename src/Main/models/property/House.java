package Main.models.property;

public class House extends Property{
    int streetNo;

    public House(String streetName, String city, String postalCode, String province, String country, int streetNo) {
        super(streetName, city, postalCode, province, country);
        this.streetNo = streetNo;
    }
    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

//    @Override
//    public String toString() {
//        return "House{" +
//                "id='" + id +
//                ", streetNo=" + streetNo + '\'' +
//                ", streetName='" + streetName + '\'' +
//                ", city='" + city + '\'' +
//                ", postalCode='" + postalCode + '\'' +
//                ", province='" + province + '\'' +
//                ", country='" + country + '\'' +
//                ", isOccupied=" + isOccupied +
//                '}';
//    }

    @Override
    public String toString() {
        return "House{\nProperty ID: " + id +
                "\nAddress =" + streetNo + ", " + streetName + ", " + city +
                ", " + postalCode + ", " + province + ", " + country +
                "\nisOccupied = " + isOccupied +
                "}";
    }
}
