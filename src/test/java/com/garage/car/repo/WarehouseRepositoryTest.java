package com.garage.car.repo;

import com.garage.car.model.Car;
import com.garage.car.model.Vehicle;
import com.garage.car.model.Warehouse;
import com.garage.car.util.WarehouseStubDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class WarehouseRepositoryTest {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @BeforeEach
    public void dataSetup() {
        warehouseRepository.saveAll(WarehouseStubDataProvider.getWarehouses());
    }

    @Test
    public void findWarhouseTest() {

        List<Warehouse> warehouses = warehouseRepository.findAll();
        Warehouse warehouse = warehouses.get(0);
        Car car = warehouse.getCars();
        final Vehicle vehicle = car.getVehicles().get(0);
        assertThat(warehouses, hasSize(2));
        assertThat(warehouse, hasProperty("name", equalTo("Warehouse A")));
        assertThat(car, hasProperty("location", equalTo("West wing")));
        assertThat(vehicle, hasProperty("make", equalTo("Volkswagen")));
        assertThat(vehicle, hasProperty("model", equalTo("Jetta III")));


    }


}