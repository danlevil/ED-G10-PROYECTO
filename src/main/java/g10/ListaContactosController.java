/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Comparadores.ComparadorEmpresa;
import Comparadores.ComparadorFavoritos;
import Comparadores.ComparadorNombreContacto;
import Comparadores.ComparadorPersona;
import Estructuras.LinkedCircularDE;
import Estructuras.List;
import FIltradores.FiltradorEmpresas;
import FIltradores.FiltradorFavoritos;
import FIltradores.FiltradorNombre;
import Modelo.Agenda;
import Modelo.Contacto;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

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
    @FXML
    private ComboBox<String> cbOrden;
    @FXML
    private Button btOrdenar;
    
    String seleccion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mostrarElementos();
        ObservableList<String> list = FXCollections.observableArrayList("Orden alfabético","Favoritos", "Personas", "Empresas", "Original");
        cbOrden.setItems(list);
        
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
        seleccion = "Orden alfabético";
        
        
        if (seleccion.equals("Orden alfabético")){
            mostrarElementoAlfabeticamente();
        
        }else if(seleccion.equals("Favoritos")){
            mostrarPersonasPrimero();
        
        
        }else if(seleccion.equals("Personas")){
            mostrarFavoritosPrimero();
        
        
        }else if(seleccion.equals("Empresas")){
            mostrarEmpresasPrimero();
        
        }else{
            
         VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        for (int i = inicio; i < fin; i++) {
            agregarHBox(Agenda.contactosMaster.get(i));    
        }
         lbnumpag.setText( String.valueOf(paginaActual));
        }
        

    }



    
    private void mostrarElementoAlfabeticamente(){
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        ComparadorNombreContacto cmp1= new ComparadorNombreContacto();
        List<Contacto> alfabetica= Agenda.contactosMaster.ordenar(cmp1);     
        for (int i = inicio; i < fin; i++) {
            agregarHBox(alfabetica.get(i));

        }
        lbnumpag.setText( String.valueOf(paginaActual));
    }
    
    
    private void mostrarEmpresasPrimero(){
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        ComparadorEmpresa cmp2= new ComparadorEmpresa();
        List<Contacto> empresasFirst=Agenda.contactosMaster.ordenar(cmp2);  
        for (int i = inicio; i < fin; i++) {
            agregarHBox(empresasFirst.get(i));
        }
        lbnumpag.setText( String.valueOf(paginaActual));
    }
    
    
    private void mostrarFavoritosPrimero(){
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        ComparadorFavoritos cmp3= new ComparadorFavoritos();
        List<Contacto> favFirst=Agenda.contactosMaster.ordenar(cmp3);
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        for (int i = inicio; i < fin; i++) {
            agregarHBox(favFirst.get(i));
        }
        lbnumpag.setText( String.valueOf(paginaActual));
    }
    
    
    private void mostrarPersonasPrimero(){
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        ComparadorPersona cmp4= new ComparadorPersona();
        List<Contacto> personasFirst=Agenda.contactosMaster.ordenar(cmp4);   
        for (int i = inicio; i < fin; i++) {
            agregarHBox(personasFirst.get(i));
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

    @FXML
    private void ordenarPor(ActionEvent event) throws IOException {
       String seleccion2 = cbOrden.getSelectionModel().getSelectedItem();
       
       if(cbOrden.getSelectionModel().isEmpty() == true){
           mostrarError("El cuadro de ordenar está vacío", "Por favor, ingrese un tipo de orden.");   
       }else{
                    if (seleccion2.equals("Orden alfabético")){
                         seleccion = "Orden alfabético";
                         reload(event);
                   }else if(seleccion2.equals("Favoritos")){
                         seleccion = "Favoritos";
                         reload(event);
                       //mostrarListaOrdenadaPorFavoritos();
                   }else if(seleccion2.equals("Personas")){
                         seleccion = "Personas";
                         reload(event);
                     
                       //mostrarListaOrdenadaPorPersonas();
                   }else if(seleccion2.equals("Empresas")){
                      seleccion = "Empresas"; 
               }else{
                    seleccion = "Original";
               }
       
       }
       
       
        
        
        
    }
    
    
    private void reload(ActionEvent event) throws IOException{
        try {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cerrar la ventana actual
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
        Parent root = loader.load();
        ListaContactosController controllerList = loader.getController(); 
        controllerList. mostrarElementos();
        
        
         Scene scene = new Scene(root, 900, 700);
            Stage stage2 = new Stage();
            stage2.setScene(scene);
            stage2.setResizable(false);

            stage2.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    
    
    
    
    private void ordenarAlfebaticamente(ActionEvent event){
         try {
                       // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
            Parent root = loader.load();
            ListaContactosController controllerAlfab = loader.getController();
            controllerAlfab.mostrarElementoAlfabeticamente();
            // Configurar el controlador de la vista de contacto para personas

            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //mostrarListaOrdenadaEnOrdenAlfabetico();   


    }

    
    
    private void ordenarPorFavoritos(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
            Parent root = loader.load();
            ListaContactosController controllerAlfab = loader.getController();
            controllerAlfab.mostrarFavoritosPrimero();
            // Configurar el controlador de la vista de contacto para personas

            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    private void ordenarPorPersonas(ActionEvent event) {

        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
            Parent root = loader.load();
            ListaContactosController controllerAlfab = loader.getController();
            controllerAlfab.mostrarPersonasPrimero();
            // Configurar el controlador de la vista de contacto para personas

            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
     private void ordenarPorEmpresa(ActionEvent event) {

        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
            Parent root = loader.load();
            ListaContactosController controllerAlfab = loader.getController();
            controllerAlfab.mostrarEmpresasPrimero();
            // Configurar el controlador de la vista de contacto para personas

            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //mostrarListaOrdenadaPorEmpresa();
        //aquí le metes algún metodo llamado mostrarlistaoriginal() que reinicie la app con la lista original

    }
    
     
     private void ordenarOriginal(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la vista de contacto para personas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaContactos.fxml"));
            Parent root = loader.load();
            ListaContactosController controllerAlfab = loader.getController();
            controllerAlfab.mostrarElementos();
            // Configurar el controlador de la vista de contacto para personas

            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cerrar la ventana actual
            stage1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
   private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
