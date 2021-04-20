import java.time.LocalDate;
import java.util.ArrayList;

// a class representing an invoice

public class Invoice {
    // parameters
    private static int number = 0;
    private String invoiceTitle = "FVAT/"+LocalDate.now().getYear()+"/"+LocalDate.now().getMonthValue()+"/";
    private String invoiceNumber;
    private ArrayList<Item> items;
    private Person client;
    private Person seller;
    private LocalDate creationTime;
    private LocalDate saleTime;
    private LocalDate payTime;
    private double sum;

    // creator with client and seller as arguments
    public Invoice(Person client, Person seller) {
        number++;
        this.client = client;
        this.seller = seller;
        this.creationTime = LocalDate.now();
        this.items = new ArrayList<>();
        this.invoiceNumber = invoiceTitle+number;
    }

    // method returning a list of items
    public List<Item> getItems() {return items;}

    // method adding an item to list
    public void addItem(Item item) {
        this.items.add(item);
        calculateSum();
    }

    // method removing item from list
    public void removeItem(String name) {
         if (!items.removeIf(item -> item.getName() == name)) {
             throw new IllegalArgumentException("Item not found!");
         }
        calculateSum();
    }

    // a number of setters and getters
    public Person getClient() {return client;}

    public void setClient(Person client) {this.client = client;}

    public Person getSeller() {return seller;}

    public void setSeller(Person seller) {this.seller = seller;}

    public LocalDate getCreationTime() {return creationTime;}

    public LocalDate getSellTime() {return saleTime;}

    public void setSellTime(LocalDate saleTime) {this.saleTime = saleTime;}
    
    public LocalDate getPaymentTime() {return payTime;}

    public void setPaymentTime(LocalDate payTime) {this.payTime = payTime;}

    public String getInvoiceNumber() {return this.invoiceNumber;}

    public double getSum(){return this.sum;}

    // method to edit an item from the list
    public void editItem(Item editItem, Item newItem) {
        this.removeItem(editItem.getName());
        this.addItem(newItem);
    }

    public Item getItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName() == name){
                return items.get(i);
            }
        }
        throw new IllegalArgumentException("Item not found!");
    }

    private void calculateSum() {
        sum = 0;
        items.forEach(item -> sum += item.getGrossPrice());
    }
}