package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorJugadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaDeInicio {
    public PantallaDeInicio(Stage stage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.setStyle("-fx-background-color: black;");

        Label labelJugadores = new Label("Cantidad de jugadores:");
        TextField inputJugadores = new TextField();

        labelJugadores.setTextFill(Color.web("#66A7C5"));

        grid.add(labelJugadores, 0, 0);
        grid.add(inputJugadores, 1, 0);

        ControladorJugadores controlJugadores = new ControladorJugadores(inputJugadores, stage);
        controlJugadores.controlar();

        Scene scene = new Scene(grid, 740, 580);
        stage.setScene(scene);
        stage.setMaximized(true);

        stage.show();
    }
}