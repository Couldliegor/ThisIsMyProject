package com.example.thisismyproject.exception;
import com.example.thisismyproject.service.impl.FileApartmentImpl;
public class NoDataFileException extends Exception {
    public NoDataFileException() {
     super("There is No Data File In Directory! " + " \n You need to create dataFile using method!");
    }

}
