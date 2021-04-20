import org.junit.*;
import java.util.Calendar;
import java.util.Date;

public class AccountTest {

    @Test
    public void test_getClient() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Assert.assertEquals(account.getClient(), client);
    }

    @Test
    public void test_setClient() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Client client2 = new Client("Eric", "Trump", "1984/01/06");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        account.setClient(client2);
        Assert.assertEquals(account.getClient(), client2);
    }

    @Test
    public void test_getAccountNumber() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Assert.assertEquals(account.getAccNr(), "66 3377 5435 0000 1101 1425 7777");
    }

    @Test
    public void test_getBalance() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Assert.assertEquals(account.getBalance(), 0.0, 0.001);
    }

    @Test
    public void test_deposit() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        account.deposit(400.0);
        Assert.assertEquals(account.getBalance(), 400.0, 0.001);
    }

    @Test
    public void test_withdraw() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        account.deposit(400.0);
        account.withdraw(200.0);
        Assert.assertEquals(account.getBalance(), 200.0, 0.001);
    }

    @Test
    public void test_transfers() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Client client2 = new Client("Zelensky", "Volodimir", "1978/01/25");
        Account account2 = new Account(client, "42 2314 6421 0002 1222 7722 5698");
        account.deposit(400.0);
        account.outTransfer(200, account2);
        Assert.assertEquals(account.getBalance(), 200.0, 0.001);
    }

    @Test
    public void test_printLog() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Client client2 = new Client("Zelensky", "Volodimir", "1978/01/25");
        Account account2 = new Account(client, "42 2314 6421 0002 1222 7722 5698");
        account.deposit(400.0);
        account.outTransfer(200, account2);
        account2.outTransfer(100, account);
        account.withdraw(100);
        account.printLog();
    }

    @Test
    public void test_accountLog() {
        Client client = new Client ("Krzysztof", "Krawczyk", new Date());
        Client client2 = new Client ("Jan", "Kowalski", new Date());
        Account account = new Account(client, "123456789");
        Account account2 = new Account(client2, "987654321");
        account.deposit(400.0);
        account.outTransfer(200, account2);
        account2.outTransfer(100, account);
        account.withdraw(100);
        Calendar cal = Calendar.getInstance();
        cal.set(2020, Calendar.JANUARY,3);
        Date from = cal.getTime();
        cal.set(2020, Calendar.JANUARY,5);
        Date to = cal.getTime();
        account.accountLog(from, to);
    }
}