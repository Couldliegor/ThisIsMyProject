package com.example.thisismyproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
//@Entity
public class RentApartment {
    private long id;
    private LinkedHashMap<String, Integer> metroTimeMap = new LinkedHashMap<>();
    private LinkedHashMap<ArrayList<Styles>, String> styleOfApartMap = new LinkedHashMap<>();
    private long price;
    private double percentOfNature;
    private Rooms rooms;
    private Meters meters;
//    private
}
