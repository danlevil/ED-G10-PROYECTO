/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class FiltroContactoController implements Initializable {
    private static final long serialVersionUID=1L;


    @FXML
    private Button btFiltroNombre;
    @FXML
    private Button btFiltroNacionalidad;
    @FXML
    private Button btFiltroFavoritos;
    @FXML
    private ImageView imgRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void filtrarEmpresas(ActionEvent event) {
        
        
    }

    @FXML
    private void filtrarFavoritos(ActionEvent event) {
        
        
    }

    
    @FXML
    private void irVentanaContactos(MouseEvent event) throws IOException {
        App.setRoot("ListaContactos");
    }

    @FXML
    private void filtrarPorPersonas(ActionEvent event) {
    }

}
