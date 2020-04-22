package com.example.trainerplanner;

import static org.hamcrest.Matchers.containsString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;


//Testaa Web layeriä. Spring applicaatio aloitetaan ilman että serveri käynnistyy.
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()) //Hakee "/" ja odottaa "trainerlist" palautusta
                .andExpect(content().string(containsString("trainerlist")));
    }
}