package com.neeraj.tinyurl.controller;

import org.junit.Assert;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IDGenerationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getId() throws Exception {
        getUniqueId();
    }

    private void getUniqueId() throws Exception {
        String uniqueId = mvc.perform(get("/ids")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assert.assertEquals(uniqueId.length(), 6);
    }

    @TestFactory
    Collection<DynamicTest> perform_a_recursive_test_to_get_unique_id() throws Exception {
        Collection<DynamicTest> uniqueIdTests = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            uniqueIdTests.add(DynamicTest.dynamicTest(
                    "Creating a unique ID: ",
                    this::getUniqueId));
        }
        return uniqueIdTests;
    }
}