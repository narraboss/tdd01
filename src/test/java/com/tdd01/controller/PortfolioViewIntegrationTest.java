package com.tdd01.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class PortfolioViewIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void givenPortfolioWithOpenPositionDisplaysPosition() throws Exception {
        //get /view
        MvcResult results = mockMvc.perform(MockMvcRequestBuilders.get("/view"))
                .andExpect(status().isOk())
                .andExpect(view().name("view"))
                .andExpect(model().attributeExists("positions"))
                .andReturn();

        //check for model containing attributes
        List<String> positions = (List<String>) results.getModelAndView()
                .getModel()
                .get("positions");
        Assertions.assertThat(positions).hasSize(1);

    }
}
