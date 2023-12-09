package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Modelo.Gladiador;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class Jugadores implements Observer{


    private ArrayList<Gladiador> gladiadores;
    private GridPane gridMapa;
    private Pane circulos;




    public Jugadores(ArrayList<Gladiador> gladiadores, GridPane gridMapa){
        this.gladiadores = gladiadores;
        this.gridMapa = gridMapa;
        this.circulos = new Pane();
    }

    @Override
    public void actualizar(){

        this.clear(gridMapa);
        int contador = 0;

        for (Gladiador g : gladiadores){
            Label label = (Label) obtenerLabelDeGridPane(gridMapa,g.obtenerPosicionEnX(),g.obtenerPosicionEnY());
            Circle circulo = new Circle(5, Color.RED);


            circulos.getChildren().add(circulo);

            if (contador == 0) {
                circulo.setCenterX(12);
                circulo.setCenterY(10);
            } else if (contador == 1) {
                circulo.setCenterX(27);
                circulo.setCenterY(10);
            }
/*
            if (contador == 0){
                label.setGraphic(circulo);}
            else{
                label.setGraphic(circulos);}
*/
            label.setGraphic(circulo);
            contador++;

        }

/*

        Circle circle1 = new Circle(5, Color.RED);
        Circle circle2 = new Circle(5, Color.BLUE);
        Circle circle3 = new Circle(5, Color.ORANGE);
        Circle circle4 = new Circle(5, Color.GREEN);
        Circle circle5 = new Circle(5, Color.CHOCOLATE);
        Circle circle6 = new Circle(5, Color.INDIGO);


        Pane circulos = new Pane(circle1, circle2, circle3, circle4, circle5, circle6);


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

        label1.setGraphic(circulos);
        */
    }

    private Node obtenerLabelDeGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == (col-1) && GridPane.getRowIndex(node) == (row-1)) {
                return node;
            }
        }
        return null;
    }

    private void clear(GridPane gridMapa){
        for (int i = 0; i < gridMapa.getChildren().size(); i++) {
            if (gridMapa.getChildren().get(i) instanceof Label) {
                Label label = (Label) gridMapa.getChildren().get(i);
                label.setGraphic(null);
            }
        }
    }


}
