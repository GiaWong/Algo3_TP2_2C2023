package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Seniority.Semisenior;
import java.util.ArrayList;

public class Turno {
    private int turnoActual;
    private int maximaCantidadDeTurnos;

    public  Turno(int maximaCantidad){

        this.maximaCantidadDeTurnos = maximaCantidad;
        this.turnoActual = 0;
    }

    public boolean jugar(Gladiador unGladiador) {
        if (unGladiador.obtenerEnergia() <= 0){
            return false;
        }

        return true;
    }

    public int obtenerTurno(){
        return turnoActual;
    }

    public Gladiador siguienteTurno(ArrayList<Gladiador> gladiadores){
        //Por ahora lodejo asi, la idea mas adelante seria que puedan inicializarse varios gladiadores
        //no pongoun for o un if en el tablero por que ya tiene demasiados
       turnoActual++;
       return  gladiadores.get(0);
    }

    public boolean validarFinalizarJuego(){
        boolean devolver = false; // inicizalizamos el valor de un boleano
        if (turnoActual >= 30){
            System.out.println("Se finalizo el juego ----> cantidad de turnos para llegar a 30 es " + (30-turnoActual));
            devolver = true;
        }
        if (turnoActual < 30){
            System.out.println("Aun NO se finalizo el juego ----> cantidad de turnos para llegar a 30 es " + (30-turnoActual));
            devolver = false;
        }
        return devolver;
    }
}

