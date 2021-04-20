import org.junit.*;
import java.util.Date;

public class TransactionTest {

    @Test
    public void test_getAccount() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        Account account = new Account(client, "66 3377 5435 0000 1101 1425 7777");
        Transaction transaction = new Transaction(-200.0, "Outcoming Transger", account);
        Assert.assertEquals(transaction.getAccount(), account);
    }

    @Test
    public void test_getAmount() {
        Transaction transaction = new Transaction(200.0, "Deposit");
        Assert.assertEquals(transaction.getAmount(), 200.0, 0.001);
    }

    @Test
    public void test_getDate() {
        Transaction transaction = new Transaction(200.0, "Deposit");
        Assert.assertEquals(transaction.getDate(), new Date());
    }
}