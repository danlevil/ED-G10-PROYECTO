/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class AgregarContactoController implements Initializable {


    @FXML
    private ImageView iconoRegresar;
    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView guardarContacto;
    @FXML
    private TextField TxtnombreUsuario;
    @FXML
    private TextField TxtcorreoUsuario;
    @FXML
    private TextField TxtcelularUsuario;
    @FXML
    private TextField TxtcelTrabajoUsuario;
    @FXML
    private TextField TxtdireccionUsuario;
    @FXML
    private TextField TxtdirTrabajoUsuario;
    @FXML
    private DatePicker fechaImportante;
    @FXML
    private TextField TxtfechaImpUsuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        App.setRoot("ListaContactos");
    }

    @FXML
    private void agregarContacto(MouseEvent event) {
    }

}
