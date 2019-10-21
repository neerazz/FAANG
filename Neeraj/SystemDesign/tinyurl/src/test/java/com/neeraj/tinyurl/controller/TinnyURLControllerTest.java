package com.neeraj.tinyurl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neeraj.tinyurl.model.dto.MinifyRequestDto;
import com.neeraj.tinyurl.model.dto.MinifyResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

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
        String userID = "1234";
        String longURL = "https://www.google.com/search?safe=active&rlz=1C1SQJL_enUS807US807&sxsrf=ACYBGNRx5ybGi72w6lRU9s_0PUs8iPn-UQ%3A1571455118815&ei=joCqXbmyMe_l_Qbd87uwCA&q=recursive+mockmvc+example&oq=recursive+mockmvc+&gs_l=psy-ab.3.0.33i160.114926.123218..124835...0.1..0.154.1989.1j16......0....1..gws-wiz.......0i71j35i39j0i67j0j0i131j0i20i263j0i70i249j0i22i30j0i13i30j0i13i5i30j0i8i13i30j0i13.nuNl5STQCIk";
//        Place a call to get the short URL.
        MinifyResponseDto minifyResponseDto = getShortURLResponseObject(longURL, userID);
//        Then place a get call to check if it returns the same long url
        Assertions.assertEquals(longURL, getExpandedURL(minifyResponseDto.getShortURL()));
    }

    private MinifyResponseDto getShortURLResponseObject(String longURL, String userID) throws Exception {
        System.out.println("longURL = " + longURL + ", userID = " + userID);
        MinifyRequestDto requestDto = MinifyRequestDto.builder()
                .userId(userID)
                .longURL(longURL)
                .build();
        MockHttpServletResponse response = mvc.perform(post("/minify")
                .content(objectMapper.writeValueAsString(requestDto))
                .contentType("application/json"))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse();
        return objectMapper.readValue(response.getContentAsString(), MinifyResponseDto.class);
    }

    private String getExpandedURL(String shortURL) throws Exception {
        System.out.println("shortURL = " + shortURL);
        return mvc.perform(get("/expandedURL")
                .param("shortURL", shortURL)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
