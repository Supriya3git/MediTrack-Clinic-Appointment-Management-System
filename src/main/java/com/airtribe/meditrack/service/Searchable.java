package com.airtribe.meditrack.service;

public interface Searchable {
    default void search(){
        System.out.println("Searching....");
    }
}
