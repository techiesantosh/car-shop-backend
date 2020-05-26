package com.garage.car.repo;

import com.garage.car.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository   extends MongoRepository<Warehouse, String> {


        }
