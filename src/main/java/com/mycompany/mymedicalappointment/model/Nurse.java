/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymedicalappointment.model;

/**
 *
 * @author ecadiz
 */
public class Nurse extends User{
    private String speciality;
    
    public Nurse(String name, String email){
        super(name,email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Verde");
        System.out.println("Departamento: Nutriologia, Pediatria");
    }
    
}