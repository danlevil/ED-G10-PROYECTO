/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import g10.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author danlevil
 */
public class AgregarContactoController implements Initializable {


    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView iconoImage;
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
    @FXML
    private TextField TxtnacionalidadUsuario;
    @FXML
    private TextField TxtlinkGMUsuario;
    @FXML
    private TextField TxtNotasUsuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void agregarContacto(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
