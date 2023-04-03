package com.example.thisismyproject.controller;

import com.example.thisismyproject.model.FileModel;
import com.example.thisismyproject.service.FileApartment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//Апартаменты
@RestController
@RequestMapping("/file/apart")
public class FileControllerApart {
    private final FileApartment fileApartment;

    public FileControllerApart(FileApartment fileApartment) {
        this.fileApartment = fileApartment;
    }

    @GetMapping("/get{type}")
    public ResponseEntity<InputStreamResource> getFileWithType(@PathVariable FileModel type) throws IOException {
        File file = fileApartment.getDataFile(type);
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));//так создается поток данных
            if (type.getType().equals(".json")) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON) // передача данных по байтово
                        .contentLength(file.length())//длинна
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"apartment.json\"")
                        .body(resource);
            } //проводим эксперимент над типами данных
            if (type.getType().equals(".xml")) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_XML) // передача данных по байтово
                        .contentLength(file.length())//длинна
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"apartment.xml\"")
                        .body(resource);
            }
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadRecipeDataFile(@RequestParam MultipartFile file) { //класс MultiFile дает всю необходимую информацию о файле, что крайне удобно
        /*Boolean b = fileApartment.tryCheckConstruction(file); //передать в метод  и сделать проверку на тип данных, и в целом всего того, что в файле содержится
        if (b) {
            return ResponseEntity.ok().build();
        }*/
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
