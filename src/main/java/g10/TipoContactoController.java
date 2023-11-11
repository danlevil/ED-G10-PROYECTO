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
public class TipoContactoController implements Initializable {


    @FXML
    private Button btContactPersona;
    @FXML
    private Button btContactEmpresa;
    @FXML
    private ImageView imgVolver;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irVentanPersonas(ActionEvent event) {
    }

    @FXML
    private void irVentanEmpresas(ActionEvent event) {
    }

    @FXML
    private void irVentanaContactos(MouseEvent event) throws IOException {
        App.setRoot("ListaContactos");
    }

}
