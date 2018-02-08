package addressBook;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.*;


@RestController
public class BuddyInfoController {

    private BuddyInfoRepository buddyRepo;
    private AddressBookRepository bookRepo;


    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        buddyRepo = buddyInfoRepository;
        bookRepo = addressBookRepository;
    }

    @RequestMapping(value="/books")
    public AddressBook findBook(@RequestParam(value="id") Long id) {
        return (AddressBook) bookRepo.findOne(id);
    }

    @RequestMapping(value="/books/add")
    public void addBook(@RequestParam(value="id") Long id) {
        AddressBook book = new AddressBook();
        bookRepo.save(book);
        //return (AddressBook) bookRepo.findOne(id);
    }

    @RequestMapping(value="/books/remove")
    public void removeBook(@RequestParam(value="id") Long id) {
        bookRepo.delete(id);
    }

    @RequestMapping(value="/books/{id}/buddies")
    public List<BuddyInfo> findBuddy(@RequestParam(value="id") Long id) {
        return (List<BuddyInfo>) buddyRepo.findById(id);
    }

    @RequestMapping(value="/books/{bookId}/buddiesall")
    public List<BuddyInfo> findAllBuddies(@PathVariable(value="bookId") Long bookId) {
        AddressBook book = (AddressBook) bookRepo.findOne(bookId);
        List<BuddyInfo> buddies = book.getBuddies();
        return buddies;
    }

    @RequestMapping(value="/books/{bookId}/buddies/add")
    public void addBuddy(@PathVariable(value="bookId") Long bookId, @RequestParam(value="name") String name, @RequestParam(value="number") String phonenumber) {
        BuddyInfo buddy = new BuddyInfo(name, phonenumber);
        AddressBook book = (AddressBook) bookRepo.findOne(bookId);
        book.addBuddy(buddy);
        bookRepo.save(book);
        //return (BuddyInfo) buddyRepo.findOne(buddy.getId());
    }

    @RequestMapping(value="/books/{bookId}/buddies/remove")
    public void removeBuddy(@PathVariable(value="bookId") Long bookId, @RequestParam(value="id") Long id) {
        AddressBook book = (AddressBook) bookRepo.findOne(bookId);
        BuddyInfo buddy = (BuddyInfo) buddyRepo.findOne(id);
        book.removeBuddy(buddy);
        bookRepo.save(book);
        buddyRepo.delete(id);
    }

}