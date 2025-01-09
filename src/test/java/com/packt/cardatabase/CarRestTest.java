package com.packt.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorrectAuthentication() throws Exception {
        this.mockMvc.perform(post("/login").content("{\n" +
                                "    \"username\": \"user\",\n" +
                                "    \"password\": \"user\"\n" +
                                "}")
                        .header(HttpHeaders.CONTENT_TYPE, "application/json"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testInCorrectAuthentication() throws Exception {
        this.mockMvc.perform(post("/login").content("{\n" +
                                "    \"username\": \"user\",\n" +
                                "    \"password\": \"user1\"\n" +
                                "}")
                        .header(HttpHeaders.CONTENT_TYPE, "application/json"))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

}
