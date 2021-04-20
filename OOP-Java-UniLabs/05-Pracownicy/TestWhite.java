import org.junit.*;

public class TestWhite {
    @Test
    public void test_workID() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        Assert.assertequals(e.getWorkID(), 0);
    }

    @Test
    public void test_name() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        e.setName("Łukasz");
        Assert.assertequals(e.getName(), "Łukasz");
    }

    @Test
    public void test_surname() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        e.setSurname("Surasiński");
        Assert.assertequals(e.getSurname(), "Surasiński");
    }

    @Test
    public void test_age() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        e.setAge(25);
        Assert.assertequals(e.getAge(), 25);
    }

    @Test
    public void test_exp() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        e.setEXP(80);
        Assert.assertequals(e.getEXP(), 80);
    }

    @Test
    public void test_address() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        Address ad = new Address("Jana z Kolna", 12, 2, "Gdynia");
        e.setAddress(ad);
        Assert.assertequals(e.getAddress(), ad);
    }

    @Test
    public void test_posID() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        Assert.assertequals(e.getPosID(), 0);
    }

    public void test_intellect() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        e.setIntellect(99);
        Assert.equals(e.getIntellect(), 99);
    }

    @Test
    public void test_toString() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        System.out.println(e.toString());
    }

    public void test_worth() {
        White e = new White("Adam", "Arbuz", 23, 50, new Address("Grunwaldzka",16,3,"Gdańsk"), 115);
        Assert.assertequals(e.worth(), e.getIntellect()*e.getEXP());
    }
}