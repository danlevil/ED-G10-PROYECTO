/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Contacto;
import Modelo.ContactoPersona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class VistaInfoContactoController implements Initializable {
    private static final long serialVersionUID=1L;


    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView iconoEditar;
    @FXML
    private ImageView imgFotoContacto;
    @FXML
    private Label lbnombreCP;
    @FXML
    private Label lbcorreoCP;
    @FXML
    private Label lbcelulerPCP;
    @FXML
    private Label lbDireccionCP;
    @FXML
    private Label lbDireccionTCP;
    @FXML
    private Label lbFechaCP;
    @FXML
    private Label lbcelularTCP;
    @FXML
    private ImageView imgGM;
    @FXML
    private Label lbEtiquetasCP;
    @FXML
    private Button btVermasinfo;
    @FXML
    private Button btContactAsoci;
    @FXML
    private Label LblDescrFecha;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void configurar(ContactoPersona contacto) {
        lbnombreCP.setText(contacto.getName());
        lbcorreoCP.setText(contacto.getCorreo().getDireccionCorreo());
        lbcelulerPCP.setText(contacto.getTelefonoPersonal().getNumero());
        lbDireccionCP.setText (contacto.getDireccionPersonal().getUbicacion());
        lbDireccionTCP.setText (contacto.getDireccion().getUbicacion());
        lbFechaCP.setText(contacto.getFechaImportante().getFecha());
        LblDescrFecha.setText(contacto.getFechaImportante().getFechaDescripcion());
        lbcelularTCP.setText(contacto.getTelefono().getNumero());
        //falta poner etiquetas y link para google maps   
      
     }
    
    @FXML
    private void editarContacto(MouseEvent event) {
        System.out.println("Contacto Editado");
    }

    @FXML
    private void mostrarInfoExtra(ActionEvent event) {
    }

    @FXML
    private void mostrarVentanAsociados(ActionEvent event) {
    }

    private void regresarAListaContactos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
        Platform.runLater(() -> {
        try {
            // Crear una nueva instancia de la aplicación
            App nuevaInstancia = new App();

            // Llamar al método start para iniciar la nueva instancia
            nuevaInstancia.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         });
    }

}
