package com.example.thisismyproject.model;

public enum Styles {
    LOFT("LOFT"),
    NO_STYLE_EMPTY("Empty Style"),
    WHITE_WALLS("Just white walls"),
    BRICK_WALLS("Brick Walls"),
    MIXED_LOFT("Mixed Loft");
    private final String title;
    Styles(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

/*INSERT INTO apartment(
apartments(# metro,minutes,style,comment,price,nature,rooms,meters,type_building,side,comments)
apartments-# VALUES('Спасская', 15, 'LOFT', 'str',50000, 5.0, 1, 30,'HOUSE','CITY','SMTH');*/
//Index 30 out of bounds for length 23

//воспринимает число вместоONEROOM;