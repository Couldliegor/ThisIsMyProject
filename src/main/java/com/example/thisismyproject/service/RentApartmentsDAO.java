package com.example.thisismyproject.service;

import com.example.thisismyproject.model.RentApartment;

import java.util.List;

public interface RentApartmentsDAO {
    long addRentApartment(RentApartment RentApartment);
    RentApartment getRentApartmentById(long id);
    List<RentApartment> getAllRentApartments();
    RentApartment editRentApartment(long id, RentApartment rentApartment);
    void deleteRentApartment(long id);
}
