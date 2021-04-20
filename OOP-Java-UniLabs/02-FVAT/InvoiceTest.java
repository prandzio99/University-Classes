import org.junit.*;
import java.time.LocalDate;
import java.util.*;

public class InvoiceTest {
    final Person client = new Person("Jan Nowak", "Aleja Grunwaldzka 189/14, Gdansk", "123-456-78-90", "17 2039 5474 0000 3111 0127 3051");
    final Person seller = new Person("Castorama", "Aleja Grunwaldzka 262, Gdansk", "010-243-16-07", "53 2343 7801 0000 1031 0251 1171");
    static final String TESTDATE = "2020-01-04";
    static final List<Item> TESTITEMS = Arrays.asList(new Item("Drabina", 1, 99.0, 0.23), new Item("Sekator", 1, 29.9, 0.23), new Item("Przedłużacz", 2, 24.5, 0.23));

    @Test
    public void testGetItems() {
        Invoice invoice = new Invoice(client, seller);
        ArrayList<Item> items = new ArrayList<>();
        Assert.assertEquals(invoice.getItems(), items);
    }

    @Test
    public void testAddItem() {
        Invoice invoice = new Invoice(client, seller);
        ArrayList<Item> items = new ArrayList<>();
        Item item = TESTITEMS[0];
        invoice.addItem(item);        
        items.add(item);
        Assert.assertEquals(invoice.getItems(), items);
    }

    @Test
    public void testGetClient() {
        Invoice invoice = new Invoice(client, seller);
        Assert.assertEquals(invoice.getClient(), client);

    }

    @Test
    public void testSetClient() {
        Invoice invoice = new Invoice(client, seller);
        Person client2 = new Person("Marek Kowalski", "Zamenhofa 5/7, Gdansk", "132-461-77-91", "21 0936 7002 0000 3441 0124 2115");
        invoice.setClient(client2);
        Assert.assertEquals(invoice.getClient(), client2);
    }

    @Test
    public void testSellTime() {
        Invoice invoice = new Invoice(client, seller);
        invoice.setSellTime(LocalDate.parse(TESTDATE));
        Assert.assertEquals(invoice.getSellTime(), LocalDate.parse(TESTDATE));
    }

    @Test
    public void testPaymentTime() {
        Invoice invoice = new Invoice(client, seller);
        invoice.setPaymentTime(LocalDate.parse(TESTDATE));
        Assert.assertEquals(invoice.getPaymentTime(), LocalDate.parse(TESTDATE));
    }

    @Test
    public void testGetSum() {
        Invoice invoice = new Invoice(client, seller);
        Item item1 = TESTITEMS[1];
        Item item2 = TESTITEMS[2];
        invoice.addItem(item1);
        invoice.addItem(item2);
        Assert.assertEquals(invoice.getSum(), 97.047, 0.001);
    }

    @Test
    public void testGetInvoiceNumber() {
        Invoice invoice = new Invoice(client, seller);
        Invoice invoice2 = new Invoice(client, seller);
        Assert.assertEquals(invoice2.getInvoiceNumber(), invoice.getInvoiceNumber() + 1);
    }

    @Test
    public void testRemoveItem() {
        Invoice invoice = new Invoice(client, seller);
        Item item1 = TESTITEMS[1];
        Item item2 = TESTITEMS[2];
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.removeItem("Sekator");
        Assert.assertEquals(invoice.getItems().size(), 1);
    }

    @Test
    public void testEditItem() {
        Invoice invoice = new Invoice(client, seller);
        Item item = TESTITEMS[1];
        Item item2 = new Item("Sekator", 1, 24.9, 0.23);
        invoice.addItem(item);
        invoice.editItem(item, item2);
        Assert.assertEquals(invoice.getItem("Sekator"), item2);

    }

    @Test
    public void testGetItem() {
        Invoice invoice = new Invoice(client, seller);
        Item item = TESTITEMS[1];
        invoice.addItem(item);
        Assert.assertEquals(invoice.getItem("Pepsi"), item);
    }
}