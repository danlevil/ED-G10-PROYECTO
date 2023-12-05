package g10;

import Modelo.Agenda;
import Modelo.CargadorDeArchivos;
import Modelo.Contacto;
import Modelo.ContactoEmpresa;
import Modelo.ContactoPersona;
import Modelo.Serializador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static final long serialVersionUID=1L;
   
    public static String pathClientes = "";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ListaContactos"), 900,700 );
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
    }
                        
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Agenda.inicializador();
        CargadorDeArchivos.cargarListasDesdeArchivos();
        
        launch();
        
        

 
    }
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
        System.out.println();
    }
    @Override
    public void stop() throws Exception{
        //Agenda.contactosPersonas.clear();
        //genda.contactosMaster.clear();
        Serializador.serializarTodosLosContactos(
                Agenda.contactosMaster,
                Agenda.contactosEmpresas,
                Agenda.contactosPersonas);
        
        if(Agenda.contactosMaster.size()==0){
            String rutaMaster= "src/main/resources/Contactos/listaGeneral.ser";
            String rutaPersonas= "src/main/resources/Contactos/listaContactosComunes.ser";
            String rutaEmpresas= "src/main/resources/Contactos/listaContactosEmpresas.ser";
            Path pathArchivo1= Paths.get(rutaMaster);
            Path pathArchivo2= Paths.get(rutaPersonas);
            Path pathArchivo3= Paths.get(rutaEmpresas);
            
            if(Files.exists(pathArchivo1)){
                try {
                // Intentar eliminar el archivo
                Files.delete(pathArchivo1);
                System.out.println("Archivo eliminado con éxito.");
                }catch (IOException e) {
                System.out.println("No se pudo eliminar el archivo. Error: " + e.getMessage());
                }
            }
            if(Files.exists(pathArchivo2)){
                try {
                // Intentar eliminar el archivo
                Files.delete(pathArchivo2);
                System.out.println("Archivo eliminado con éxito.");
                }catch (IOException e) {
                System.out.println("No se pudo eliminar el archivo. Error: " + e.getMessage());
                }
            }
            if(Files.exists(pathArchivo3)){
                try {
                // Intentar eliminar el archivo
                Files.delete(pathArchivo3);
                System.out.println("Archivo eliminado con éxito.");
                }catch (IOException e) {
                System.out.println("No se pudo eliminar el archivo. Error: " + e.getMessage());
                }
            }
        }
        System.out.println("Lista de empresas: "+Agenda.contactosEmpresas.size());
        
        System.out.println("Lista de personas: "+Agenda.contactosPersonas.size());
        System.out.println("Lista general: "+Agenda.contactosMaster.size());
        
    }
}