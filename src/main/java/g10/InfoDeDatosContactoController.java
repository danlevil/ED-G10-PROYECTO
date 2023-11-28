/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class InfoDeDatosContactoController implements Initializable {

    @FXML
    private VBox VboxInformacion;
    @FXML
    private ImageView imgBotonant;
    @FXML
    private Label lbnumpag;
    @FXML
    private ImageView imgBotonsig;
    @FXML
    private Label nombreDeDato;
    
    private static final int ELEMENTOS_POR_PAGINA=6;
    private static int paginaActual=1;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    void configurarCorreo(Contacto contacto) {
        nombreDeDato.setText("Correos");
        mostrarElementosCorreo(contacto);
    }
    
    
     private void agregarHBoxCorreo(Contacto contacto) {
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatos.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            InfoDeDatosController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int correoIndex = VboxInformacion.getChildren().size();  // Usar el índice actual del VBox
            controller.configurarCorreo(contacto,contacto.getEmails().get(correoIndex));


            // Agregar el HBox al VBox
            VboxInformacion.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     
    private void mostrarElementosCorreo(Contacto contacto) {
       
        VboxInformacion.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getEmails().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxCorreo(contacto);
        }

        lbnumpag.setText( String.valueOf(paginaActual));
    }     
     
    @FXML
    private void avanzarIzquierda(MouseEvent event) {
    }

    @FXML
    private void avanzarDerecha(MouseEvent event) {
        
        
//         int totalPaginas = (int) Math.ceil((double) .getEmails().size() / ELEMENTOS_POR_PAGINA);
//
//        if (paginaActual < totalPaginas) {
//            paginaActual++;
//        } else {
//            // Si llegamos al final, regresamos a la primera página
//            paginaActual = 1;
//        }
//
//        mostrarElementosCorreo();
    }

    
    
    
    
}
