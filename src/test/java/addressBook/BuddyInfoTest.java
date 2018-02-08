package addressBook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo testBuddy;

    @Before
    public void initialize() {
        String testBuddyName = "test";
        String testBuddyPhoneNumber = "012-345-6789";

        testBuddy = new BuddyInfo(testBuddyName, testBuddyPhoneNumber);
    }

    @Test
    public void getName() throws Exception {
        String name = testBuddy.getName();
        assertEquals("test", name);
    }

    @Test
    public void setName() throws Exception {
        String newName = "newTest";
        testBuddy.setName(newName);
        assertEquals("newTest", testBuddy.getName());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        String phoneNumber = testBuddy.getPhoneNumber();
        assertEquals("012-345-6789", phoneNumber);
    }

    @Test
    public void setPhoneNumber() throws Exception {
        String newPhoneNumber = "123-456-7890";
        testBuddy.setPhoneNumber(newPhoneNumber);
        assertEquals("123-456-7890", testBuddy.getPhoneNumber());
    }

    /*@Test
    public void performJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(testBuddy);
        tx.commit();
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        List<BuddyInfo> results = q.getResultList();
        em.close();
        emf.close();
        assertEquals(testBuddy, results.get(0));
    }*/

}