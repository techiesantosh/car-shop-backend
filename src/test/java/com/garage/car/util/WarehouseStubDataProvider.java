package com.garage.car.util;

import com.garage.car.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WarehouseStubDataProvider {

    public static List<Warehouse> getWarehouses() {

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setName("Warehouse A");
        Car car = new Car();
        car.setLocation("West wing");
        Location location = new Location();
        location.setLatitude("47.13111");
        location.setLongitude("-61.54801");
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setLicensed(true);
        vehicle.setMake("Volkswagen");
        vehicle.setModel("Jetta III");
        vehicle.setPrice(127.25);
        vehicle.setDateadded("2018-09-18");

        car.getVehicles().add(vehicle);
        warehouse.setCars(car);
        warehouse.setLocation(location);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setId(2);
        warehouse1.setName("Warehouse B");
        Car car1 = new Car();
        car1.setLocation("East wing");
        Location location1 = new Location();
        location1.setLatitude("48.13111");
        location1.setLongitude("-81.54801");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(2);
        vehicle1.setLicensed(false);
        vehicle1.setMake("Ford");
        vehicle1.setModel("Expedition EL");
        vehicle1.setPrice(527.25);
        vehicle1.setDateadded("2018-09-18");

        car1.getVehicles().add(vehicle1);
        warehouse1.setCars(car1);
        warehouse1.setLocation(location1);

        List<Warehouse> warehouses = new LinkedList<>();
        warehouses.add(warehouse);
        warehouses.add(warehouse1);
        return warehouses;
    }

    public  static  List<Vehicle> getVehicles(){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setLicensed(true);
        vehicle.setMake("Volkswagen");
        vehicle.setModel("Jetta III");
        vehicle.setPrice(127.25);
        vehicle.setDateadded("2018-09-18");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(2);
        vehicle1.setLicensed(false);
        vehicle1.setMake("Ford");
        vehicle1.setModel("Expedition EL");
        vehicle1.setPrice(527.25);
        vehicle1.setDateadded("2018-09-18");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        vehicles.add(vehicle1);
        return  vehicles;

    }
    public static CarDetails getCarDetails(int carId){
        CarDetails carDetails = new CarDetails();

        switch (carId){

            case 1:
                carDetails.setWarehouseName("Warehouse A");
                carDetails.setLocation("West Wing");
                break;

            case 2:
                carDetails.setWarehouseName("Warehouse B");
                carDetails.setLocation("East Wing");
                break;


        }

        return carDetails;

    }
}
