/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import com.mycompany.mymedicalappointment.model.Doctor;
import com.mycompany.mymedicalappointment.model.Patient;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ecadiz
 */
public class UIMenu {
    
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    
    final static String MONSTH[]= {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
    
    public static void showMenu(){
        System.out.println("Welcome to my Appointment");
        System.out.println("Selecciona la opcion deseada");
        
        int response=0;
        
        do{
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Salir");
            
            Scanner sc=new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1:
                    System.out.println("Doctor");
                    response=0;
                    authUser(1);
                    break;
                case 2:
                    response=0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for your visit");
                    break;
                default:
                    System.out.println("Elige una opcion correcta");
        }
        }while(response !=0);
    }
    private static void authUser(int userType){
        //user type=1
        //user type=2
        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.add(new Doctor("Alejandro Martinez","Alejandro@gmail.com","Ginecologia" ));
        doctores.add(new Doctor("Karen Mendez","karen@gmail.com","Medicina General" ));
        doctores.add(new Doctor("Rosa Alvarez","Rosa@gmail.com","Pediatra" ));
        
        ArrayList<Patient> pacientes= new ArrayList<>();
        pacientes.add(new Patient("Ricando Rodriguez","Rica@gmail.com" ));
        pacientes.add(new Patient("Alverto Mendoza","Alva@gmail.com" ));
        pacientes.add(new Patient("Estefany Agilar","estefy@gmail.com" ));
        
        boolean emailCorrect=false;
        do{
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc= new Scanner(System.in);
            String email= sc.nextLine();
            if (userType==1) {
                for (Doctor d: doctores) {
                    if(d.getEmail().equals(email)){
                        emailCorrect=true;
                        //obtener el usuario logeado
                        doctorLogged= d;
                         UIDoctorMenu.showDoctorMenu();
                    }
                }
            }else if(userType==2){
                for (Patient p: pacientes) {
                    if(p.getEmail().equals(email)){
                        emailCorrect=true;
                        //obtener el usuario logeado
                        patientLogged=p;
                        UIPatientMenu.showPatientMenu();
                    }                    
                }
            }            
        }while(!emailCorrect);
    }
}