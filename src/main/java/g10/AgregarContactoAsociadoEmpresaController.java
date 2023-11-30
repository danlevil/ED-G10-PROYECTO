/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
public class AgregarContactoAsociadoEmpresaController implements Initializable {

    @FXML
    private ImageView iconoRegresar;
    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView guardarEmpresa;
    @FXML
    private TextField TxtnombreEmpresa;
    @FXML
    private TextField TxtcorreoEmpresa;
    @FXML
    private TextField TxtcelularPEmpresa;
    @FXML
    private TextField TxtcelTrabajoEmpresa;
    @FXML
    private TextField TxtTituloEnEmpresa;
    @FXML
    private ComboBox<?> CboxFav;
    @FXML
    private TextField txtdirecciónEmpresa;
    @FXML
    private TextField txtCargoEmpresa1;
    @FXML
    private DatePicker fechaImportante;
    @FXML
    private TextField TxtfechaImpUsuario;
    @FXML
    private Label idContactoPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(MouseEvent event) {
    }

    @FXML
    private void guardarContactoEmpresa(MouseEvent event) {
    }
    
}
