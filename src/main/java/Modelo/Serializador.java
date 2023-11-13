/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author danlevil
 */
public class Serializador {
    private static final long serialVersionUID=1L;

    private static final String RUTA = "src/main/resources/Contactos/";
    
    public static void serializarTodosLosContactos(List<Contacto> contactosMaster, 
            List<ContactoEmpresa> contactosEmpresas, 
            List<ContactoPersona> contactosPersonas) {
        if (!Agenda.contactosPersonas.isEmpty()) {
            serializarListaPersonas(contactosPersonas, "listaContactosComunes.ser");
        }

        if (!Agenda.contactosEmpresas.isEmpty()) {
            serializarListaEmpresa(contactosEmpresas, "listaContactosEmpresas.ser");
        }

        if (!Agenda.contactosMaster.isEmpty()) {
            serializarLista(contactosMaster, "listaGeneral.ser");
        }

        mostrarAlerta("Serialización completa", "Todos los contactos han sido serializados y guardados correctamente.");
    }
    private static void serializarLista(List<Contacto> listaContactos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombreArchivo))) {
            oos.writeObject(listaContactos);
            oos.flush();
            System.out.println("Lista serializada y guardada correctamente en: " + RUTA + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void serializarListaEmpresa(List<ContactoEmpresa> listaContactos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombreArchivo))) {
            oos.writeObject(listaContactos);
            oos.flush();
            System.out.println("Lista serializada y guardada correctamente en: " + RUTA + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void serializarListaPersonas(List<ContactoPersona> listaContactos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombreArchivo))) {
            oos.writeObject(listaContactos);
            oos.flush();
            System.out.println("Lista serializada y guardada correctamente en: " + RUTA + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       private static void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
