package com.garage.car.service;

import com.garage.car.model.Vehicle;
import com.garage.car.model.Warehouse;
import com.garage.car.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    /**
     * Gets all the cars from the warehouse
     * @return list of cars
     */
    public List<Vehicle> getcars() {

        List<Warehouse> warehouses = warehouseRepository.findAll();

        List<Vehicle> vehicles = warehouses.stream()
                .flatMap(a-> a.getCars().getVehicles().stream())
                .collect(Collectors.toList());
       return vehicles;
    }


}
