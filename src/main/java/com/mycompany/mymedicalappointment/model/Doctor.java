/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymedicalappointment.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecadiz
 */
public class Doctor extends User  {
    private int id;
    private String name;
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments=new ArrayList<>();
   
    public Doctor(String name, String email, String speciality){
        super(name, email);
        this.speciality=speciality;
    }
    
    //coportamientos
    public String getSpeciality(){
        return speciality;
    }

    public void showName() {
        System.out.println(name);
    }
   
    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSpeciality: "+speciality+"\nAvailable: "+availableAppointments.toString(); 
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
        
    }
    
    public static class AvailableAppointment{
        private int id_availableAppointment;
        private Date date;
        private String time;
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.time = time;
        }

        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Avaiable Appointments \n Date: "+date+"\nTime: "+time+"\n"; 
        }              
    } 
}
