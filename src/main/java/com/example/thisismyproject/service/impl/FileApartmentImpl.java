package com.example.thisismyproject.service.impl;

import com.example.thisismyproject.configuration.HibernateFactoryConfigurationUtil;
import com.example.thisismyproject.model.Apartment;
import com.example.thisismyproject.model.FileModel;
import com.example.thisismyproject.service.FileApartment;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor
@Service
public class FileApartmentImpl implements FileApartment {
    // создать родителя двух классов
    @Value("${path.to.apartment.file}")
    private String dataApartmentFilePath;
    @Value("${name.of.apartment.file}")
    private String nameOfFile;
    //возможно сделать так, чтобы имя файла опре
    //делалось конкретно пользователем, это бы сократило весь процесс
    // .json .xml .yaml;;;;///
    //разобраться с Enum и создать Enum!
    //сделать проверку какую нибудь на создание файлов разных типов
    //каждый тип файла должен лежать в своей директории
    //выбрасывать exception при get запросе на файл
    //сделать геттер имени файла
    //можно сделать сервис по управлению директорией
    //сохранение новых данных можно делать через новый dataFile, либо через очитску старого дата файла

    public void loadToFile(FileModel type, int[] ids) {
        String str = null;
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < ids.length; i++) {
                str += session.get(Apartment.class, i).toString();
            }
            transaction.commit();
            createApartmentFile(type);
            Files.writeString(Path.of(dataApartmentFilePath, returnNameOfFileWithSuffix(type)), str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String returnNameOfFileWithSuffix(FileModel type) {
        return nameOfFile = nameOfFile + type.getType();
    }


    /**
     * получение файла,
     *
     * @param type
     * @return
     */
    @Override
    public File getDataFile(FileModel type) {
        return new File(dataApartmentFilePath + "/" + nameOfFile + type.getType());
    }

    public boolean createApartmentFile(FileModel type) { //лучше вынести в validate
        File file = new File(dataApartmentFilePath + "/" + nameOfFile + type.getType());

        try {
            boolean created = file.createNewFile();
            return created;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //вся информация хранится в базе данных
    public void saveAllDataToFile(FileModel type, int[] ids) { //добавить тут исключение // должен получить id
        String str = null;
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < ids.length; i++) {
                str += session.get(Apartment.class, i).toString();
            }
            transaction.commit();
            createApartmentFile(type);
            Files.writeString(Path.of(dataApartmentFilePath, returnNameOfFileWithSuffix(type)), str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteFile(FileModel type) throws IOException {
        Path path = Path.of(dataApartmentFilePath, nameOfFile + type.getType());
        return Files.deleteIfExists(path);
    }

    public boolean cleanDataFile(FileModel type) {
        try {
            Path path = Path.of(dataApartmentFilePath, (nameOfFile + type.getType()));
            Files.deleteIfExists(path);
            Files.createFile(Path.of(path + type.getType())); //Вот тут и создается файл!
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean checkFile(MultipartFile file) {
        if (!file.getName().contains(".json") || !file.getName().contains(".xml")) {
            return false;
        }
        if (file.getResource().toString().contains("id") &&
            file.getResource().toString().contains("metro") &&
            file.getResource().toString().contains("minutes") &&
            file.getResource().toString().contains("styles") &&
            file.getResource().toString().contains("comment") &&
            file.getResource().toString().contains("price") &&
            file.getResource().toString().contains("percentOfNature") &&
            file.getResource().toString().contains("rooms") &&
            file.getResource().toString().contains("meters") &&
            file.getResource().toString().contains("typeOfBuilding") &&
            file.getResource().toString().contains("side") &&
            file.getResource().toString().contains("comments")) {


        }
        return true;
    }
}
