package com.garage.car;

import com.garage.car.controller.CarController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GarageApplicationTests {
    @Autowired
    private CarController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();

    }

}
