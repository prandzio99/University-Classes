// a class representing an invoice item
public class Item {

    // parameters
    private String name;
    private int quantity;
    private double unitPrice;
    private double netPrice;
    private double vat;
    private double grossPrice;

    // creator with given arguments
    public Item(String name, int quantity, double unitPrice, double vat ) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.vat = vat;
        this.netPrice = this.unitPrice * this.quantity;
        this.grossPrice = this.netPrice * (1+this.vat);
    }

    // creator with no arguments
    public Item(){}

    // setters and getters
    public void setName(String name) {this.name = name;}    

    public String getName() {return name;}    

    public void setQuantity(int quantity) {this.quantity = quantity;}    
    
    public int getQuantity() {return quantity;}
    
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
        
    public double getUnitPrice() {return unitPrice;}

    public double getNetPrice() {return netPrice;}
    
    public void setVAT(double vat) {this.vat = vat;}

    public double getVAT() {return vat;}

    public double getGrossPrice() {return grossPrice;}
}