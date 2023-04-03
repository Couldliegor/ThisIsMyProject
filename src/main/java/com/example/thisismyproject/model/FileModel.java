package com.example.thisismyproject.model;

public enum FileModel {
    XML(".xml"),
    JSON(".json");
    public String getType() {
        return type;
    }

    private String type;
    FileModel(String type) {
        this.type = type;
    }
}
