package addressBook;

import java.util.*;
import javax.persistence.*;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    @Id @GeneratedValue
    private Long id;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public void printAddressBook() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String s = "";
        for(BuddyInfo b : buddies) {
            s += "ID: " + b.getId() + "\nName: " + b.getName() + "\nPhone Number: " + b.getPhoneNumber();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AddressBook) {
            AddressBook a = (AddressBook) o;
            return (a.getBuddies().equals(buddies));
        }
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        String buddy1Name = "Monty";
        String buddy1PhoneNumber = "123-456-7890";
        BuddyInfo buddy1 = new BuddyInfo(buddy1Name, buddy1PhoneNumber);
        String buddy2Name = "Friend";
        String buddy2PhoneNumber = "098-765-4321";
        BuddyInfo buddy2 = new BuddyInfo(buddy2Name, buddy2PhoneNumber);
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        book.printAddressBook();
    }

}
