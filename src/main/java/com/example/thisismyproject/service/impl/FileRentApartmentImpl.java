package com.example.thisismyproject.service.impl;

import com.example.thisismyproject.model.FileModel;
import com.example.thisismyproject.service.FileRentApartment;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
public class FileRentApartmentImpl implements FileRentApartment {
    @Value("src/Files")
    private String dataRentApartmentFilePath;
    @Value("apartmentRent")
    private String nameOfFile; //возможно сделать так, чтобы имя файла опре
    public void loadToFile(FileModel type) {
        nameOfFile = nameOfFile + type.getType(); //все предельно просто
    }
}
