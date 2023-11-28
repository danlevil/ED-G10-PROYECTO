
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javafx.scene.control.Alert;

/**
 *
 * @author FreddyT
 */
public class Alerta {
    public static void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operación");
        alert.setHeaderText("Notificación");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
