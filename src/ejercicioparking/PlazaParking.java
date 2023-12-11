/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparking;

import java.util.Scanner;

/**
 *
 * @author JSC
 */
public class PlazaParking {
    
    private String matricula;
    private int hora;
    
    public PlazaParking(){
        this.matricula="";
    }
    
    public PlazaParking(String matricula, int hora){    //controlo la hora en el constructor de plaza
        Scanner scan = new Scanner(System.in);
        do{
        this.matricula=matricula;
        this.hora=hora;
        if(this.hora<1||this.hora>24){
                System.out.println("Error, introduza una hora válida. Entre 1 y 24."); 
                this.hora= scan.nextInt();
                
        }
        }while(this.hora<1||this.hora>24);
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula=matricula;        
    }
    
    public int getHora(){
        return hora;
    }
    
    public void setHora(int hora){ //lo tenia mal, hay que validar la hora aqui también. Lo suyo es crear un metodo validarHora;
        this.hora=hora;
    }
    
    @Override
    public String toString(){
       return "El vehiculo con matrícula "+this.matricula+" entró en el Parking "
               + "a las "+this.hora+"h.";
    }
}
