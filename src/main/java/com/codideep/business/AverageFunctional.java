/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.business;

import com.codideep.com.dto.Person;
import java.util.List;
import com.codideep.app.helper.Helper;

/**
 *
 * @author KAAF0
 */
public class AverageFunctional {
    public static void Process(List<Person> listPerson) {
        long lastTime = Helper.getCurrentMiliSecondsTime();
        
        double averageAge = 0;
        
        for(Person item: listPerson) {
            averageAge += item.getAge();
        }
        
        averageAge = averageAge / listPerson.size();
        
        System.out.println("Promedio de edades: " + averageAge);
        
        System.out.println("Promedio obtenido con programación funcional en: " + Helper.getMiliSeconsPassed(lastTime) + " milisegundos");
    }
}
