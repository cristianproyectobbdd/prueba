/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparking;

/**
 *
 * @author JSC
 */
public class ParkingMain {
    public static void main(String[] args) {
        Parking p = new Parking();
                
        PlazaParking plaza1 = new PlazaParking("SE3454AY",1);
        PlazaParking plaza2 = new PlazaParking("SE56754DM",3);
        PlazaParking plaza3 = new PlazaParking("5491KJH",4);
        
        p.insertarVehiculo(plaza1);
        p.insertarVehiculo(plaza2);
        p.insertarVehiculo(plaza3);
        
        
       // p.porcentajeOcupación();
       //p.retirarVehiculo(1);
       //p.posLibrePrint();
       p.buscarMatricula("sdsdsds");
//       p.verOcupacion();
//       PlazaParking plaza4 = new PlazaParking("3434yut",6);
//       p.insertarVehiculo(plaza4);
//       p.buscarMatricula("3434yut");
//       p.listaMatriculas();
       
       
    }
}
