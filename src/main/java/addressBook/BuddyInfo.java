package addressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private String name;
    private String phoneNumber;
    @Id @GeneratedValue
    private Long id;

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo() {
        this("test", "012-345-6789");
    }

    @Override
    public String toString() {
        String s = "ID: " + getId() + "\nName: " + getName() + "\nPhone Number: " + getPhoneNumber();
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BuddyInfo) {
            BuddyInfo b = (BuddyInfo) o;
            return (b.getName().equals(name) && b.getPhoneNumber().equals(phoneNumber));
        }
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
