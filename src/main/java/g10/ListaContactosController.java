/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g10;

import Comparadores.ComparadorEmpresa;
import Comparadores.ComparadorFavoritos;
import Comparadores.ComparadorNombreContacto;
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
        VboxContactos.getChildren().clear();
        int inicio = (paginaActual - 1) * ELEMENTOS_POR_PAGINA;
        ComparadorNombreContacto cmp1= new ComparadorNombreContacto();
        ComparadorEmpresa cmp2= new ComparadorEmpresa();
        ComparadorFavoritos cmp3= new ComparadorFavoritos();
        //ORDENAMIENTO
        List<Contacto> alfabetica= Agenda.contactosMaster.ordenar(cmp1);
        List<Contacto> empresasFirst=Agenda.contactosMaster.ordenar(cmp2);
        List<Contacto> favFirst=Agenda.contactosMaster.ordenar(cmp3);
        
        //FILTRADO
        FiltradorEmpresas f1= new FiltradorEmpresas();
        FiltradorFavoritos f2= new FiltradorFavoritos();
        FiltradorNombre f3= new FiltradorNombre();
        List<Contacto> soloEmpresas= f1.filtrarSoloEmpresas(Agenda.contactosMaster);
        List<Contacto> solofavs= f2.filtrarSoloFavoritos(Agenda.contactosMaster);
        List<Contacto> nombreEspecifico= f3.filtrarTexto(Agenda.contactosMaster, "sss");
        int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, Agenda.contactosMaster.size());
        //int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, nombreEspecifico.size());
        //int fin = Math.min(inicio + ELEMENTOS_POR_PAGINA, soloEmpresas.size());
        for (int i = inicio; i < fin; i++) {
            agregarHBox(Agenda.contactosMaster.get(i));
            //agregarHBox(alfabetica.get(i));
            //agregarHBox(empresasFirst.get(i));
            //agregarHBox(favFirst.get(i));
            //agregarHBox(soloEmpresas.get(i));
            //agregarHBox(solofavs.get(i));
            //agregarHBox(nombreEspecifico.get(i));
            
            
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
    private void ordenarPor(ActionEvent event) {
        String seleccion = cbOrden.getSelectionModel().getSelectedItem();
       if (seleccion.equals("Orden alfabético")){
           //mostrarListaOrdenadaEnOrdenAlfabetico();
       }else if(seleccion.equals("Favoritos")){
           //mostrarListaOrdenadaPorFavoritos();
       }else if(seleccion.equals("Personas")){
           //mostrarListaOrdenadaPorPersonas();
       }else if(seleccion.equals("Empresas")){
           //mostrarListaOrdenadaPorEmpresa();
           
       }else{
           //aquí le metes algún metodo llamado mostrarlistaoriginal() que reinicie la app con la lista original
       }
        
        
        
    }



}
