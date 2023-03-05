package domain.property;

public abstract class Property implements Cloneable{
    private static int counter = 0;
    String id;
    String streetName;
    String city;
    String postalCode;
    String province;
    String country;
    boolean isOccupied;

    public Property(String streetName, String city, String postalCode, String province, String country) {
        this.id = String.valueOf(++counter);
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.isOccupied = false;
    }
    public String getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public Property clone() {
        try {
            return (Property) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

