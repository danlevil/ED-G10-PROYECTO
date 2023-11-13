/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.List;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author danlevil
 */
public class CargadorDeArchivos {
    private static final long serialVersionUID=1L;

    private static final String RUTA = "src/main/resources/Contactos/";
    public static void cargarListasDesdeArchivos() {
        try(ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(RUTA+"listaContactosComunes.ser"));
        ){
            Agenda.contactosPersonas = (List<ContactoPersona>) ois1.readObject();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        try (ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(RUTA+"listaContactosEmpresas.ser"));
                
        ) {
            Agenda.contactosEmpresas = (List<ContactoEmpresa>) ois2.readObject();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        try(ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(RUTA+"listaGeneral.ser"))){
            Agenda.contactosMaster= (List<Contacto>) ois3.readObject();

        } 
        catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
}
