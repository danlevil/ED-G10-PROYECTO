/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class ContactoController implements Initializable {
    private static final long serialVersionUID=1L;

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
    private Label Lblid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       setMouseEvent(hboxContact1);
    }
    
    
      
       
       
    
    
    public void configurar(Contacto contacto) {
        lbcontactonombre.setText(contacto.getNombre());
        lbcontactocorreo.setText(contacto.getCorreo().getDireccionCorreo());
        Lblid.setText(String.valueOf(contacto.getId())); 
    }
    
    

    

    @FXML
    private void abrirContactoInfo(MouseEvent event) throws IOException {
        int id = Integer.parseInt(Lblid.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
            if (contactoSeleccionado.isEmpresa()) {
                // Abrir la vista de contacto para empresas y pasar los datos
                abrirVistaContactoEmpresa(contactoSeleccionado);
            } else {
                // Abrir la vista de contacto para personas y pasar los datos
                abrirVistaContactoPersona(contactoSeleccionado);
            }
        
       // App.setRoot("VistaInfoContacto"); se comenta para que no se abra la vista
        
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
            
            
            
            // Crear la escena y configurar la Stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Empresas");
          
            // Mostrar la nueva ventana
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción si ocurre algún error al cargar la vista
        }
        
    }

    private void abrirVistaContactoPersona(Contacto contacto) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurar((ContactoPersona) contacto); // Método para pasar los datos del contacto
            
            
            
            // Crear la escena y configurar la Stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
          
            // Mostrar la nueva ventana
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción si ocurre algún error al cargar la vista
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
