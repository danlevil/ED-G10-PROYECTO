/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Fields.Email;
import Modelo.Agenda;
import Modelo.Contacto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class InfoDeDatosController implements Initializable {

    @FXML
    private HBox hboxContact1;
    @FXML
    private VBox contacto1Vbox;
    @FXML
    private Label lbdescripcion;
    @FXML
    private Label lbdato;
    @FXML
    private Label Lblid;

    public Contacto contactoSeleccionado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setMouseEvent(hboxContact1);
    }
    
    
//    public void configurarTelefonoPersonal(Contacto contacto) {
//        this.contactoSeleccionado=contacto;
//
//        lbdescripcion.setText(contacto.getNombre());
//        lbdato.setText(contacto.getCorreoPrincipal().getDireccionCorreo());
//        Lblid.setText(String.valueOf(contacto.getId())); 
//        System.out.println(Lblid.getText());
//    }
    
    public void configurarCorreo(Contacto contacto, Email email) {
        
        lbdescripcion.setText(email.getDescripcion());
        lbdato.setText(email.getDireccionCorreo());
        Lblid.setText(String.valueOf(contacto.getId())); 
        System.out.println(Lblid.getText());
    }
    
    private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
    
    @FXML
    private void eliminar(MouseEvent event) {
        
        
        
    }

    private void setMouseEvent(HBox hboxContact) {
         // Manejador para el evento de ratón al entrar en la sección
        hboxContact.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
        hboxContact.setStyle("-fx-background-color: lightblue;");
        });

        // Manejador para el evento de ratón al salir de la sección
        hboxContact.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
        hboxContact.setStyle("-fx-background-color: ;");
        });
    }

    
    
    
}
