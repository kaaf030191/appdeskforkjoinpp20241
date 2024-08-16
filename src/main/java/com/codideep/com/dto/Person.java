/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author KAAF0
 */

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String idPerson;
    private String firstName;
    private String surName;
    private int age;
}
