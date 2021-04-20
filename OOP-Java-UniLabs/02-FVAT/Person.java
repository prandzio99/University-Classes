// a class representing a person (or a shop) in an invoice
public class Person {

    // parameters
    private String name;
    private String address;
    private String nip;
    private String bankAccountNumber;

    // creator with given arguments
    public Person(String name, String address, String nip, String bankAccountNumber) {
        this.name = name;
        this.address = address;
        this.nip = nip;
        this.bankAccountNumber = bankAccountNumber;
    }

    // setters and getters
    public String getBankAccountNumber() {return bankAccountNumber;}

    public void setBankAccountNumber(String bankAccountNumber) {this.bankAccountNumber = bankAccountNumber;}

    public String getNIP() {return nip;}

    public void setNIP(String nip) {this.nip = nip;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}