package com.garage.car.service;

import com.garage.car.controller.CarController;
import com.garage.car.exception.CarNotFoundException;
import com.garage.car.model.CarDetails;
import com.garage.car.model.Vehicle;
import com.garage.car.model.Warehouse;
import com.garage.car.repo.WarehouseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private static final Logger LOG = LoggerFactory.getLogger(CarService.class);


    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Gets all the cars from the warehouse
     *
     * @return list of cars
     */
    public List<Vehicle> getcars() {

        List<Warehouse> warehouses = warehouseRepository.findAll();


        List<Vehicle> vehicles = warehouses.stream()
                .flatMap(a -> a.getCars().getVehicles().stream())
                .collect(Collectors.toList());
        return vehicles;
    }
    /**
     * Gets details of the car
     *
     * @return CarDetails
     */
    public CarDetails getCarDetails(int carId) {

        Warehouse warehouse = warehouseRepository.findCarDetailsById(carId);
        if (warehouse == null) {
            LOG.error("Car ID not found ={}",carId );
            throw new CarNotFoundException("Car id"+carId);
        }
        CarDetails carDetails = new CarDetails();

            carDetails.setLocation(warehouse.getCars().getLocation());
            carDetails.setWarehouseName(warehouse.getName());


        return carDetails;


    }


}
