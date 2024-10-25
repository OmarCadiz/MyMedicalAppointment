/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymedicalappointment.model;

import com.mycompany.mymedicalappointment.model.User;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ecadiz
 */
public class Patient extends User{

    private String birthday;
    private String blood;
    private double height;
    private double weight;
    
    private ArrayList<AppointmentDoctor> appointmentDoctors= new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentsNurses= new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor= new AppointmentDoctor(this,doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentsNurses() {
        return appointmentsNurses;
    }

    public void setAppointmentsNurses(ArrayList<AppointmentNurse> appointmentsNurses) {
        this.appointmentsNurses = appointmentsNurses;
    }
    
    
    public Patient(String name, String email){
        super(name, email);   
    }   

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getHeight() {
        return height+" Mts";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getWeight() {
        return weight+" Kg";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString()+"\nAge: "+birthday+"\n Weight: "+getWeight()+"\n Height "+getHeight()+"\nBlood: "+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente del Hospital: Universitario de Caracas");
        System.out.println("Historial completos desde nacimiento");
        
    }
    
}