/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Fields.Fecha;
import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class ContactoAsociadoController implements Initializable {

    @FXML
    private HBox hboxContact1;
    @FXML
    private ImageView imgcontacto;
    @FXML
    private VBox contacto1Vbox;
    @FXML
    private Label lbcontactonombre;
    @FXML
    private Label lbcontactocorreo;
    @FXML
    private Label LblidContactoPadre;
    @FXML
    private Label IdDeContactoAsociadoGeneral;
    @FXML
    private Label IdContactoEnLista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setMouseEvent(hboxContact1);
    }    
    
    void configurar(Contacto contacto,  Contacto contactoAsociado, int idContactoAsociado){
        lbcontactonombre.setText(contactoAsociado.getNombre());
        lbcontactocorreo.setText(contactoAsociado.getCorreoPrincipal().getDireccionCorreo());
        LblidContactoPadre.setText(String.valueOf(contacto.getId())); 
        IdDeContactoAsociadoGeneral.setText(String.valueOf(contactoAsociado.getId())); 
        IdContactoEnLista.setText(String.valueOf(idContactoAsociado)); 
    }

    @FXML
    private void abrirContactoInfo(MouseEvent event) {
        int idHijo = Integer.parseInt(IdContactoEnLista.getText());
        int idPadre = Integer.parseInt(LblidContactoPadre.getText());
        int id = Integer.parseInt(IdDeContactoAsociadoGeneral.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        //this.contactoSeleccionado=contactoSeleccionado;
        
            if (contactoSeleccionado.isEmpresa()) {
                // Abrir la vista de contacto para empresas y pasar los datos
                System.out.println("soy de empresa "+contactoSeleccionado.getId());
                abrirVistaContactoEmpresa(contactoSeleccionado);
            } else {
                // Abrir la vista de contacto para personas y pasar los datos
                abrirVistaContactoPersona(contactoSeleccionado, idPadre, idHijo);
            }
            
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage.close();
            
            
    }
        
        
    
        
    
    
    
     private Contacto buscarContactoPorId(int id) {
         for (Contacto contacto : Agenda.contactosMaster){
             if (contacto.getId() == id){
                 return contacto; 
             }
         }
     
        return null;
    }
    
    private void abrirVistaContactoEmpresa(Contacto contacto) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaContactoEmpresa.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaContactoEmpresaController controller = loader.getController();
            controller.configurar((ContactoEmpresa) contacto); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de Contacto para Empresas");
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void abrirVistaContactoPersona(Contacto contacto, int idPadre, int idHijo) {
        //coger el label e insertarlo 
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurarAsociado((ContactoPersona) contacto, idPadre); // Método para pasar los datos del contacto
            
            
            
            Scene scene = new Scene(root, 900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
            
            stage.setResizable(false);
          
            stage.show();
            System.out.println(idPadre);
            System.out.println(contacto.getId());
            System.out.println(idHijo);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
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
