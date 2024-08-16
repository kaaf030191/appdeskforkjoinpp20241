/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.business;

import com.codideep.app.helper.Helper;
import com.codideep.com.dto.Person;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class AverageApiStream {
    public static void Process(List<Person> listPerson) {
        long lastTime = Helper.getCurrentMiliSecondsTime();
        
        double averageAge = listPerson.parallelStream()
                .mapToDouble(person -> person.getAge())
                .average()
                .orElse(0);
        
        System.out.println("Promedio de edades: " + averageAge);
        
        System.out.println("Promedio obtenido con API Stream en: " + Helper.getMiliSeconsPassed(lastTime) + " milisegundos");
    }
}
