package com.neeraj.tinyurl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neeraj.tinyurl.model.dto.MinifyRequestDto;
import com.neeraj.tinyurl.model.dto.MinifyResponseDto;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TinnyURLDynamicControllerTest {

    private final Random random = new Random();
    private final Integer numberOfTests = 100000;
    @Autowired
    private MockMvc mvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @TestFactory
    Collection<DynamicTest> perform_a_recursive_test() throws Exception {
        Map<String, String> stringMap = Map.of(
                "abc123",
                "https://www.google.com/search?safe=active&rlz=1C1SQJL_enUS807US807&sxsrf=ACYBGNRx5ybGi72w6lRU9s_0PUs8iPn-UQ%3A1571455118815&ei=joCqXbmyMe_l_Qbd87uwCA&q=recursive+mockmvc+example&oq=recursive+mockmvc+&gs_l=psy-ab.3.0.33i160.114926.123218..124835...0.1..0.154.1989.1j16......0....1..gws-wiz.......0i71j35i39j0i67j0j0i131j0i20i263j0i70i249j0i22i30j0i13i30j0i13i5i30j0i8i13i30j0i13.nuNl5STQCIk",
                "abc234",
                "https://www.google.com/search?q=map+initialization+java+11&rlz=1C1SQJL_enUS807US807&oq=map+initialization+java+&aqs=chrome.2.69i57j0l5.5614j0j7&sourceid=chrome&ie=UTF-8",
                "abc1",
                "https://www.test2.com/search?q=map+initialization+java+11&rlz=1C1SQJL_enUS807US807&oq=map+initialization+java+&aqs=chrome.2.69i57j0l5.5614j0j7&sourceid=chrome&ie=UTF-8",
                "test3",
                "https://www.test3.com/search?q=map+initialization+java+11&rlz=1C1SQJL_enUS807US807&oq=map+initialization+java+&aqs=chrome.2.69i57j0l5.5614j0j7&sourceid=chrome&ie=UTF-8",
                "Test3",
                "https://www.Test3.com/search?q=junit+5+dynamic+tests+examples&safe=active&rlz=1C1SQJL_enUS807US807&sxsrf=ACYBGNQrwYwyQkGyeiAk-ntGDjR4M8mCwg:1571491152998&source=lnms&tbm=vid&sa=X&ved=0ahUKEwi-qMTftKjlAhUHh-AKHZAPClIQ_AUIEygC&biw=1536&bih=754",
                "Abc1",
                "https://www.Abc1.com/search?q=map+initialization+java+11&rlz=1C1SQJL_enUS807US807&oq=map+initialization+java+&aqs=chrome.2.69i57j0l5.5614j0j7&sourceid=chrome&ie=UTF-8",
                "abc568",
                "https://www.google.com/search?q=junit+5+dynamic+tests+examples&safe=active&rlz=1C1SQJL_enUS807US807&sxsrf=ACYBGNQrwYwyQkGyeiAk-ntGDjR4M8mCwg:1571491152998&source=lnms&tbm=vid&sa=X&ved=0ahUKEwi-qMTftKjlAhUHh-AKHZAPClIQ_AUIEygC&biw=1536&bih=754"
        );

//        Call end point to test and get all the list of URl's
        Collection<DynamicTest> urlShorterCreation = stringMap.entrySet()
                .parallelStream()
                .map(e -> DynamicTest.dynamicTest(
                        "Creating a short URL for the ID:" + e.getKey(),
                        () -> getShortURLResponseObject(e.getValue(), e.getKey())))
                .collect(Collectors.toList());

//        Call end point to get the URL's into a list.
        List<MinifyResponseDto> minifyResponseDtos = stringMap.entrySet()
                .parallelStream()
                .map(e -> getShortURLResponseObject(e.getValue(), e.getKey()))
                .collect(Collectors.toList());

//        Iterate over Response List and place a call to get the same long URL for the given short URL.
        Collection<DynamicTest> urlExpander = minifyResponseDtos.parallelStream()
                .map(responseDto -> DynamicTest.dynamicTest(
                        "Expanding the short URL : " + responseDto.getShortURL(),
                        () -> assertEquals(responseDto.getLongURL(), getExpandedURL(responseDto.getShortURL()))))
                .collect(Collectors.toList());

        for (int i = 0; i < numberOfTests; i++) {
            MinifyResponseDto responseDto = minifyResponseDtos.get(random.nextInt(minifyResponseDtos.size()));
            urlExpander.add(DynamicTest.dynamicTest(
                    "Expanding the short URL : " + responseDto.getShortURL(),
                    () -> assertEquals(responseDto.getLongURL(), getExpandedURL(responseDto.getShortURL()))));
        }

        Collection<DynamicTest> testResults = new ArrayList<>();
        testResults.addAll(urlShorterCreation);
        testResults.addAll(urlExpander);
        return testResults;
    }

    private MinifyResponseDto getShortURLResponseObject(String longURL, String userID) {
        System.out.println("longURL = " + longURL + ", userID = " + userID);
        MinifyRequestDto requestDto = MinifyRequestDto.builder()
                .userId(userID)
                .longURL(longURL)
                .build();
        MockHttpServletResponse response = null;
        try {
            response = mvc.perform(post("/minify")
                    .content(objectMapper.writeValueAsString(requestDto))
                    .contentType("application/json"))
                    .andExpect(status().isCreated())
                    .andReturn()
                    .getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MinifyResponseDto responseDto = null;
        try {
            responseDto = objectMapper.readValue(response.getContentAsString(), MinifyResponseDto.class);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return responseDto;
        }
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
