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
        
        for(Contacto contacto : Agenda.contactosMaster){
<<<<<<< HEAD
            System.out.println(contacto.getId());  
=======
            System.out.println(
                    contacto.getId()+" "+
                    contacto.getNombre());  
>>>>>>> e5393fa71360e85f3e1c18b7503c70c736428298
        }
        launch();
        
        

 
    }
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
        System.out.println();
    }
    @Override
    public void stop() throws Exception{
        
        Serializador.serializarTodosLosContactos(
                Agenda.contactosMaster,
                Agenda.contactosEmpresas,
                Agenda.contactosPersonas);
        System.out.println("master: "+Agenda.contactosMaster.size());
        System.out.println("persona: "+Agenda.contactosPersonas.size());
        System.out.println("empresa: "+Agenda.contactosEmpresas.size());
        
    }
}