package com.greenfox.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.demo.controller.GuardianController;
import com.greenfox.demo.model.*;

import static org.mockito.Mockito.when;

import com.greenfox.demo.service.GrootService;
import com.greenfox.demo.service.RocketService;
import com.greenfox.demo.service.YonduService;
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
    @MockBean
    private YonduService yonduService;
    @MockBean
    RocketService rocketService;

    @Autowired
    private MockMvc mockMvc;

    Groot groot = new Groot("message");
    Yondu yondu = new Yondu(100.0, 10.0);
    Rocket rocket = new Rocket();
    FilledRocket filledRocketEmpty = new FilledRocket(".50", 0);
    FilledRocket filledRocket = new FilledRocket(".50", 5000);
    FilledRocket filledRocket2 = new FilledRocket(".50", 12500);
    FilledRocket filledRocket3 = new FilledRocket(".50", 12501);

    @Test
    public void grootTranslateAccurately() throws Exception {
        when(grootService.translate("message")).thenReturn(groot);
        mockMvc.perform(get("/groot").param("message", "message"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is("message")))
                .andExpect(jsonPath("translated", is("I am Groot!")))
                .andDo(print());
    }

    @Test
    public void grootWithoutParameter() throws Exception {
        when(grootService.translate(null)).thenThrow(MissingArgumentException.class);
        mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("I am Groot!")))
                .andDo(print());
    }

    @Test
    public void countYondusSpeedAccurately() throws Exception {
        when(yonduService.countSpeed(100.0, 10.0)).thenReturn(yondu);
        mockMvc.perform(get("/yondu").param("distance", "100.0")
                .param("time", "10.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("distance", is(100.0)))
                .andExpect(jsonPath("time", is(10.0)))
                .andExpect(jsonPath("speed", is(10.0)))
                .andDo(print());
    }

    @Test
    public void yonduSpeedWithoutParameter() throws Exception {
        when(yonduService.countSpeed(null, null)).thenThrow(MissingArgumentException.class);
        mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("I am Groot!")))
                .andDo(print());

    }

    @Test
    public void cargoStatusOverallStatus() throws Exception {
        when(rocketService.getCargo()).thenReturn(rocket);
        mockMvc.perform(get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("caliber25", is(0)))
                .andExpect(jsonPath("caliber30", is(0)))
                .andExpect(jsonPath("caliber50", is(0)))
                .andExpect(jsonPath("shipstatus", is("empty")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void cargoStatusEmpty() throws Exception {
        when(rocketService.getCargoStatus(".50", 0)).thenReturn(filledRocketEmpty);
        mockMvc.perform(get("/rocket/fill").param("caliber", ".50")
                .param("amount", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".50")))
                .andExpect(jsonPath("amount", is(0)))
                .andExpect(jsonPath("shipstatus", is("empty")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void cargoStatus40Percent() throws Exception {
        when(rocketService.getCargoStatus(".50", 5000)).thenReturn(filledRocket);
        mockMvc.perform(get("/rocket/fill").param("caliber", ".50")
                .param("amount", "5000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".50")))
                .andExpect(jsonPath("amount", is(5000)))
                .andExpect(jsonPath("shipstatus", is("40%")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void cargoStatusFull() throws Exception {
        when(rocketService.getCargoStatus(".50", 12500)).thenReturn(filledRocket2);
        mockMvc.perform(get("/rocket/fill").param("caliber", ".50")
                .param("amount", "12500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".50")))
                .andExpect(jsonPath("amount", is(12500)))
                .andExpect(jsonPath("shipstatus", is("full")))
                .andExpect(jsonPath("ready", is(true)))
                .andDo(print());
    }

    @Test
    public void cargoStatusOverload() throws Exception {
        when(rocketService.getCargoStatus(".50", 12501)).thenReturn(filledRocket3);
        mockMvc.perform(get("/rocket/fill").param("caliber", ".50")
                .param("amount", "12501"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".50")))
                .andExpect(jsonPath("amount", is(12501)))
                .andExpect(jsonPath("shipstatus", is("overloaded")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void cargoStatusBadRequest() throws Exception {
        when(rocketService.getCargoStatus(null, null)).thenThrow(MissingArgumentException.class);
        mockMvc.perform(get("/rocket/fill"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("I am Groot!")))
                .andDo(print());
    }


}
