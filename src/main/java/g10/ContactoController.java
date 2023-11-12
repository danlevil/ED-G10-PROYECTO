/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Contacto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class ContactoController implements Initializable {

    @FXML
    private HBox hboxContact1;
    @FXML
    private ImageView imgcontacto;
    @FXML
    private VBox contacto1Vbox;
    @FXML
    private Label lbcontactonombre;
    @FXML
    private Label lbcontactocorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         String rutaArchivo = "src/main/resources/Contactos/listaContactos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
       
        
       private void procesarLinea(String linea) {
            String[] campos = linea.split(";");
    
            // Asegurarse de que haya suficientes campos antes de acceder a ellos
            if (campos.length >= 2) {
            String id = campos[0];
            String nombre = campos[1];
            String correo = obtenerCorreo(campos);

            // Configurar la interfaz de Contacto
            configurarContacto(nombre, correo);
         }
    }
       
       private String obtenerCorreo(String[] campos) {
        for (String campo : campos) {
        if (campo.contains("Correo Principal")) {
            String[] partes = campo.split(":");
            if (partes.length >= 2) {
                return partes[1].trim(); 
            }
        }
    }
    return "";
}
    
    
    public void configurarContacto(String nombre, String correo) {
        lbcontactonombre.setText(nombre);
        lbcontactocorreo.setText(correo);
        
    }
    
    

    

    @FXML
    private void abrirContactoInfo(MouseEvent event) {
    }
    
}
