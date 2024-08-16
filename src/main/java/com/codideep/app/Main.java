/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.codideep.app;

import com.codideep.app.helper.Helper;
import com.codideep.business.AverageApiStream;
import com.codideep.business.AverageForkJoin;
import com.codideep.business.AverageFunctional;
import com.codideep.com.dto.Person;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author KAAF0
 */
public class Main {

    public static void main(String[] args) {        
        List<Person> listPerson = Helper.generatePeople(5000000);
        
        System.out.println("========================");
        
        AverageFunctional.Process(listPerson);
        
        System.out.println("========================");
        
        AverageApiStream.Process(listPerson);
        
        System.out.println("========================");
        
        long lastTimeTemp = Helper.getCurrentMiliSecondsTime();
        
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        
        AverageForkJoin averageForkJoin = new AverageForkJoin(listPerson, 0, listPerson.size());
        
        forkJoinPool.invoke(averageForkJoin);
        
        System.out.println("Promedio de edades: " + (averageForkJoin.getResultWithoutAverage() / listPerson.size()));
        
        System.out.println("Promedio obtenido con API Fork/Join en: " + Helper.getMiliSeconsPassed(lastTimeTemp) + " milisegundos");
    }
}
