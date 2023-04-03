package com.example.thisismyproject.service;

import com.example.thisismyproject.model.FileModel;

import java.io.File;
import java.io.IOException;

public interface FileApartment {
    File getDataFile(FileModel type);

    public boolean createApartmentFile(FileModel type) throws IOException;
}
