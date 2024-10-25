/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mymedicalappointment;

import static UI.UIMenu.showMenu;
import com.mycompany.mymedicalappointment.model.*;

import java.util.Date;

/**
 *
 * @author ecadiz
 */
public class MyMedicalAppointment {

    public static void main(String[] args) {
        showMenu();
      /* Doctor myDoctor= new Doctor("Robeto Angulo","Rober@gmail.com", "Pediatra");
       myDoctor.addAvailableAppointment(new Date(), "5pm.");
       myDoctor.addAvailableAppointment(new Date(), "9am.");
       myDoctor.addAvailableAppointment(new Date(), "2pm.");
       
        Patient patient= new Patient("Alverto Del Rio", "Alveto@gmail.com");
        System.out.println(myDoctor);
        System.out.println(patient);
       
        User usu=new Doctor("Vanessa Gonzalez", "Vane@gmail.com", "Cirujano");
        usu.showDataUser();
        
        User usuPat=new Patient("Vanessa Gonzalez", "Vane@gmail.com");
        usuPat.showDataUser();
        
        User user1= new User("Jonas", "Jhon@gmail.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("hospital: Cruz Roja");                
                System.out.println("Departamento: Geriatria");
            }
        };
        user1.showDataUser();
                
        ISchedulable iSchedulable= new ISchedulable() {
           @Override
           public void schedule(Date date, String time) {
               ISchedulable iSchedulable1=new AppointmentDoctor();
               iSchedulable1.schedule(date, time);
           }
        };
        
        
        System.out.println(myDoctor.getAvailableAppointments());
       for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate()+" "+aA.getTime());            
        }
        
        
        patient.setWeight(56.4);
        System.out.println(patient.getWeight());
        
        patient.setPhoneNumber("12345678");
        System.out.println(patient.getPhoneNumber());*/
    }
}
