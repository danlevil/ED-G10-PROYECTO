/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Charlie
 */
public class TipoContactoAsociadoController implements Initializable {

    @FXML
    private ImageView imgVolver;
    @FXML
    private Button btContactPersona;
    @FXML
    private Button btContactEmpresa;
    @FXML
    private Label IdContactoPadre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void configurarTipoContactoAs (Contacto contacto){
       IdContactoPadre.setText(String.valueOf(contacto.getId()));
        
    }
    @FXML
    private void irVentanaContactos(MouseEvent event) {
    }

    @FXML
    private void irVentanPersonas(ActionEvent event) {
        int id = Integer.parseInt(IdContactoPadre.getText());//  se toma el id del contacto padre 
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarContactoAsociadoPersona.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            AgregarContactoAsociadoPersonaController controller = loader.getController();
            controller.configurarACAP(contactoSeleccionado); // Método para pasar los datos del contacto

            Scene scene = new Scene(root,900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Vista de celulares de contacto: "+contactoSeleccionado.getNombre());
            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

          // Cerrar la ventana actual
          stage1.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void irVentanEmpresas(ActionEvent event) {
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
