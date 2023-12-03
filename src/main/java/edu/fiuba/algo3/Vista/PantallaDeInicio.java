package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PantallaDeInicio {
    public PantallaDeInicio(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label labelJugadores = new Label("Cantidad de jugadores:");
        TextField inputJugadores = new TextField();
        Button btnAceptarJugadores = new Button("Aceptar");

        grid.add(labelJugadores, 0, 0);
        grid.add(inputJugadores, 1, 0);
        grid.add(btnAceptarJugadores, 2, 0);


        btnAceptarJugadores.setOnAction(e -> {
            int cantidadJugadores = Integer.parseInt(inputJugadores.getText());
            stage.close();
            pedirNombresJugadores(cantidadJugadores, stage);
        });

        Scene scene = new Scene(grid, 740, 580);
        stage.setScene(scene);

        stage.show();
    }
    private void pedirNombresJugadores(int cantidadJugadores, Stage stage) {
        Stage stageNombres = new Stage();
        stageNombres.setTitle("Gladiadores en fuga");

        GridPane gridNombres = new GridPane();
        gridNombres.setPadding(new Insets(20, 20, 20, 20));
        gridNombres.setVgap(10);
        gridNombres.setHgap(10);
        gridNombres.setAlignment(Pos.CENTER);

        for (int i = 0; i < cantidadJugadores; i++) {
            Label labelNombre = new Label("Nombre Jugador " + (i + 1) + ":");
            TextField inputNombre = new TextField();
            gridNombres.add(labelNombre, 0, i);
            gridNombres.add(inputNombre, 1, i);
        }

        Button btnAceptarNombres = new Button("Aceptar");
        btnAceptarNombres.setOnAction(e -> {
            stageNombres.close();
            PantallaMapa mapa = new PantallaMapa(stage);
            mapa.mostrarMapa();
        });

        gridNombres.add(btnAceptarNombres, 1, cantidadJugadores);

        Scene sceneNombres = new Scene(gridNombres, 740, 580);
        stageNombres.setScene(sceneNombres);

        stageNombres.show();
    }

}
