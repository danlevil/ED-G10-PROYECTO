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
import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class AgregarContactoEmpresaController implements Initializable {


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
    private TextField txtdirecciónEmpresa;
    @FXML
    private TextField txtCargoEmpresa1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        
        App.setRoot("TipoContacto");
    }

    @FXML
    private void guardarContactoEmpresa(MouseEvent event) {
    }

}
