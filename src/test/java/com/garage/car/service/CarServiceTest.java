package com.garage.car.service;

import com.garage.car.model.Vehicle;
import com.garage.car.repo.WarehouseRepository;
import com.garage.car.util.WarehouseStubDataProvider;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CarServiceTest {

    @Autowired
    ApplicationContext context;
    @InjectMocks
    private CarService carService;
    @Mock
    private WarehouseRepository warehouseRepository;

    @BeforeEach
    public void setUp() {

        Mockito.when(warehouseRepository.findAll()).thenReturn(WarehouseStubDataProvider.getWarehouses());

    }

    @Test
    public void getCars() {

        final List<Vehicle> vehicleList = carService.getcars();

        assertThat(vehicleList, hasSize(2));
        assertThat(vehicleList.get(0), hasProperty("make", equalTo("Volkswagen")));
        assertThat(vehicleList.get(0), hasProperty("model", equalTo("Jetta III")));
        assertThat(vehicleList.get(0), hasProperty("price", equalTo(127.25)));

        assertThat(vehicleList.get(1), hasProperty("make", equalTo("Ford")));
        assertThat(vehicleList.get(1), hasProperty("model", equalTo("Expedition EL")));
        assertThat(vehicleList.get(1), hasProperty("price", equalTo(527.25)));
    }


}