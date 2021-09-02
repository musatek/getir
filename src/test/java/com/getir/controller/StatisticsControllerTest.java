package com.getir.controller;

import com.getir.service.StatisticsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private StatisticsController staticticsController;

    @Mock
    private StatisticsService statisticsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(staticticsController).build();
    }

    @Test
    public void it_should_invoke_customer_Statistics_by_id() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api//v1/statistics/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}