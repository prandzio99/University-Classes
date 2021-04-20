import org.junit.*;
import java.util.*;

public class CartTest {

    @Test
    public void test_addProduct() {
        Cart cart = new Cart(false);
        Product product = new Product("FXTV3021", "Monitor LCD 21.5\"", 799.99);
        cart.addProduct(product);
        Assert.assertEquals(cart.cheapestProduct(), product);
    }

    @Test
    public void test_sortList() {
        Product product1 = new Product("ABCD0123", "a", 18.00);
        Product product2 = new Product("EFGH4567", "b", 17.00);
        Product product3 = new Product("IJKL8901", "c", 16.00);
        Product product4 = new Product("MNOP2345", "d", 15.00);
        Product product5 = new Product("QRST6789", "e", 14.00);
        Cart cart = new Cart(new ArrayList<Product>(Arrays.asList(product1,product2, product3, product4,product5)), false);
        cart.sortList();
        cart.showProducts();
    }

    @Test
    public void test_cheapestProduct() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        Assert.assertEquals(cart.cheapestProduct(), product2);
    }

    @Test
    public void test_mostExpensiveProduct() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        Assert.assertEquals(cart.mostExpensiveProduct(), product1);
    }

    @Test
    public void test_cheapestProducts() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        Assert.assertEquals(cart.cheapestProducts(2), new ArrayList<>(Arrays.asList(product2, product3)));
    }

    @Test
    public void test_mostExpesiveProducts() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        Assert.assertEquals(cart.mostExpensiveProducts(2), new ArrayList<>(Arrays.asList(product1, product3)));
    }

    @Test
    public void test_sortByPrice() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.sortByPrice(false);
        cart.showProducts();
    }

    @Test
    public void test_sortByName() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.sortByName(false);
        cart.showProducts();
    }

    @Test
    public void test_applyDiscountsMoreThan200() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.applyDiscounts();
        cart.showProducts();
    }

    @Test
    public void test_applyDiscountsWithCoupon() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        cart.addProduct(product1);
        cart.applyVoucher(product1);
        Assert.assertEquals(cart.cheapestProduct().getDiscountPrice(), 454.994, 0.001);
    }


    @Test
    public void test_showProducts() {
        Cart cart = new Cart(false);
        Product product1 = new Product("AAAA0123", "Monitor LCD 17.5\"", 649.99);
        Product product2 = new Product("BBBB0124", "Keyboard", 89.99);
        Product product3 = new Product("CCCC0125", "Printer", 349.99);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.showProducts();
    }
}