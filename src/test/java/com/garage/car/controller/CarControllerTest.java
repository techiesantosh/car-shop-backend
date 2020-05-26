package com.garage.car.controller;

import com.garage.car.service.CarService;
import com.garage.car.util.WarehouseStubDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@WebMvcTest(CarController.class)

public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getTasks() throws Exception {
        when(carService.getcars()).thenReturn(WarehouseStubDataProvider.getVehicles());
        this.mockMvc.perform(get("/cars")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                 .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].make", is("Volkswagen")))
                .andExpect(jsonPath("$[0].model", is("Jetta III")))

                .andExpect(jsonPath("$[1].id", is("2")))
                .andExpect(jsonPath("$[1].make", is("Ford")))
                .andExpect(jsonPath("$[1].model", is("Expedition EL")))
                .andExpect(jsonPath("$[1].price", is(527.25)))
                .andExpect(jsonPath("$[1].licensed", is(false)))
                .andExpect(jsonPath("$[1].dateadded", is("2018-09-18")));



    }

}