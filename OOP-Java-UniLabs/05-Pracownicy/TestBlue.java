import org.junit.*;

public class TestBlue {
    @Test
    public void test_workID() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        Assert.assertequals(e.getWorkID(), 0);
    }

    @Test
    public void test_name() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        e.setName("Łukasz");
        Assert.assertequals(e.getName(), "Łukasz");
    }

    @Test
    public void test_surname() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        e.setSurname("Surasiński");
        Assert.assertequals(e.getSurname(), "Surasiński");
    }

    @Test
    public void test_age() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        e.setAge(25);
        Assert.assertequals(e.getAge(), 25);
    }

    @Test
    public void test_exp() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        e.setEXP(80);
        Assert.assertequals(e.getEXP(), 80);
    }

    @Test
    public void test_address() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        Address ad = new Address("Jana z Kolna", 12, 2, "Gdynia");
        e.setAddress(ad);
        Assert.assertequals(e.getAddress(), ad);
    }

    @Test
    public void test_strength() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        e.setStrength(200);
        Assert.equals(e.getStrength(), 100);
    }

    @Test
    public void test_toString() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        System.out.println(e.toString());
    }

    public void test_worth() {
        Blue e = new Blue("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 90);
        Assert.assertequals(e.worth(), e.getStrength()*e.getEXP()/e.getAge());
    }
}