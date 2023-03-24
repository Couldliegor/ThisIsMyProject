package com.example.thisismyproject.controller;

import com.example.thisismyproject.model.RentApartment;
import com.example.thisismyproject.service.RentApartmentsDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class ApartmentRentController {
    private final RentApartmentsDAO rentApartmentsDAO;

    public ApartmentRentController(RentApartmentsDAO rentApartmentsDAO) {
        this.rentApartmentsDAO = rentApartmentsDAO;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RentApartment> getRentApartment(@PathVariable long id) {
        return ResponseEntity.ok(rentApartmentsDAO.getRentApartmentById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Long> addRentApartment(@RequestBody RentApartment apartment) {
        return ResponseEntity.ok().body(rentApartmentsDAO.addRentApartment(apartment));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RentApartment> editRentApartment(@PathVariable long id, @RequestBody RentApartment apartment) {
        return ResponseEntity.ok().body(rentApartmentsDAO.editRentApartment(id, apartment));
    }

    @GetMapping("/")
    public ResponseEntity<List<RentApartment>> getAllRent() {
        return ResponseEntity.ok().body(rentApartmentsDAO.getAllRentApartments());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRentApartment(@PathVariable long id) {
        rentApartmentsDAO.deleteRentApartment(id);
        return ResponseEntity.ok().build();
    }

}
