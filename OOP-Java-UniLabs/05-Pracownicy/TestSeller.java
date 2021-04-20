import org.junit.*;

public class TestSeller {
    @Test
    public void test_workID() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        Assert.assertequals(e.getWorkID(), 0);
    }

    @Test
    public void test_name() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setName("Łukasz");
        Assert.assertequals(e.getName(), "Łukasz");
    }

    @Test
    public void test_surname() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setSurname("Surasiński");
        Assert.assertequals(e.getSurname(), "Surasiński");
    }

    @Test
    public void test_age() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setAge(25);
        Assert.assertequals(e.getAge(), 25);
    }

    @Test
    public void test_exp() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setEXP(80);
        Assert.assertequals(e.getEXP(), 80);
    }

    @Test
    public void test_address() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        Address ad = new Address("Jana z Kolna", 12, 2, "Gdynia");
        e.setAddress(ad);
        Assert.assertequals(e.getAddress(), ad);
    }

    @Test
    public void test_effectiveness() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setEffectiveness(3);
        Assert.assertequals(e.getEffectiveness(), "WYSOKA");
    }

    @Test
    public void test_commission() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        e.setCommission(6);
        Assert.assertequals(e.getCommission(), 6);
    }

    @Test
    public void test_toString() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        System.out.println(e.toString());
    }

    @Test
    public void test_worth() {
        Seller e = new Seller("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), "ŚREDNIA", 3);
        int factor;
        switch(e.getEffectiveness()) {
            case "NISKA" : factor = 60;
            case "ŚREDNIA" : factor = 90;
            case "WYSOKA" : factor = 120;
        }
        Assert.assertequals(e.worth(), e.getEXP()*factor);
    }
}