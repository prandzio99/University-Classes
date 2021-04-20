import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private Account acc;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        date = new Date();
        this.type = type;
    }

    public Transaction(double amount, String type, Account acc) {
        this(amount, type);
        this.acc = acc;
    }

    public Account getAccount() {return acc;}

    public double getAmount() {return amount;}

    public Date getDate() {return date;}

    @Override
    public String toString() {
        if (acc == null){return  "Date: "+date+" Amount: "+amount+" Type: "+type;} 
        else {return "Date: "+date+" Amount: "+amount+" Account: "+acc.getAccNr()+" Type: "+type;}
    }
}