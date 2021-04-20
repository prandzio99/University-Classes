public class Client {
    private String name;
    private String lastname;
    private String dob;

    public Client(String name, String lastname, String dob) {setValues(name, lastname, dob);}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getDateOfBirth() {return dob;}
    public void setDateOfBirth(String dob) {this.dob = dob;}

    private void setValues(String a, String b, String d) {this.name = a; this.lastname = b; this.dob = d;}
}