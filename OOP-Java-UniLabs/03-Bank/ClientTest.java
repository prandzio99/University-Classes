import org.junit.*;


public class ClientTest {
    @Test
    public void test_name() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        client.setName("Eric");
        Assert.assertEquals(client.getName(), "Eric");
    }

    @Test
    public void test_lastname() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        client.setLastname("Duck");
        Assert.assert(client.getLastname(), "Duck");
    }

    @Test
    public void test_dob() {
        Client client = new Client("Donald", "Trump", "1946/06/14");
        client.setDateOfBirth("1945/07/13");
        Assert.assert(client.getDateOfBirth(), "1945/07/13");
    }
}