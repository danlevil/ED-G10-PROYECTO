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
    private static final long serialVersionUID=1L;

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
    @FXML
    private Label Lblid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       setMouseEvent(hboxContact1);
    }
    
    
      
       
       
    
    
    public void configurar(Contacto contacto) {
        lbcontactonombre.setText(contacto.getNombre());
        lbcontactocorreo.setText(contacto.getCorreo().getDireccionCorreo());
        Lblid.setText(String.valueOf(contacto.getId())); 
    }
    
    

    

    @FXML
    private void abrirContactoInfo(MouseEvent event) throws IOException {
        
        App.setRoot("VistaInfoContacto");
        
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
