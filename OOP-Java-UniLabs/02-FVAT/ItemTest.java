import org.junit.*;

public class ItemTest {
    static Item testItem = new Item("Drabina", 1, 99.0, 0.23);

    @Test
    public void testGetGrossPrice() {
        Assert.assertEquals(testItem.getGrossPrice(), 121.77, 0.01);
    }

    @Test
    public void testGetVAT() {
        Assert.assertEquals(testItem.getVAT(), 0.23, 0.01);
    }

    @Test
    public void testSetVAT() {
        testItem.setVAT(0.22);
        Assert.assertEquals(testItem.getVAT(), 0.22, 0.01);
    }

    @Test
    public void testGetNetPrice() {
        Assert.assertEquals(testItem.getNetPrice(), 99.0, 0.01);
    }

    @Test
    public void testGetUnitPrice() {
        Assert.assertEquals(testItem.getUnitPrice(), 99.0, 0.01);
    }

    @Test
    public void testSetUnitPrice() {
        testItem.setUnitPrice(89.0);
        Assert.assertEquals(testItem.getUnitPrice(), 89.0, 0.01);
    }

    @Test
    public void testGetQuantity() {
        Assert.assertEquals(item.getQuantity(), 1);
    }

    @Test
    public void testSetQuantity() {
        testItem.setQuantity(5);
        Assert.assertEquals(testItem.getQuantity(), 5);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(testItem.getName(), "Drabina");
    }

}