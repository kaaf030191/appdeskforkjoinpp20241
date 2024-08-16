/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.helper;

import com.codideep.com.dto.Person;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class Helper {
    public static List<Person> generatePeople(int peopleQuantity) {
        Faker faker = new Faker();
        
        List<Person> listPerson = new ArrayList<>();
        
        long lastTime = getCurrentMiliSecondsTime();

        for (int i = 0; i < peopleQuantity; i++) {
            String idPerson = faker.idNumber().valid();
            String firstName = faker.name().firstName();
            String surName = faker.name().lastName();
            int age = faker.number().numberBetween(0, 100);

            listPerson.add(new Person(idPerson, firstName, surName, age));
        }
        
        System.out.println("Datos generados en: " + getMiliSeconsPassed(lastTime) + " milisegundos");
        
        return listPerson;
    }
    
    public static long getCurrentMiliSecondsTime() {
        return System.currentTimeMillis();
    }
    
    public static long getMiliSeconsPassed(long initTime) {
        return getCurrentMiliSecondsTime() - initTime;
    }
}
