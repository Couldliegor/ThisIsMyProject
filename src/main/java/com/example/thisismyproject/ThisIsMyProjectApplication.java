package com.example.thisismyproject;
import com.example.thisismyproject.model.FileModel;
import com.example.thisismyproject.service.impl.FileApartmentImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static com.example.thisismyproject.model.FileModel.XML;

@SpringBootApplication
public class ThisIsMyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThisIsMyProjectApplication.class, args);
    }
}
