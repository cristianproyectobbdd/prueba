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
public class Parking {
    
    private final String POSICION_VACIA="";                                     //declaro esta constante para usarla como control de ocupacion
    private PlazaParking[] plazas;                                              //declaro el array de plazas
    private final int PVP=2;
    Scanner scan = new Scanner(System.in); 
    
    
    public Parking(){                                                           //el constructor se inicia con un array de 20 PlazaParking que  
        this.plazas=new PlazaParking[20];                                       //a su vez se inician con el constructor por defecto, con una matricula que es
        for(int i=0;i<this.plazas.length;i++){                                  //una cadena vacía.
            this.plazas[i]= new PlazaParking();
        }
    }
    
    public PlazaParking[] getPlazas(){
        return this.plazas;
    }
    
    public int posLibre (){                                                     //Método para buscar la primera posición vacía
        for (int i=0;i<this.plazas.length;i++){                                 //lo hace buscando la primera cadena vacía y comparándola
            if(POSICION_VACIA.equals(this.plazas[i].getMatricula()))            //con la constante.
                return i;
        }
        
        return -1;
    }
    public void insertarVehiculo (PlazaParking nuevo){                          //Método para insertar coches
        
        //primero comprobamos la pos libre con el metodo
                        
        int posLibre = this.posLibre();
        
        if (posLibre == -1){
            System.out.println("Lo sentimos, el Parking está completo.");
            return; //retorno para detener la ejecución del método
        }
        
        //Si hay sitio libre, insertamos en la primera posición:
        this.plazas[posLibre]=nuevo;  
    }
    
    public void posLibrePrint(){
        for (int i=0;i<this.plazas.length;i++){                                 //como el anterior pero sumando 1 a la posición del indice
            if(POSICION_VACIA.equals(this.plazas[i].getMatricula())){            
                System.out.println("La primera plaza libre es la "+(1+i));
                return;
            }
        }    
    }
    
    public void porcentajeOcupación(){
        float ocupadas=0;
        
        for(int i=0;i<this.plazas.length;i++){
             if(!POSICION_VACIA.equals(this.plazas[i].getMatricula()))
                ocupadas++;
        }
        
         System.out.printf("El Parking tiene una ocupación del %.0f%% " ,ocupadas/this.plazas.length*100);
    }
    
    public void verOcupacion (){
        for(int i=0;i<this.plazas.length;i++){
             if(POSICION_VACIA.equals(this.plazas[i].getMatricula()))
                 System.out.println("Plaza "+(i+1)+" Libre");
             else
                 System.out.println("Plaza "+(i+1)+" Ocupada");
         }
    }
    
    public void retirarVehiculo(int horaSalida){                                //no he validado la hora de salida, hacer el metodo
        String matriBuscar;
        int posPlaza, importe;
        System.out.println("Introduzca la matrícula del vehículo a retirar.");
        matriBuscar = scan.nextLine();
        posPlaza=this.buscarMatricula(matriBuscar);
        if(posPlaza== -1)
            return;
        else{
            if(horaSalida>= this.plazas[posPlaza].getHora()){
                importe = ((horaSalida-1) - this.plazas[posPlaza].getHora())*this.PVP;
            }
            else{
                importe = ((this.plazas[posPlaza].getHora()-1) - horaSalida )*this.PVP;
            }
            if(importe<=0){
                System.out.println("Su estancia es gratuita. Gracias y hasta pronto.");
            }
            else{
                System.out.println("El importe a pagar es: "+importe+" euros. Gracias y hasta pronto.");
            }
            this.plazas[posPlaza].setMatricula("");
        }
            
    }
    
    public int buscarMatricula(String matriBuscar){
       for(int i=0;i<this.plazas.length;i++){
            if(!POSICION_VACIA.equals(this.plazas[i].getMatricula())){
                if(this.plazas[i].getMatricula().equalsIgnoreCase(matriBuscar))
                    return i;
            }
        }
    System.out.println("La matrícula introducida no corresponde con ningún vehículo.");
    return -1;
    }
    
    public void listaMatriculas(){
        for(int i=0;i<this.plazas.length;i++){
            if(!POSICION_VACIA.equals(this.plazas[i].getMatricula())){
                System.out.println("Plaza "+(1+i)+": "+this.plazas[i].getMatricula());
            }
        }    
    }
    
//    @Override
//    public String toString(){
//        return this.plazas.verOcupacion();
//    }
}
