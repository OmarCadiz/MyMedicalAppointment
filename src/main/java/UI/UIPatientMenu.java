/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import com.mycompany.mymedicalappointment.model.Doctor;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ecadiz
 */
public class UIPatientMenu {
    
    public static void showPatientMenu(){
        int response=0;
        
        do{
            System.out.println("\n\n");
            System.out.println("Welcome Patient "+UIMenu.patientLogged.getName()+"\n");
            System.out.println("1. Book an appointment \n2. My appointments \n3. 0. Logout");
            
            Scanner sc=new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
            
            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                default:
                    System.out.println("Esta no es una opcion valida");
            }
        }while(response!=0);
    }
    private static void showBookAppointmentMenu(){
        int response=0;
        
        do{
            System.out.println(":: Book and appointment");
            System.out.println(":: Select date: ");
            
            //numeracion de la lista de fechas ,Indice de la fecha seleccionada, Tambien tiene una lista de 
            //Doctores[doctor1,doctor2,etc] y cada uno tiene un array de citas disponibles
            Map<Integer , Map<Integer, Doctor>> doctors= new TreeMap<>();
            int k=0;           
            for (int i = 0; i <UIDoctorMenu.doctorsAvailableAppointments.size() ; i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments= UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                
                Map<Integer, Doctor> doctorAppointments= new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                   k++; 
                    System.out.println(k+". "+availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }          
            Scanner sc=new Scanner(System.in);
            int responseDateSelected=Integer.valueOf(sc.nextLine());
             Map<Integer,Doctor> doctorAvailableSelected=doctors.get(responseDateSelected);
             Integer indexDate=0;
             Doctor doctorSelected= new Doctor("Roberto Angulo","Rober@gmail.com","Traumatologia");
            
             for (Map.Entry<Integer,Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate= doc.getKey();
                doctorSelected= doc.getValue();                               
            }
            System.out.println(doctorSelected.getName()+
                    ". Date: "+doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    ". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Date");
            response= Integer.valueOf(sc.nextLine());
            
            if(response==1){
               UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                       doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                       doctorSelected.getAvailableAppointments().get(indexDate).getTime());
               showPatientMenu();
            }
        }while(response !=0);
    }
    private static void showPatientMyAppointments(){
      int response =0;
      do{
          System.out.println("::My Appointments");
          if(UIMenu.patientLogged.getAppointmentDoctors().size()==0){
              System.out.println("Don't have appointMes");
              break;
          }
          for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
              int j=i+1;
              System.out.println(j+". Date: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate()+
                      "Time: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                      "\n Doctor: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
          }
          System.out.println("0. Return");
      }while(response !=0);
    }
}