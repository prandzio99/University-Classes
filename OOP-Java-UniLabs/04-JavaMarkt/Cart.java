import java.util.*;

public class Cart {
    private ArrayList<Product> list;
    private boolean voucher;

    public Cart(ArrayList<Product> list, boolean voucher) {this.list = list; this.voucher = voucher;}

    public Cart(Product product, boolean voucher) {
        this(new ArrayList<Product>(), voucher);
        addProduct(product);
    }

    public Cart(boolean voucher) {
        this(new ArrayList<Product>(), voucher);
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public double priceSum(){
        double sum = 0;
        for(int i = 0; i < list.size(); i++) {sum += list.get(i).getPrice();}
        return sum;
    }

    public double discountPriceSum(){
        double sum = 0;
        for(int i = 0; i < list.size(); i++) {sum += list.get(i).getDiscountPrice();}
        return sum;
    }

    private void isMoreThan300() {
        if (priceSum() > 300) {list.forEach(p -> p.setDiscountPrice(p.getPrice() * 0.95));}
    }

    private void freeProduct() {
        if (list.size() > 2) cheapestProduct().setDiscountPrice(0.00);
    }

    private void freeCup() {
        if (priceSum() > 200) list.add(new Product("AAAA0001", "Kubek", 0.00));
    }

    public void sortList() {sortByPrice(false);}

    public Product cheapestProduct() {
        sortList();
        return list.get(0);
    }

    public Product mostExpensiveProduct() {
        sortList();
        return list.get(list.size()-1);
    }

    public ArrayList<Product> cheapestProducts(int n) {
        sortList();
        return new ArrayList<>(list.subList(list.size() - n, list.size()));
    }

    public ArrayList<Product> mostExpensiveProducts(int n) {
        sortList();
        return new ArrayList<>(list.subList(0, n));
    }

    public void sortByPrice(boolean desc) {
        if (desc) list.sort(Comparator.comparing(p -> p.getPrice(), Comparator.reverseOrder()));
        else list.sort(Comparator.comparing(p -> p.getPrice()));
    }

    public void sortByName(boolean alphabetical) {
        if (!alphabetical) list.sort(Comparator.comparing(p -> p.getName(), Comparator.reverseOrder()));
        else list.sort(Comparator.comparing(p -> p.getName()));
    }

    public void applyDiscounts() {
        if (priceSum() > 300) isMoreThan300();
        if (priceSum() > 200) freeCup();
        if (list.size() > 2) freeProduct();
    }

    public void applyVoucher(Product product) {
        if(voucher) {list.get(list.indexOf(product)).setDiscountPrice(product.getDiscountPrice() * 0.7);}
    }

    public void showProducts() {
        list.forEach(p -> System.out.println(p.toString()));
    }
}