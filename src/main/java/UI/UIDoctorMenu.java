/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import com.mycompany.mymedicalappointment.model.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ecadiz
 */
public class UIDoctorMenu {
    
    public static ArrayList<Doctor> doctorsAvailableAppointments=new ArrayList<>();
    public static void showDoctorMenu(){
        int response=0;
        do{
            System.out.println("\n \nDoctor");
            System.out.println("welcome "+UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");
            
            Scanner sc=new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
            
            switch (response) {
                case 1:      
                    showAddAvailableAppointmentsMenu();
                    
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Insert a option validate");
            }
        }while(response!=0);
    }
    private static void showAddAvailableAppointmentsMenu(){
        int response =0;
        int responseDate=0;
        int responseTime=0;
        
        do{
            System.out.println("\n::Add Available Appointment"); 
            System.out.println("Select a Month");
            
            for (int i= 0; i <3; i++) {
               int j=i+1;
                System.out.println(j+". "+UIMenu.MONSTH[i]);
            }
            System.out.println("0. Return");
            
            Scanner sc=new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
           try { 
            if(response>0 && response<4){
                //1,2,3,
                
                    int monthselected=response;
                
                System.out.println(monthselected+". "+UIMenu.MONSTH[monthselected-1]);
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date=sc.nextLine();
                
                System.out.println("Your date is: "+date+"\n1. Correct \n2. Change Date");
                responseDate=Integer.valueOf(sc.nextLine());
                
                if(responseDate==2)continue;
                
                
                String time="";
                do{
                    System.out.println("Insert the time available for date: "+date+" [16:00]");
                    time= sc.nextLine();
                    System.out.println("Your time is: "+time+"\n1. Correct \n2. Change Time");
                    responseTime=Integer.valueOf(sc.nextLine());                    
                }while(responseTime==2);
                
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments( UIMenu.doctorLogged);
                
            }else if(response==0){
                showDoctorMenu();
            }
           } catch (NumberFormatException e) {
           System.out.println("Debe seleccionar el numero del mes \nLa opcion no es acceptable y genera este error: "+e);
           }
        }while(response!=0);                                           
    }
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}