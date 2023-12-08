package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.util.ArrayList;



public class PantallaMapa extends BorderPane implements Observable {

    private  Stage stage;
    private ArrayList<Gladiador> gladiadores;
    Canvas canvas;



    public PantallaMapa(Stage stage, ArrayList<Gladiador> gladiadores) {
        this.stage = stage;
        this.gladiadores = gladiadores;
    }

    public void mostrarMapa() {

            Tablero tablero = this.crearTablero(gladiadores);
            canvas = new Canvas(100,100);

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
                    Label label = new Label(/*"(" + j + "," + i + ")"*/);
                    label.setMinSize(tamanoCasilla, tamanoCasilla);
                    label.setStyle("-fx-border-color: black;");
                    gridMapa.add(label, j - 1, ancho - i);

                }
            }

            Button btnAvanzar = new Button("Tirar dado");
            btnAvanzar.setOnAction(e -> {


              tablero.avanzar();

              Gladiador gladiador = tablero.proximoJugador();
              Label label = (Label) obtenerLabelDeGridPane(gridMapa, gladiador.obtenerPosicionEnX(), gladiador.obtenerPosicionEnY());
              Circle circle1 = new Circle(5, Color.RED);
              Circle circle2 = new Circle(5, Color.BLUE);
              Circle circle3 = new Circle(5, Color.ORANGE);
              Circle circle4 = new Circle(5, Color.GREEN);
              Circle circle5 = new Circle(5, Color.CHOCOLATE);
              Circle circle6 = new Circle(5, Color.INDIGO);

              Pane circulos = new Pane(circle1, circle2, circle3, circle4, circle5, circle6);

              double centerX = (label.getMinWidth() - circulos.getBoundsInLocal().getWidth()) / 2;
              double centerY = (label.getMinHeight() - circulos.getBoundsInLocal().getHeight()) / 2;

              circulos.setLayoutX(centerX);
              circulos.setLayoutY(centerY);

              circle1.setCenterX(12);
              circle1.setCenterY(10);

              circle2.setCenterX(27);
              circle2.setCenterY(10);

              circle3.setCenterX(12);
              circle3.setCenterY(20);

              circle4.setCenterX(27);
              circle4.setCenterY(20);

              circle5.setCenterX(12);
              circle5.setCenterY(30);

              circle6.setCenterX(27);
              circle6.setCenterY(30);

              label.setGraphic(circulos);

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

    public Tablero crearTablero(ArrayList<Gladiador> gladiadores){
        Mapa mapa = new Mapa();
        mapa.mapaReal();
        DadoMock dado = new DadoMock();

        Casilla[][] unMapa = mapa.obtenerMapa();
        Tablero tablero = new Tablero(gladiadores.size(),new Turno(30),unMapa, dado);

        for (Gladiador gladiador : gladiadores) {
            tablero.agregarJugador(gladiador);
        }
        return tablero;
    }

    private Node obtenerLabelDeGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    @Override
    public void attach(Observer o){}
    @Override
    public void detach(Observer o){}
    @Override
    public void notificar(){}

}
