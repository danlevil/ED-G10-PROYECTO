/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoPersona;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AgregarContactoAsociadoPersonaController implements Initializable {

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
    private Label Direccion;
    @FXML
    private TextField TxtdirTrabajoUsuario;
    @FXML
    private DatePicker fechaImportante;
    @FXML
    private TextField TxtfechaImpUsuario;
    @FXML
    private ComboBox<String> CboxFav;
    @FXML
    private Label IdContactoPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("S", "N");
        CboxFav.setItems(list);
    }    
    

    void configurarACAP(Contacto contacto){
        IdContactoPadre.setText(String.valueOf(contacto.getId()));
        
    }
    
    @FXML
    private void regresar(MouseEvent event) {
    }

    @FXML
    private void agregarContacto(MouseEvent event) {
        int id = Integer.parseInt(IdContactoPadre.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
         if (guardarContacto(TxtnombreUsuario, TxtcelularUsuario, TxtcorreoUsuario, TxtcelTrabajoUsuario, TxtdireccionUsuario, TxtdirTrabajoUsuario, fechaImportante, TxtfechaImpUsuario, CboxFav) == false){
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          ContactoPersona contactoPersonaNuevo= new ContactoPersona(TxtnombreUsuario.getText());
        contactoPersonaNuevo.agregarDireccion("Dirección de casa",TxtdireccionUsuario.getText());
        contactoPersonaNuevo.agregarDireccion("Dirección de trabajo",TxtdirTrabajoUsuario.getText());
        contactoPersonaNuevo.agregarEmail("Correo Principal", TxtcorreoUsuario.getText());
        contactoPersonaNuevo.agregarTelefono("Celular personal", TxtcelTrabajoUsuario.getText());
        contactoPersonaNuevo.agregarTelefono("Celular de trabajo", TxtcelTrabajoUsuario.getText());
        contactoPersonaNuevo.agregarFechaImportante(TxtfechaImpUsuario.getText(), fechaImportante.getValue());
        
        contactoSeleccionado.getContactosRelacionados().add(contactoPersonaNuevo);
        
        
        

        
        LocalDate cumpleaños = LocalDate.of(2023,01,01);
        String seleccion = CboxFav.getSelectionModel().getSelectedItem();
        if(seleccion.equals("S")){
            contactoPersonaNuevo.setFavorito(true);
        }else{
            contactoPersonaNuevo.setFavorito(false);
        }
        
        
        Agenda.agregarContactoPersona(contactoPersonaNuevo); 
        Agenda.agregarGeneral(contactoPersonaNuevo);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Nuevo contacto agregado exitosamente");
        alert.showAndWait();
        stage.close();
        
        abrirListaContactoPadre(event);
         
            
     }else{
          
      }
        
        
        
    }
    
    
    
    
    
    
    
    void abrirListaContactoPadre(MouseEvent event){
        int id = Integer.parseInt(IdContactoPadre.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaInfoContactosAsociados.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            ListaInfoContactosAsociadosController controller = loader.getController();
            controller.configurarContactosAsociados(contactoSeleccionado); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de contactos asociados de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private boolean guardarContacto(TextField TxtnombreUsuario, TextField TxtcelularUsuario, TextField TxtcorreoUsuario, TextField TxtcelTrabajoUsuario,TextField TxtdireccionUsuario, TextField TxtdirTrabajoUsuario, DatePicker fechaImportante ,TextField TxtfechaImpUsuario, ComboBox<String> CboxFav ) {
        // Verificar que los campos no estén vacíos
        if (TxtnombreUsuario.getText().isEmpty() || TxtcelularUsuario.getText().isEmpty() || TxtcorreoUsuario.getText().isEmpty() || TxtcelTrabajoUsuario.getText().isEmpty() || TxtdireccionUsuario.getText().isEmpty() || TxtdirTrabajoUsuario.getText().isEmpty() || fechaImportante.getValue() == null || TxtfechaImpUsuario.getText().isEmpty() || CboxFav.getSelectionModel().isEmpty()) {
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
    
    
     private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
    
    
}
