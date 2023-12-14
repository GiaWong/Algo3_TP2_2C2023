package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoReal;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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

        canvas = new Canvas(100,100);
        Tablero tablero = this.crearTablero(gladiadores);
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

        Jugadores jugadores = new Jugadores(gladiadores,gridMapa);
        jugadores.actualizar();



        Button btnAvanzar = new Button("Tirar dado");
        btnAvanzar.setOnAction(e -> {

            tablero.avanzar();
            jugadores.actualizar();

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
        Casilla[][] unMapa = mapa.obtenerMapa();

        Dado dado = new DadoReal();
        Tablero tablero = new Tablero(gladiadores.size(),new Turno(30),unMapa,mapa.obtenereCamino(),dado);


        for (Gladiador gladiador : gladiadores) {
            tablero.agregarJugador(gladiador);
        }
        return tablero;
    }



    @Override
    public void agregarObservador(Observer o){    }
    @Override
    public void eliminarObservador(Observer o){}

}
