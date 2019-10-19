package com.neeraj.tinyurl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neeraj.tinyurl.model.MinifyRequestDto;
import com.neeraj.tinyurl.model.MinifyResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TinnyURLControllerTest {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void test_to_create_a_sortURL_and_check_if_it_returns_same_longURL() throws Exception {
        String longURL = "https://www.google.com/search?safe=active&rlz=1C1SQJL_enUS807US807&sxsrf=ACYBGNRx5ybGi72w6lRU9s_0PUs8iPn-UQ%3A1571455118815&ei=joCqXbmyMe_l_Qbd87uwCA&q=recursive+mockmvc+example&oq=recursive+mockmvc+&gs_l=psy-ab.3.0.33i160.114926.123218..124835...0.1..0.154.1989.1j16......0....1..gws-wiz.......0i71j35i39j0i67j0j0i131j0i20i263j0i70i249j0i22i30j0i13i30j0i13i5i30j0i8i13i30j0i13.nuNl5STQCIk";
        MinifyRequestDto requestDto = MinifyRequestDto.builder()
                .userId("12345")
                .longURL(longURL)
                .build();
        MockHttpServletResponse response = mvc.perform(post("/minify")
                .content(objectMapper.writeValueAsString(requestDto))
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse();
        MinifyResponseDto minifyResponseDto = objectMapper.readValue(response.getContentAsString(), MinifyResponseDto.class);

//        Then place a get call to check if it returns the same long url
        MockHttpServletResponse response2 = mvc.perform(get("/expandedURL")
                .param("shortURL", minifyResponseDto.getShortURL())
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        Assertions.assertEquals(longURL, response2.getContentAsString());
    }
}
