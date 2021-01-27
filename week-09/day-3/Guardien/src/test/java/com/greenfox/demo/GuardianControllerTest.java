package com.greenfox.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.demo.controller.GuardianController;
import com.greenfox.demo.model.Groot;
import static org.mockito.Mockito.when;
import com.greenfox.demo.service.GrootService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {
    @MockBean
    private GrootService grootService;

    @Autowired
    private MockMvc mockMvc;

    Groot groot = new Groot("message");

    @Test
    public void translateAccurately() throws Exception {
        when(grootService.translate("message")).thenReturn(groot);
        mockMvc.perform(get("/groot").param("message", "message"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is("message")))
                .andExpect(jsonPath("translated", is("I am Groot!")))
                .andDo(print());
    }
}
