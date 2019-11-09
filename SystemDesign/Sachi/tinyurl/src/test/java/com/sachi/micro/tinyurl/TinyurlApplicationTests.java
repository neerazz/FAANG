package com.sachi.micro.tinyurl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachi.micro.tinyurl.model.TinyURL;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TinyTinyURLApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Value("${env.url}")
    private String envURL;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldReturnDefaultTest() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/abc")).
                andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://google.com"));
    }

    @Test
    public void shouldReturnSameURLForMultipleRquests() throws Exception {
        TinyURL myInput = new TinyURL();
        myInput.setLongURL("http://github.com");
        this.mockMvc.perform(post("http://localhost:8080/shorten")
                .content(asJsonString(myInput))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(
                        result -> mockMvc.perform(post("http://localhost:8080/shorten")
                                .content(asJsonString(myInput))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(redirectedUrl(result.getResponse().getForwardedUrl()))
                );

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
