import org.junit.*;

import java.beans.Transient;
import java.util.*;

public class TestCompany {

    @Test
    public void test_insert() {
        Company company = new Company();
        White employee = new White("Adam", "Arbuz", 25, 50, new Address("Grunwaldzka",16,32,"Gdansk"), 80);
        company.insert(employee);
        Assert.assertequals(company.register.get(0), employee);
    }

    @Test
    public void test_insertMore() {
        Company company = new Company();
        White employee1 = new White("Adam", "Arbuz", 25, 50, new Address("Grunwaldzka",16,32,"Gdansk"), 80);
        Blue employee2 = new Blue("Bartosz", "Boruc", 31, 72, new Address("Jana z Kolna",1,4,"Gdynia"), 90);
        Seller employee3 = new Seller("Cyprian", "Czerski", 22, 41, new Address("Zielona",16,7,"Tczew"), "ŚREDNIA", 3);
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        company.insertMore(list);
        Assert.assertequals(company.register, list);
    }

    @Test
    public void test_showSorted() {
        Company company = new Company();
        White employee1 = new White("Adam", "Arbuz", 25, 50, new Address("Grunwaldzka",16,32,"Gdansk"), 80);
        Blue employee2 = new Blue("Bartosz", "Boruc", 31, 72, new Address("Jana z Kolna",1,4,"Gdynia"), 90);
        Seller employee3 = new Seller("Cyprian", "Czerski", 22, 41, new Address("Zielona",16,7,"Tczew"), "ŚREDNIA", 3);
        company.insertMore(Arrays.asList(employee1, employee2, employee3));
        company.showSorted();
    }

    @Test
    public void test_showByCity() {
        String city = "Gdynia";
        Company company = new Company();
        White employee1 = new White("Adam", "Arbuz", 25, 50, new Address("Grunwaldzka",16,32,"Gdansk"), 80);
        Blue employee2 = new Blue("Bartosz", "Boruc", 31, 72, new Address("Jana z Kolna",1,4,"Gdynia"), 90);
        Seller employee3 = new Seller("Cyprian", "Czerski", 22, 41, new Address("Zielona",16,7,"Tczew"), "ŚREDNIA", 3);
        company.insertMore(Arrays.asList(employee1, employee2, employee3));
        company.showByCity(city);
    }

    @Test
    public void test_showWorth() {
        Company company = new Company();
        White employee1 = new White("Adam", "Arbuz", 25, 50, new Address("Grunwaldzka",16,32,"Gdansk"), 80);
        Blue employee2 = new Blue("Bartosz", "Boruc", 31, 72, new Address("Jana z Kolna",1,4,"Gdynia"), 90);
        Seller employee3 = new Seller("Cyprian", "Czerski", 22, 41, new Address("Zielona",16,7,"Tczew"), "ŚREDNIA", 3);
        company.insertMore(Arrays.asList(employee1, employee2, employee3));
        company.showWorth();
    }
}