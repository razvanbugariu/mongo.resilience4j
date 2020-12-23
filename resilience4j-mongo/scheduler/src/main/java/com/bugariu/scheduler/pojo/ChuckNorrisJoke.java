package com.bugariu.scheduler.pojo;

public class ChuckNorrisJoke {

    private String id;
    private String value;

    public ChuckNorrisJoke() {
    }

    public ChuckNorrisJoke(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ChuckNorrisJoke{" +
                "value='" + value + '\'' +
                '}';
    }
}
