import java.util.*;

public class Account {
    private Client client;
    private String accNr;
    private double balance;
    private ArrayList<Transaction> log = new ArrayList<>();

    public Account(Client client, String accNr) {
        this.client = client;
        this.accNr = accNr;
        balance = 0.0;
    }

    public Client getClient() {return client;}

    public void setClient(Client client) {this.client = client;}

    public String getAccNr() {return accNr;}

    public double getBalance() {return balance;}

    private void changeBalance(double amount) {balance += amount;}

    public void deposit(double amount){
        changeBalance(amount);
        Transaction transaction = new Transaction(amount, "Deposit");
        log.add(transaction);
    }

    public void withdraw(double amount){
        changeBalance(-amount);
        Transaction transaction = new Transaction(-amount, "Withdrawal");
        log.add(transaction);
    }

    public void outTransfer(double amount, Account to){
        to.inTransfer(amount, this);
        changeBalance(-amount);
        Transaction transaction = new Transaction(-amount, "Outcoming Transfer", to);
        log.add(transaction);
    }

    private void inTransfer(double amount, Account from){
        changeBalance(amount);
        Transaction transaction = new Transaction(amount, "Incoming Transfer", from);
        log.add(transaction);
    }

    public void printLog(){
        System.out.println("Log: ");
        log.forEach(l -> {System.out.println(l.toString());});
    }

    public void accountLog(Date from, Date until){
        System.out.println("Log from " + from.toString()+ " until " + until.toString());
        log.iterator().forEachRemaining(p-> {if((from.compareTo(p.getDate()) <= 0) && (until.compareTo(p.getDate()) >= 0)) System.out.println(p.toString());});
    }
}