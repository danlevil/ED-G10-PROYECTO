/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ComboBox<String> CboxFav;
    @FXML
    private TextField txtdirecciónEmpresa;
    @FXML
    private TextField txtCargoEmpresa1;
    @FXML
    private DatePicker fechaImportante;
    @FXML
    private TextField TxtfechaImpUsuario;
    
    @FXML
    private Label IdContactoPadre;
    @FXML
    private Label IdListaDeContactoPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("S", "N");
        CboxFav.setItems(list);
    }    

    
    void configurarACAE(Contacto contacto, int listaindex){
        IdContactoPadre.setText(String.valueOf(contacto.getId()));
        IdListaDeContactoPadre.setText(String.valueOf(listaindex));
        
    }
    
    
    @FXML
    private void regresar(MouseEvent event) {
        
        int id = Integer.parseInt(IdContactoPadre.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        int numeroDeContactoNuevo = contactoSeleccionado.getContactosRelacionados().size();
        System.out.println(numeroDeContactoNuevo);
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TipoContactoAsociado.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            TipoContactoAsociadoController controller = loader.getController();
            controller.configurarTipoContactoAs(contactoSeleccionado, numeroDeContactoNuevo); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de tipo de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    @FXML
    private void agregarContacto(MouseEvent event) {
         int id = Integer.parseInt(IdContactoPadre.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        
        if(guardarContacto(TxtnombreEmpresa, TxtcelularPEmpresa, TxtcorreoEmpresa, TxtcelTrabajoEmpresa, TxtTituloEnEmpresa, txtdirecciónEmpresa,  txtCargoEmpresa1, fechaImportante , TxtfechaImpUsuario, CboxFav ) == false){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ContactoEmpresa contactoEmpresaNuevo= new ContactoEmpresa(TxtnombreEmpresa.getText(),IdContactoPadre.getText(),IdListaDeContactoPadre.getText());
        contactoEmpresaNuevo.agregarDireccion("Dirección de empresa",txtdirecciónEmpresa.getText());
        contactoEmpresaNuevo.agregarEmail("Correo empresa", TxtcorreoEmpresa.getText());
        contactoEmpresaNuevo.agregarTelefono("Celular de trabajo", TxtcelTrabajoEmpresa.getText());
        contactoEmpresaNuevo.agregarTelefono("Celular personal", TxtcelularPEmpresa.getText());
        contactoEmpresaNuevo.setTitulo(TxtTituloEnEmpresa.getText());
        contactoEmpresaNuevo.setPuestoTrabajo(txtCargoEmpresa1.getText());

        contactoEmpresaNuevo.agregarFechaImportante(TxtfechaImpUsuario.getText(), fechaImportante.getValue());
        
        
        contactoSeleccionado.getContactosRelacionados().add(contactoEmpresaNuevo);
        

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
    
     private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }

    
     
     
     
}
