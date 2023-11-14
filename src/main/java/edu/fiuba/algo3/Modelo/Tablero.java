package edu.fiuba.algo3.Modelo;

public class Tablero {
    public Tablero(int i, Casilla casilla) {
    }

    public void agregarJugador(Gladiador gladiador) {
    }

    public Gladiador obtenerGladiador() {
        return (new Gladiador(20, new Novato(),0));
    }

    public void avanzar(Dado dado, Gladiador gladiador) {
        int moverUnasCasillas = dado.tirar();
        gladiador.avanzar(moverUnasCasillas);




    }
}
