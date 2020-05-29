package com.garage.car.repo;

import com.garage.car.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, String> {

    @Query("{\"cars.vehicles._id\":{ $eq: ?0}}")
    Warehouse findCarDetailsById(int id);

}
