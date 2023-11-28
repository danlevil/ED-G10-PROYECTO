/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Contacto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class VerFotosContactosController implements Initializable {
    private static final long serialVersionUID=1L;
    @FXML
    private ImageView regresar;
    @FXML
    private ImageView izquierda;
    @FXML
    private ImageView derecha;
    @FXML
    private Label idContacto;
    @FXML
    private VBox vboxFotos;
    
    private static final int ELEMENTOS_POR_PAGINA=6;
    
    private static int paginaActual=1;
    @FXML
    private Label lbnumpag;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void configurarFotosContactos(Contacto contacto){
        idContacto.setText(String.valueOf(contacto.getId()));
        mostrarElementosFotos(contacto);
    }    

    
    
    
    private void agregarHBoxFoto(Contacto contacto){
         
        try {
            
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Foto.fxml"));
            Node  imageView = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            FotoController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int fotoIndex = vboxFotos.getChildren().size();  // Usar el índice actual del VBox
            //String nombreDeDatoAvisualizar = lblnombreSeleccion.getText();
            controller.configurarFechasIm(contacto,contacto.getFotos().get(fotoIndex), fotoIndex);


            // Agregar el HBox al VBox
            vboxFotos.getChildren().add(imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         
     }
    
    
     private void mostrarElementosFotos(Contacto contacto){
         
         vboxFotos.getChildren().clear();
        int inicio = (paginaActual) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getFechasImportantes().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxFoto(contacto);
        }

        lbnumpag.setText( String.valueOf(paginaActual));
     }
     
     
    @FXML
    private void regresarPantalla(MouseEvent event) {
    }

    @FXML
    private void anterior(MouseEvent event) {
    }

    @FXML
    private void siguiente(MouseEvent event) {
    }
    
}
