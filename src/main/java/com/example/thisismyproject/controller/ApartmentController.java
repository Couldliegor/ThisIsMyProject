package com.example.thisismyproject.controller;

import com.example.thisismyproject.model.Apartment;
import com.example.thisismyproject.service.ApartmentsDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {
    private final ApartmentsDAO apartmentsDAO;

    public ApartmentController(ApartmentsDAO apartmentsDAO) {
        this.apartmentsDAO = apartmentsDAO;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Apartment> getApartment(@PathVariable long id) {
        return ResponseEntity.ok(apartmentsDAO.getApartmentById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Long> addApartment(@RequestBody Apartment apartment) {
        apartmentsDAO.addApartment(apartment);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Apartment> editApartment(@PathVariable long id, @RequestBody Apartment apartment) {
        return ResponseEntity.ok().body(apartmentsDAO.editApartment(id, apartment));
    }

    @GetMapping("/")
    public ResponseEntity<List<Apartment>> getAll() {
        return ResponseEntity.ok().body(apartmentsDAO.getAllApartments());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteApartment(@PathVariable long id) {
        apartmentsDAO.deleteApartment(id);
        return ResponseEntity.ok().build();
    }
}
