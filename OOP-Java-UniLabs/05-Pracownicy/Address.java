public class Address {
    private String street;
    private int building;
    private int locale;
    private String city;

    public Address(String s, int b, int l, String c) {
        street = s;
        building = b; 
        locale = l;
        city = c;
    }

    public String getStreet() {return street;}
    public void setStreet(String s) {street = s;}
    public int getBuilding() {return building;}
    public void setBuilding(int b) {building = b;}
    public int getLocale() {return locale;}
    public void setLocale(int l) {locale = l;}
    public String getCity() {return city;}
    public void setCity(String c) {city = c;}
    public String toString() {return street+" "+building+"/"+locale+", "+city;}
}