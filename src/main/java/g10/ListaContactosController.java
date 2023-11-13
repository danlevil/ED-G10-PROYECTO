/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.LinkedCircularDE;
import Estructuras.List;
import Modelo.Agenda;
import Modelo.Contacto;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class ListaContactosController implements Initializable {
    private static final long serialVersionUID=1L;


    @FXML
    private ImageView imgFiltro;
    @FXML
    private ImageView imgBotonAgregar;
    @FXML
    private Label txtFiltro;
    @FXML
    private ImageView imgBotonant;
    @FXML
    private Label lbnumpag;
    @FXML
    private ImageView imgBotonsig;
    /**
     * Initializes the controller class.
     */
    
    private static Scene scene;
    
    private HBox hboxContact1;
    @FXML
    private VBox VboxContactos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarContactosDesdeArchivo();
        // TODO
        //setMouseEvent(hboxContact1);
        lbnumpag.setText(String.valueOf(1));
    }
    
    
    int numeroPag = 2;
    
    
    public void cargarContactosDesdeArchivo() {
        
            // Agrega cada contacto al VBox usando el método agregarHBox
            
            int contador = 0;
            for (Contacto contacto : Agenda.contactosMaster) {
                agregarHBox(contacto);
                contador ++;
                if(contador == 6){
                    break;
                }
            }  
    }
    
    private void agregarHBox(Contacto contacto) {
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Contacto.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            ContactoController controller = loader.getController();
            controller.configurar(contacto);

            // Agregar el HBox al VBox
            VboxContactos.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
   /* public void agregarContacto(Contacto contacto){
      try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Contacto.fxml"));
        Parent contactoNode = loader.load(); 
      
        ContactoController controladorDeContacto = loader.getController();
        controladorDeContacto.configurarContacto(nombre, correo);
        contacto1Vbox.getChildren().add(contactoNode);
      }catch (IOException e) {
            e.printStackTrace();
        }
      
        
    }*/
    
    
    
    @FXML
    private void filtrar(MouseEvent event) throws IOException {
        App.setRoot("FiltroContacto");
    }

    @FXML
    private void añadirContacto(MouseEvent event) throws IOException {
       App.setRoot("TipoContacto");
    }

    @FXML
    private void avanzarIzquierda(MouseEvent event) {
    }
    
    
    @FXML
    private void avanzarDerecha(MouseEvent event) {
       lbnumpag.setText(String.valueOf(numeroPag++));
    }

    private void abrirContactoInfo(MouseEvent event) throws IOException {
        // Obtener la Stage actual
       //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
        Parent root = loader.load();

        // Configurar el controlador 
        VistaInfoContactoController vic = loader.getController();
        // pasando datos al controlador de la nueva ventana aquí, si es necesario

        // Crear una nueva escena
        Scene scene = new Scene(root, 900, 700);

        // Configurar el tamaño fijo de la ventana
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Nueva Ventana");
        nuevaVentana.setScene(scene);
        nuevaVentana.setResizable(false);

        // Mostrar la nueva ventana
        nuevaVentana.show();
        
        //stage.close();
        
        
    }
    
     private void setMouseEvents(VBox vbox) {
       
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
