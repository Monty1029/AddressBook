package addressBook;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void addBookTest() throws Exception {
//        this.mockMvc.perform(
//                post("/books/add?id=1"));
//
//        this.mockMvc.perform(
//                get("/books?id=1"))
//                .andExpect(jsonPath("$.id").value(hasKey("id")));
//    }

    @Test
    public void removeBuddyTest() throws Exception {
        this.mockMvc.perform(
                post("/books/add?id=1"));

        this.mockMvc.perform(
                post("/books/remove?id=1"));

        this.mockMvc.perform(
                get("/books?id=1"))
                .andExpect(jsonPath("$.id").doesNotExist());
    }

    @Test
    public void addBuddyTest() throws Exception {
        this.mockMvc.perform(
                post("/books/add?id=1"));
        this.mockMvc.perform(
                post("/books/1/buddies/add?name=Monty&number=0123456789"));

        this.mockMvc.perform(
                get("/books/1/buddies?id=6"))
                .andExpect(jsonPath("$[0]").value(hasKey("name")));
    }

}