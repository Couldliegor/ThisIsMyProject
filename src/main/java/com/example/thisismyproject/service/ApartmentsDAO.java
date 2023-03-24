package com.example.thisismyproject.service;

import com.example.thisismyproject.model.Apartment;

import java.util.List;

public interface ApartmentsDAO {
    long addApartment(Apartment apartment);
    Apartment getApartmentById(long id);
    List<Apartment> getAllApartments();
    Apartment editApartment(long id, Apartment apartment);
    void deleteApartment(long id);
}
