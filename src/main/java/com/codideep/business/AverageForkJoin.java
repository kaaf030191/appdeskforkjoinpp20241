/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.business;

import com.codideep.com.dto.Person;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author KAAF0
 */
public class AverageForkJoin extends RecursiveAction {
    private final int maxSplit = 10000;
    private final List<Person> listPerson;
    private final int startIndex, endIndex;
    private double result = 0;
    
    public AverageForkJoin(List<Person> listPerson, int startIndex, int endIndex) {
        this.listPerson = listPerson;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    
    public double getResultWithoutAverage() {
        return result;
    }
    
    @Override
    protected void compute() {
        if((endIndex - startIndex) <= maxSplit) {
            for(int i = startIndex; i < endIndex; i++) {
                result += listPerson.get(i).getAge();
            }
        } else {
            int middleIndex = (startIndex + endIndex) / 2;
            
            AverageForkJoin leftAfj = new AverageForkJoin(listPerson, startIndex, middleIndex);
            AverageForkJoin rightAfj = new AverageForkJoin(listPerson, middleIndex, endIndex);
            
            leftAfj.fork();
            
            rightAfj.compute();
            
            leftAfj.join();
            
            result = leftAfj.result + rightAfj.result;
        }
    }
}
