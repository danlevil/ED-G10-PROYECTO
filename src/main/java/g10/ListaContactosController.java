/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import java.io.IOException;
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


    @FXML
    private ImageView imgFiltro;
    @FXML
    private ImageView imgBotonAgregar;
    @FXML
    private Label txtFiltro;
    @FXML
    private ImageView imgcontacto1;
    @FXML
    private Label lbcontactonombre1;
    @FXML
    private Label lbcontactocorreo1;
    @FXML
    private ImageView imgcontacto2;
    @FXML
    private Label lbcontactonombre2;
    @FXML
    private Label lbcontactocorreo2;
    @FXML
    private ImageView imgcontacto3;
    @FXML
    private Label lbcontactonombre3;
    @FXML
    private Label lbcontactocorreo3;
    @FXML
    private ImageView imgcontacto4;
    @FXML
    private Label lbcontactonombre4;
    @FXML
    private Label lbcontactocorreo4;
    @FXML
    private ImageView imgcontacto5;
    @FXML
    private Label lbcontactonombre5;
    @FXML
    private Label lbcontactocorreo5;
    @FXML
    private ImageView imgcontacto6;
    @FXML
    private Label lbcontactonombre6;
    @FXML
    private Label lbcontactocorreo6;
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
    @FXML
    private VBox contacto1Vbox;
    @FXML
    private HBox hboxContact1;
    @FXML
    private HBox hboxContact2;
    @FXML
    private HBox hboxContact3;
    @FXML
    private HBox hboxContact4;
    @FXML
    private HBox hboxContact5;
    @FXML
    private HBox hboxContact6;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setMouseEvent(hboxContact1);
        setMouseEvent(hboxContact2);
        setMouseEvent(hboxContact3);
        setMouseEvent(hboxContact4);
        setMouseEvent(hboxContact5);
        setMouseEvent(hboxContact6);
        
        
    }    
    
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
    }

    @FXML
    private void abrirContactoInfo(MouseEvent event) throws IOException {
        // Obtener la Stage actual
       // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
