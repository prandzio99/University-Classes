import org.junit.*;

public class ProductTest {
    @Test
    public void getCode() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        Assert.assertEquals(product.getCode(), "ABCD0123");
    }

    @Test
    public void setCode() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        product.setCode("EFGH4567");
        Assert.assertEquals(product.getCode(), "12");
    }

    @Test
    public void getName() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        Assert.assertEquals(product.getName(), "ABC");
    }

    @Test
    public void setName() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        product.setName("DEF");
        Assert.assertEquals(product.getName(), "DEF");
    }

    @Test
    public void getPrice() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        Assert.assertEquals(product.getPrice(), 1.00, 0.001);
    }

    @Test
    public void setPrice() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        product.setPrice(2.00);
        Assert.assertEquals(product.getPrice(), 2.00, 0.001);
    }

    @Test
    public void getDiscountPrice() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        Assert.assertEquals(product.getDiscountPrice(), 1.00, 0.001);
    }

    @Test
    public void setDiscountPrice() {
        Product product = new Product("ABCD0123", "ABC", 1.00);
        product.setDiscountPrice(0.50);
        Assert.assertEquals(product.getDiscountPrice(), 0.50, 0.001);
    }
}