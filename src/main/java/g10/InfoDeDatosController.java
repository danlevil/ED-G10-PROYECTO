/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Fields.Email;
import Fields.Telefono;
import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class InfoDeDatosController implements Initializable {

    @FXML
    private HBox hboxContact1;
    @FXML
    private VBox contacto1Vbox;
    @FXML
    private Label lbdescripcion;
    @FXML
    private Label lbdato;
    @FXML
    private Label Lblid;
    @FXML
    private Label lbIdDato;
    @FXML
    private Label lblnombreSeleccion;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setMouseEvent(hboxContact1);
    }
    
    
    //CONFIGURACIONES
    
    public void configurarCelularPersonal(Contacto contacto, Telefono telefono, int idTelefono, String datoAvisualizar) {
        
        lbdescripcion.setText(telefono.getDescripcion());
        lbdato.setText(telefono.getNumero());
        Lblid.setText(String.valueOf(contacto.getId())); 
        System.out.println(Lblid.getText());
        lbIdDato.setText(String.valueOf(idTelefono));
        lblnombreSeleccion.setText(datoAvisualizar);
    }
    
    
    
    
    public void configurarCorreo(Contacto contacto, Email email, int idCorreo, String datoAvisualizar) {
        
        lbdescripcion.setText(email.getDescripcion());
        lbdato.setText(email.getDireccionCorreo());
        Lblid.setText(String.valueOf(contacto.getId())); 
        System.out.println(Lblid.getText());
        lbIdDato.setText(String.valueOf(idCorreo));
        lblnombreSeleccion.setText(datoAvisualizar);
    }
    
    
    
    
    //RELOADS
    
    private void reloadCorreo(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
        int id = Integer.parseInt(Lblid.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        abrirVistaCorreo(contactoSeleccionado);
        
    }
    
    private void reloadCelular(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
        int id = Integer.parseInt(Lblid.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        abrirVistaCelular(contactoSeleccionado);
        
    }
    
    //ABRIR VISTAS
    
    private void abrirVistaCorreo(Contacto contacto) {
        
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarCorreo(contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de correos de contacto: "+contacto.getNombre());
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void abrirVistaCelular(Contacto contacto) {
        
         try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatosContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            InfoDeDatosContactoController controller = loader.getController();
            controller.configurarCelularPersonal(contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de celulares de contacto: "+contacto.getNombre());
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
      
    //CONFIRMAR QUE DATO SE VA A ELIMINAR
    @FXML
    private void eliminar(MouseEvent event) {
       if(lblnombreSeleccion.getText().equals("verTodoslosCorreosCP")){
           eliminarCorreo(event);    
       }else if(lblnombreSeleccion.getText().equals("verTodoslosCelularesPCP")){
         eliminarCelular(event);
        
        }         
   
    }
    
    
    //ELIMINACIONES
    private void eliminarCorreo (MouseEvent event){
        
        int id = Integer.parseInt(Lblid.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        int correoIndex = Integer.parseInt(lbIdDato.getText());
        
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmar Eliminación de Correo");
        alert.setHeaderText("¿Está seguro que desea eliminar este Dato?");
        alert.setContentText("Esta acción no se puede deshacer.");
        ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
        
        Optional<ButtonType> resultado = alert.showAndWait();
        
        if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
            contactoSeleccionado.getEmails().remove(correoIndex);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information Dialog");
            alert1.setHeaderText("Resultado de la operación");
            alert1.setContentText("Correo eliminado exitosamente");
            alert1.showAndWait();
        
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage.close();
            reloadCorreo(event);
        }
        
        
        
    }
    
    
    private void eliminarCelular(MouseEvent event){
        
        int id = Integer.parseInt(Lblid.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        int celularIndex = Integer.parseInt(lbIdDato.getText());
        
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmar Eliminación de Celular");
        alert.setHeaderText("¿Está seguro que desea eliminar este Dato?");
        alert.setContentText("Esta acción no se puede deshacer.");
        ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);
        
        Optional<ButtonType> resultado = alert.showAndWait();
        
        if (resultado.isPresent() && resultado.get() == buttonTypeAceptar) {
            contactoSeleccionado.getTelefonos().remove(celularIndex);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information Dialog");
            alert1.setHeaderText("Resultado de la operación");
            alert1.setContentText("Correo eliminado exitosamente");
            alert1.showAndWait();
        
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage.close();
            reloadCelular(event);
        }
        
        
        
    }
    
    
    
    private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }

    private void setMouseEvent(HBox hboxContact) {
         // Manejador para el evento de ratón al entrar en la sección
        hboxContact.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
        hboxContact.setStyle("-fx-background-color: lightblue;");
        });

        // Manejador para el evento de ratón al salir de la sección
        hboxContact.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
        hboxContact.setStyle("-fx-background-color: ;");
        });
    }
    
    

    
    
    
}
