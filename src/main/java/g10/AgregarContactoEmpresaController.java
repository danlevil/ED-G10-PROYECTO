/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.ArrayList;
import Estructuras.LinkedCircularDE;
import Fields.Direccion;
import Fields.Email;
import Fields.Fecha;
import Fields.Foto;
import Fields.RedSocial;
import Fields.Telefono;
import Modelo.Agenda;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
    private static final long serialVersionUID=1L;

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
    private void guardarContactoEmpresa(MouseEvent event) throws IOException {
        
      if(guardarContacto(TxtnombreEmpresa, TxtcelularPEmpresa, TxtcorreoEmpresa, TxtcelTrabajoEmpresa, TxtTituloEnEmpresa, txtdirecciónEmpresa,  txtCargoEmpresa1, fechaImportante , TxtfechaImpUsuario, CboxFav ) == false){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ContactoEmpresa contactoEmpresaNuevo= new ContactoEmpresa(TxtnombreEmpresa.getText());
        contactoEmpresaNuevo.agregarDireccion("Dirección de empresa",txtdirecciónEmpresa.getText());
        contactoEmpresaNuevo.agregarEmail("Correo empresa", TxtcorreoEmpresa.getText());
        contactoEmpresaNuevo.agregarTelefono("Celular de trabajo", TxtcelTrabajoEmpresa.getText());
        contactoEmpresaNuevo.agregarTelefono("Celular personal", TxtcelularPEmpresa.getText());
        contactoEmpresaNuevo.setTitulo(TxtTituloEnEmpresa.getText());
        contactoEmpresaNuevo.setPuestoTrabajo(txtCargoEmpresa1.getText());

        contactoEmpresaNuevo.agregarFechaImportante(TxtfechaImpUsuario.getText(), fechaImportante.getValue());
        
        LocalDate cumpleaños = LocalDate.of(2023,01,01);
        String seleccion = CboxFav.getSelectionModel().getSelectedItem();
        if(seleccion.equals("S")){
            contactoEmpresaNuevo.setFavorito(true);
        }else{
            contactoEmpresaNuevo.setFavorito(false);
        }
        
        
        Agenda.agregarContactoEmpresa(contactoEmpresaNuevo); 
        Agenda.agregarGeneral(contactoEmpresaNuevo);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Nuevo contacto agregado exitosamente");
        alert.showAndWait();
        stage.close();
        Platform.runLater(() -> {
        try {

            App nuevaInstancia = new App();


            nuevaInstancia.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         });
      }
        

    
    }
    
    private boolean guardarContacto(TextField TxtnombreEmpresa, TextField TxtcelularPEmpresa, TextField TxtcorreoEmpresa, TextField TxtcelTrabajoEmpresa,TextField TxtTituloEnEmpresa,TextField txtdirecciónEmpresa, TextField txtCargoEmpresa1,DatePicker fechaImportante ,TextField TxtfechaImpUsuario, ComboBox<String> CboxFav ) {
        // Verificar que los campos no estén vacíos
        if (TxtnombreEmpresa.getText().isEmpty() || TxtcelularPEmpresa.getText().isEmpty() || TxtcorreoEmpresa.getText().isEmpty() || TxtcelTrabajoEmpresa.getText().isEmpty()||TxtTituloEnEmpresa.getText().isEmpty() || txtdirecciónEmpresa.getText().isEmpty() || txtCargoEmpresa1.getText().isEmpty() || fechaImportante.getValue() == null || TxtfechaImpUsuario.getText().isEmpty() || CboxFav.getSelectionModel().isEmpty()) {
            // Mostrar un mensaje de error si algún campo está vacío
            mostrarError("Todos los campos son obligatorios", "Por favor, complete todos los campos.");
            return true;
        } 
            return false;
        
    }
    
    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    

}
