/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Estructuras.ArrayList;
import Estructuras.LinkedCircularDE;
import Fields.Direccion;
import Fields.Email;
import Fields.Fecha;
import Fields.Foto;
import Fields.RedSocial;
import Fields.Telefono;
import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoPersona;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class AgregarContactoPersonaController implements Initializable {

    @FXML
    private ImageView iconoRegresar;
    @FXML
    private Label labelRegistarContacto;
    @FXML
    private ImageView guardarContacto;
    @FXML
    private TextField TxtnombreUsuario;
    @FXML
    private TextField TxtcorreoUsuario;
    @FXML
    private TextField TxtcelularUsuario;
    @FXML
    private TextField TxtcelTrabajoUsuario;
    @FXML
    private TextField TxtdireccionUsuario;
    @FXML
    private Label Direccion;
    @FXML
    private TextField TxtdirTrabajoUsuario;
    @FXML
    private DatePicker fechaImportante;
    @FXML
    private TextField TxtfechaImpUsuario;
    @FXML
    private ComboBox<String> CboxFav;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("S", "N");
        CboxFav.setItems(list);
        
    }    
    
    
    
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        App.setRoot("TipoContacto");
    }

    @FXML
    private void agregarContacto(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        String textoDireccion = TxtdirTrabajoUsuario.getText();
        Direccion direccionTrabajo = new Direccion("Dirección de trabajo", textoDireccion);
        direcciones.add(direccionTrabajo);
        
        ArrayList<Direccion> direccionPersonales = new ArrayList<>();
        String textoDireccionP = TxtdireccionUsuario.getText();
        Direccion direccionPersonal = new Direccion("Dirección de casa", textoDireccionP);
        direccionPersonales.add(direccionPersonal);
        
        ArrayList<Email> emails = new ArrayList<>();
        String textoCorreo = TxtcorreoUsuario.getText();
        Email correo = new Email("Correo Principal", textoCorreo);
        emails.add(correo);
        
        ArrayList<Telefono> telefonos = new ArrayList<>();
        String textoTelefonoTrabajo = TxtcelTrabajoUsuario.getText();
        Telefono telefonoTrabajo = new Telefono("Celular de trabajo", textoTelefonoTrabajo);
        telefonos.add(telefonoTrabajo);
        
        ArrayList<Telefono> telefonosPersonales = new ArrayList<>();
        String telefonoPersonal = TxtcelularUsuario.getText();
        Telefono telefonoPersona = new Telefono("Celular personal", telefonoPersonal);
        telefonosPersonales.add(telefonoPersona);
        
        LinkedCircularDE<Foto> fotos = new LinkedCircularDE<>();
        
        
        ArrayList<RedSocial> redesSociales = new ArrayList<>();
        /*String redsocial = .getText();
        RedSocial redSocialPersona = new RedSocial("Redes sociales", redsocial);
        redesSociales.add(redSocialPersona);*/
        
        ArrayList<String> etiquetas = new ArrayList<>();
        /*String etiquetatx = TxtcelularUsuario.getText();
        Telefono telefonoPersona = new Telefono("Celular personal", telefonoPersonal);
        telefonosPersonales.add(telefonoPersona);
        */
        LinkedCircularDE<Fecha> fechasImportantes = new LinkedCircularDE<>();
        String descripcionFecha = TxtfechaImpUsuario.getText();
        LocalDate fecha = fechaImportante.getValue();
        Fecha fechaImportante = new Fecha(descripcionFecha,fecha);
        fechasImportantes.add(fechaImportante);
        
        LocalDate cumpleaños = LocalDate.of(2023,01,01);
        
        
        boolean favorito;
        String seleccion = CboxFav.getSelectionModel().getSelectedItem();
        if(seleccion.equals("S")){
            favorito=true;
        }else{
            favorito=false;
        }
        
        ContactoPersona contactoPersonaNuevo = new ContactoPersona(TxtnombreUsuario.getText(), false, favorito, direcciones, direccionPersonales, emails, telefonos,telefonosPersonales, fotos, redesSociales, etiquetas, fechasImportantes, cumpleaños);
        Agenda.agregarContactoPersona(contactoPersonaNuevo); 
        Agenda.agregarGeneral(contactoPersonaNuevo);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Nuevo contacto agregado exitosamente");
        alert.showAndWait();
        stage.close();
         
       // App.setRoot("ListaContactos");
       

        // Cargar el FXML y obtener la raíz
        Platform.runLater(() -> {
        try {
            // Crear una nueva instancia de la aplicación
            App nuevaInstancia = new App();

            // Llamar al método start para iniciar la nueva instancia
            nuevaInstancia.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         });

       
       
       /* ListaContactosController lcc = new ListaContactosController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
        loader.setController(lcc);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setUserData(lcc);
        stage.show();*/
        /*Stage listaContactoStage = new Stage();
        listaContactoStage.setScene(scene);
        listaContactoStage.show();*/

    }
    
    
}
