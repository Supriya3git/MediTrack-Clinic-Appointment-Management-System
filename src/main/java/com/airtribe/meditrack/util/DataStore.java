package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.List;

public class DataStore<T> {

    private final List<T> data = new ArrayList<>();

    public void add(T object) {
        data.add(object);
    }

    public void remove(T object) {
        data.remove(object);
    }

    public List<T> getAll() {
        return data;
    }
}