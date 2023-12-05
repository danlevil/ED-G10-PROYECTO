/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Modelo.Agenda;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    @FXML
    private Label lblnombreSeleccion;
    private Contacto contactoSelecto;
    @FXML
    private ImageView imVolver;
    @FXML
    private Label idContacto;
    @FXML
    private Label IdPadre;
    @FXML
    private Label indiceEnListPadre;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //lblnombreSeleccion.setText("verTodoslosCorreosCP");
    }    

    
    //CONFIGURACIONES
    
     void configurarFechasI (Contacto contacto, String idPadre, String indiceEnListaPadre){
         contactoSelecto=contacto;
         nombreDeDato.setText("Fechas importantes");
         idContacto.setText(String.valueOf(contacto.getId())); 
         IdPadre.setText(idPadre);
         indiceEnListPadre.setText(indiceEnListaPadre);
         mostrarElementosFechasI(contacto);
     } 
    
     void configurarDireccionesP(Contacto contacto, String idPadre, String indiceEnListaPadre){
         nombreDeDato.setText("Direcciones");
         idContacto.setText(String.valueOf(contacto.getId()));
         IdPadre.setText(idPadre);
         indiceEnListPadre.setText(indiceEnListaPadre);
         mostrarElementosDireccionesP(contacto);
     }
     
     
     void configurarCelularPersonal(Contacto contacto, String idPadre, String indiceEnListaPadre) {
        nombreDeDato.setText("Celulares Personales");
        idContacto.setText(String.valueOf(contacto.getId()));
        IdPadre.setText(idPadre);
        indiceEnListPadre.setText(indiceEnListaPadre);
         mostrarElementosCeluares(contacto);
     }
     
     void configurarCorreo(Contacto contacto, String idPadre, String indiceEnListaPadre) {
        nombreDeDato.setText("Correo");
        idContacto.setText(String.valueOf(contacto.getId()));
        IdPadre.setText(idPadre);
        indiceEnListPadre.setText(indiceEnListaPadre);
        mostrarElementosCorreo(contacto);
     }
    
    
    
    
    //AGREGAR HBOX
     
     private void agregarHBoxFechasI(Contacto contacto){
         
         lblnombreSeleccion.setText("verTodaslasFechasICP");
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatos.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            InfoDeDatosController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int fechaIndex = VboxInformacion.getChildren().size();  // Usar el índice actual del VBox
            String nombreDeDatoAvisualizar = lblnombreSeleccion.getText();
            String idPapa = IdPadre.getText();
            controller.configurarFechasIm(contacto,contacto.getFechasImportantes().get(fechaIndex),fechaIndex, nombreDeDatoAvisualizar, idPapa );


            // Agregar el HBox al VBox
            VboxInformacion.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         
     }
    
     private void agregarHBoxDireccionesP(Contacto contacto){
         lblnombreSeleccion.setText("verTodaslasDireecionesCCP");
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatos.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            InfoDeDatosController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int direccionIndex = VboxInformacion.getChildren().size();  // Usar el índice actual del VBox
            String nombreDeDatoAvisualizar = lblnombreSeleccion.getText();
            String idPapa = IdPadre.getText();
            controller.configurarDireccionP(contacto,contacto.getDirecciones().get(direccionIndex),direccionIndex, nombreDeDatoAvisualizar, idPapa );


            // Agregar el HBox al VBox
            VboxInformacion.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
     }
    
     private void agregarHBoxCelular(Contacto contacto) {
        lblnombreSeleccion.setText("verTodoslosCelularesPCP");
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatos.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            InfoDeDatosController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int celularIndex = VboxInformacion.getChildren().size();  // Usar el índice actual del VBox
            String nombreDeDatoAvisualizar = lblnombreSeleccion.getText();
            String idPapa = IdPadre.getText();
            controller.configurarCelularPersonal(contacto,contacto.getTelefonos().get(celularIndex),celularIndex, nombreDeDatoAvisualizar, idPapa );


            // Agregar el HBox al VBox
            VboxInformacion.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     private void agregarHBoxCorreo(Contacto contacto) {
         lblnombreSeleccion.setText("verTodoslosCorreosCP");        
         
        try {
            // Cargar el FXML del HBox del archivo FXML respectivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoDeDatos.fxml"));
            Parent contactoNode = loader.load();
            //HBox hbox = loader.load();

            // Configurar el controlador del HBox
            InfoDeDatosController controller = loader.getController();
            // Obtener el índice de la lista de correos y configurar el correo correspondiente
            int correoIndex = VboxInformacion.getChildren().size();  // Usar el índice actual del VBox
            String nombreDeDatoAvisualizar = lblnombreSeleccion.getText();
            String idPapa = IdPadre.getText();
            controller.configurarCorreo(contacto,contacto.getEmails().get(correoIndex),correoIndex, nombreDeDatoAvisualizar, idPapa );


            // Agregar el HBox al VBox
            VboxInformacion.getChildren().add(contactoNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     
     
    //MOSTRAR ELEMENTOS 
     
     private void mostrarElementosFechasI(Contacto contacto){
         
         VboxInformacion.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getFechasImportantes().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxFechasI(contacto);
        }

        lbnumpag.setText( String.valueOf(paginaActual));
     }
     
    private void mostrarElementosDireccionesP(Contacto contacto){
        
        VboxInformacion.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getDirecciones().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxDireccionesP(contacto);
        }

        lbnumpag.setText( String.valueOf(paginaActual));
        
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

    private void mostrarElementosCeluares(Contacto contacto) {
       
        VboxInformacion.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, contacto.getTelefonos().size());

        for (int i = inicio; i < fin; i++) {
            agregarHBoxCelular(contacto);
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

        seleccionadorCaso(nombreDeDato.getText(), contactoSelecto);
    }

    @FXML
    private void avanzarDerecha(MouseEvent event) {
        
        int totalPaginas = (int) Math.ceil((double) Agenda.contactosMaster.size() / ELEMENTOS_POR_PAGINA);

        if (paginaActual < totalPaginas) {
            paginaActual--;
        } else {
            // Si estamos en la primera página, vamos al final
            paginaActual = 1;
        }

        seleccionadorCaso(nombreDeDato.getText(), contactoSelecto);

    }
    private void seleccionadorCaso(String tipoDato, Contacto contacto){
        switch(tipoDato){
            case "Correo":
                mostrarElementosCorreo(contacto);
                break;
            case "Fechas Importantes":
                mostrarElementosFechasI(contacto);
                break;
            case "default":
                System.out.println("caso default mostrar info extra");
                break;
                        
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void volverContacto(MouseEvent event) {
        int id = Integer.parseInt(idContacto.getText());
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
        reloadAsociadoOOriginal(event,contactoSeleccionado);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private void reload(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        
          
        int id = Integer.parseInt(idContacto.getText());
        
        Contacto contactoSeleccionado = buscarContactoPorId(id);
        
            if (contactoSeleccionado.isEmpresa()) {
                // Abrir la vista de contacto para empresas y pasar los datos
                abrirVistaContactoEmpresa(contactoSeleccionado);
            } else {
                // Abrir la vista de contacto para personas y pasar los datos
                abrirVistaContactoPersona(contactoSeleccionado);
            }
    }
    
     private void reloadAsociado(MouseEvent event, Contacto contacto){
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    // Cerrar la ventana actual
                    stage.close();

                        if (contacto.isEmpresa()) {
                            // Abrir la vista de contacto para empresas y pasar los datos
                            abrirVistaContactoEmpresa(contacto);
                        } else {
                            // Abrir la vista de contacto para personas y pasar los datos
                            abrirVistaContactoPersonaAsociada(contacto,Integer.parseInt(contacto.getIdContactoPadre()), Integer.parseInt(contacto.getIdcontactoEnListaDePadre()));
                        }
        
    }
    
     private void reloadAsociadoOOriginal(MouseEvent event, Contacto contactoSeleccionado){
        if (!indiceEnListPadre.getText().equals("Label")){
                    
                 reloadAsociado(event, contactoSeleccionado);
            }else{
                 reload(event); 
                 
             }
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

    private void abrirVistaContactoPersona(Contacto contacto) {
        
    
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurar((ContactoPersona) contacto); // Método para pasar los datos del contacto
            
            
            
            Scene scene = new Scene(root, 900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
            
            stage.setResizable(false);
          
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     private void abrirVistaContactoPersonaAsociada(Contacto contacto, int idPadre, int indiceListaDePadre) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaInfoContacto.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la vista de contacto para personas
            VistaInfoContactoController controller = loader.getController();
            controller.configurarAsociado((ContactoPersona) contacto, idPadre, indiceListaDePadre); // Método para pasar los datos del contacto
            
            
            
            Scene scene = new Scene(root, 900,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista de Contacto para Personas");
            
            stage.setResizable(false);
          
            stage.show();
           
        } catch (Exception e) {
            e.printStackTrace();
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
    
    
    
    
}
