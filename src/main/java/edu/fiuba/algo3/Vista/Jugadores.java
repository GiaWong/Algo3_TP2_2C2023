package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Modelo.Gladiador;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

import java.util.List;


public class Jugadores implements Observer{
    private ArrayList<Gladiador> gladiadores;
    private GridPane gridMapa;


    public Jugadores(ArrayList<Gladiador> gladiadores, GridPane gridMapa){
        this.gladiadores = gladiadores;
        this.gridMapa = gridMapa;
    }

    @Override
    public void actualizar(){

        this.clear(gridMapa);
        int contador = 1;

        for (Gladiador g : gladiadores){

            if (contador == 1) {
                Circle circle = new Circle(5, Color.RED);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(7);
                circle.setTranslateY(-11);
                gridMapa.getChildren().add(circle);
            }
            else if(contador == 2) {
                Circle circle = new Circle(5, Color.BLUE);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(22);
                circle.setTranslateY(-11);
                gridMapa.getChildren().add(circle);
            }
            else if(contador == 3) {
                Circle circle = new Circle(5, Color.GREEN);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(7);
                circle.setTranslateY(0);
                gridMapa.getChildren().add(circle);
            }
            else if(contador == 4) {
                Circle circle = new Circle(5, Color.BLACK);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(22);
                circle.setTranslateY(0);
                gridMapa.getChildren().add(circle);
            }
            else if(contador == 5) {
                Circle circle = new Circle(5, Color.ORANGE);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(7);
                circle.setTranslateY(11);
                gridMapa.getChildren().add(circle);
            }
            else if(contador == 6) {
                Circle circle = new Circle(5, Color.VIOLET);
                GridPane.setRowIndex(circle, g.obtenerPosicionEnY() - 1);
                GridPane.setColumnIndex(circle, g.obtenerPosicionEnX() - 1);
                circle.setTranslateX(22);
                circle.setTranslateY(11);
                gridMapa.getChildren().add(circle);
            }
            contador++;

        }

    }

    private void clear(GridPane gridMapa) {
        List<Node> nodosAEliminar = new ArrayList<>();

        for (Node nodo : gridMapa.getChildren()) {
            if (nodo instanceof Circle) {
                nodosAEliminar.add(nodo);
            }
        }
        gridMapa.getChildren().removeAll(nodosAEliminar);
        // Establecer el fondo negro
        gridMapa.setStyle("-fx-background-color: black;");
    }




}
