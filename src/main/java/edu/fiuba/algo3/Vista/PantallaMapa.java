package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PantallaMapa {
    private  Stage stage;
    public PantallaMapa(Stage stage) {
        this.stage = stage;
    }

    public void mostrarMapa() {

            Stage stageMapa = new Stage();
            stageMapa.setTitle("Gladiadores en fuga");

            GridPane gridMapa = new GridPane();
            gridMapa.setPadding(new Insets(10));
            gridMapa.setHgap(5);
            gridMapa.setVgap(5);

            int ancho = 10;
            int largo = 18;

            double tamanoCasilla = 40.0;

            for (int i = ancho; i >= 1; i--) {
                for (int j = 1; j <= largo; j++) {
                    Label label = new Label("(" + i + "," + j + ")");
                    label.setMinSize(tamanoCasilla, tamanoCasilla);
                    label.setStyle("-fx-border-color: black;");
                    gridMapa.add(label, j - 1, ancho - i);
                }
            }


            Button btnAvanzar = new Button("Avanzar");
            btnAvanzar.setOnAction(e -> {

            });
            gridMapa.add(btnAvanzar, 0, ancho + 1, largo, 1);
            gridMapa.setAlignment(Pos.CENTER);

            double ventanaAncho = largo * tamanoCasilla + 15;
            double ventanaAlto = ancho * tamanoCasilla + 15;

            Scene sceneMapa = new Scene(gridMapa, ventanaAncho, ventanaAlto);

            stageMapa.setScene(sceneMapa);
            stageMapa.setMaximized(true);
            stageMapa.show();

            stage.close();

    }
}
