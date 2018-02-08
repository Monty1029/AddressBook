package addressBook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook book;
    private BuddyInfo testBuddy;

    @Before
    public void initialize() {
        String testBuddyName = "test";
        String testBuddyPhoneNumber = "012-345-6789";
        testBuddy = new BuddyInfo(testBuddyName, testBuddyPhoneNumber);
        book = new AddressBook();
        book.addBuddy(testBuddy);
    }

    @Test
    public void addBuddy() throws Exception {
        int count = book.getBuddies().size();
        String buddy2Name = "Friend";
        String buddy2PhoneNumber = "098-765-4321";
        BuddyInfo buddy2 = new BuddyInfo(buddy2Name, buddy2PhoneNumber);
        book.addBuddy(buddy2);
        int newCount = book.getBuddies().size();
        assertEquals(2, newCount);

    }

    /*@Test
    public void performJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        Query q = em.createQuery("SELECT a FROM AddressBook a");
        List<AddressBook> results = q.getResultList();
        for (AddressBook a : results) {
            a.printAddressBook();
        }
        em.close();
        emf.close();
        assertEquals(book, results.get(0));
    }*/

}