package edu.fiuba.algo3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        stage.setTitle("Gladiadores en fuga");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label labelJugadores = new Label("Cantidad de jugadores:");
        TextField inputJugadores = new TextField();
        Button btnAceptarJugadores = new Button("Aceptar");

        grid.add(labelJugadores, 0, 0);
        grid.add(inputJugadores, 1, 0);
        grid.add(btnAceptarJugadores, 2, 0);

        btnAceptarJugadores.setOnAction(e -> {
            int cantidadJugadores = Integer.parseInt(inputJugadores.getText());
            pedirNombresJugadores(cantidadJugadores);
        });

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);

        stage.show();
    }

    private void pedirNombresJugadores(int cantidadJugadores) {
        Stage stageNombres = new Stage();
        stageNombres.setTitle("Gladiadores en fuga");

        GridPane gridNombres = new GridPane();
        gridNombres.setPadding(new Insets(20, 20, 20, 20));
        gridNombres.setVgap(10);
        gridNombres.setHgap(10);

        for (int i = 0; i < cantidadJugadores; i++) {
            Label labelNombre = new Label("Nombre Jugador " + (i + 1) + ":");
            TextField inputNombre = new TextField();
            gridNombres.add(labelNombre, 0, i);
            gridNombres.add(inputNombre, 1, i);
        }

        Button btnAceptarNombres = new Button("Aceptar");
        btnAceptarNombres.setOnAction(e -> {
            stageNombres.close();
            mostrarMapa();
        });

        gridNombres.add(btnAceptarNombres, 1, cantidadJugadores);

        Scene sceneNombres = new Scene(gridNombres, 400, 200);
        stageNombres.setScene(sceneNombres);

        stageNombres.show();
    }

    private void mostrarMapa() {
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
            //stageMapa.close(); CUANDO UN JUGADOR GANE SE CIERRA
        });
        gridMapa.add(btnAvanzar, 0, ancho + 1, largo, 1);


        double ventanaAncho = largo * tamanoCasilla + 15;
        double ventanaAlto = ancho * tamanoCasilla + 15;

        Scene sceneMapa = new Scene(gridMapa, ventanaAncho, ventanaAlto);

        stageMapa.setScene(sceneMapa);
        stageMapa.show();

        stage.close();
    }
}

