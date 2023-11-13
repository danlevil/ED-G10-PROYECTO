/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

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
    @FXML
    private ComboBox<String> CboxFav;
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
        ObservableList<String> list = FXCollections.observableArrayList("S", "N");
        CboxFav.setItems(list);
    }    
    
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        App.setRoot("TipoContacto");
    }

    @FXML
    private void guardarContactoEmpresa(MouseEvent event) {
    }

}
