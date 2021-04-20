import org.junit.*;

public class PersonTest {
    static Person testClient = new Person("Jan Nowak", "Aleja Grunwaldzka 189/14, Gdansk", "123-456-78-90", "17 2039 5474 0000 3111 0127 3051");

    @Test
    public void getBankAccountNumber() {
        Assert.assertEquals(testClient.getBankAccountNumber(), "17 2039 5474 0000 3111 0127 3051");
    }

    @Test
    public void testGetBankAccountNumber() {
        testClient.setBankAccountNumber("18 4313 7832 0000 2333 0125 4020");
        Assert.assertEquals(testClient.getBankAccountNumber(), "18 4313 7832 0000 2333 0125 4020");
    }

    @Test
    public void testGetNIP() {
        Assert.assertEquals(testClient.getNIP(), "123-456-78-90");
    }

    @Test
    public void testSetNIP() {
        testClient.setNIP("098-765-43-21");
        Assert.assertEquals(testClient.getNIP(),"098-765-43-21");
    }

    @Test
    public void testGetAddress() {
        Assert.assertEquals(testClient.getAddress(), "Aleja Grunwaldzka 189/14, Gdansk");
    }

    @Test
    public void testSetAddress() {
        testClient.setAddress("Jana z Kolna 17, Sopot");
        Assert.assertEquals(testClient.getAddress(), "Jana z Kolna 17, Sopot");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(testClient.getName(), "Jan Nowak");
    }

    @Test
    public void testSetName() {
        testClient.setName("Jan Kowalski");
        Assert.assertEquals(testClient.getName(), "Jan Kowalski");
    }
}