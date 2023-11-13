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
    
    private static final int ELEMENTOS_POR_PAGINA=6;
    private static int paginaActual=1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mostrarElementos();
        
    }
    
    
    
    int numeroPag = 1;
    
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
 
    
    @FXML
    private void filtrar(MouseEvent event) throws IOException {
        App.setRoot("FiltroContacto");
    }

    @FXML
    private void añadirContacto(MouseEvent event) throws IOException {
       App.setRoot("TipoContacto");
    }
    
    private void mostrarElementos() {
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());

        for (int i = inicio; i < fin; i++) {
            agregarHBox(Agenda.contactosMaster.get(i));
        }

        lbnumpag.setText( String.valueOf(paginaActual));
    }    
    @FXML
    private void avanzarIzquierda(MouseEvent event) {

        int totalPaginas = (int) Math.ceil((double) Agenda.contactosMaster.size() / ELEMENTOS_POR_PAGINA);

        if (paginaActual > 1) {
            paginaActual--;
        } else {
            // Si estamos en la primera página, vamos al final
            paginaActual = totalPaginas;
        }

        mostrarElementos();
    }
    
    @FXML
    private void avanzarDerecha(MouseEvent event) {

        int totalPaginas = (int) Math.ceil((double) Agenda.contactosMaster.size() / ELEMENTOS_POR_PAGINA);

        if (paginaActual < totalPaginas) {
            paginaActual++;
        } else {
            // Si llegamos al final, regresamos a la primera página
            paginaActual = 1;
        }

        mostrarElementos();
       
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
