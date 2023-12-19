package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Vista.PantallaMapa;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorJugadores {
    private TextField entradaActual;
    private int cantidadJugadoresIngresados;
    private Stage stage;

    public ControladorJugadores(TextField inputJugadores, Stage stage) {
        this.entradaActual = inputJugadores;
        this.stage = stage;
        this.cantidadJugadoresIngresados=0;
    }

    public void controlar() {
        entradaActual.setOnAction(event -> {
            try {
                cantidadJugadoresIngresados = Integer.parseInt(entradaActual.getText());
                if (cantidadJugadoresIngresados >= 2 && cantidadJugadoresIngresados <= 6) {
                    System.out.println("Cantidad jugadores: " + cantidadJugadoresIngresados);
                    stage.close();
                    pedirNombresJugadores();
                } else {
                    mostrarAlertaCantidadJugadores("Número no válido", "Ingrese un número entre 2 y 6.");
                    entradaActual.clear();
                }
            } catch (NumberFormatException e) {
                mostrarAlertaCantidadJugadores("Error", "Ingrese un número válido.");
                entradaActual.clear();
            }
        });
    }
    private void mostrarAlertaCantidadJugadores(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void pedirNombresJugadores() {
        
        Stage stageNombres = new Stage();
        stageNombres.setTitle("Gladiadores en fuga");

        GridPane gridNombres = new GridPane();
        gridNombres.setPadding(new Insets(20, 20, 20, 20));
        gridNombres.setVgap(10);
        gridNombres.setHgap(10);
        gridNombres.setAlignment(Pos.CENTER);

        for (int i = 0; i < cantidadJugadoresIngresados; i++) {

            Label labelNombre = new Label("Nombre Jugador " + (i + 1) + ":");
            TextField nombreIngresado = new TextField();
            gridNombres.add(labelNombre, 0, i);
            gridNombres.add(nombreIngresado, 1, i);
            
        }

        Button btnAceptarNombres = new Button("Aceptar");
        btnAceptarNombres.setOnAction(e -> {

            ArrayList<String> nombresJugadores = new ArrayList<>();

            for (int i = 0; i < cantidadJugadoresIngresados; i++) {
                TextField nombreIngresado = (TextField) gridNombres.getChildren().get(i * 2 + 1);
                nombresJugadores.add(nombreIngresado.getText());
            }

            ArrayList<Gladiador> gladiadores = crearJugadores(nombresJugadores);

            stageNombres.close();

            PantallaMapa mapa = new PantallaMapa(stage,gladiadores);
            mapa.mostrarMapa();
        });

        gridNombres.add(btnAceptarNombres, 1, cantidadJugadoresIngresados);

        Scene sceneNombres = new Scene(gridNombres, 740, 580);
        stageNombres.setScene(sceneNombres);

        stageNombres.show();
    }

    private ArrayList<Gladiador> crearJugadores(ArrayList<String> nombresJugadores) {
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Posicion posicion = new Posicion(1, 7);
        for (String nombre : nombresJugadores) {
            Gladiador gladiador = new Gladiador(20, new Novato(), posicion);
            gladiadores.add(gladiador);
        }

        return gladiadores;
    }


}
