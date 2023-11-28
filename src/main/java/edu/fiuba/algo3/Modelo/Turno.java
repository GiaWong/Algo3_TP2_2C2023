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

    public Gladiador siguienteTurno(ArrayList<Gladiador> gladiadores){
        Gladiador gladiadorActual = gladiadores.get(turnoActual % gladiadores.size());
        turnoActual++;
        return gladiadorActual;
    }

    public boolean validarFinalizarJuego(){
        boolean devolver = false;
        if (turnoActual >= maximaCantidadDeTurnos){
            System.out.println("Se finalizo el juego ----> cantidad de turnos para llegar a " + maximaCantidadDeTurnos +" es " + (maximaCantidadDeTurnos-turnoActual));
            devolver = true;
        }
        if (turnoActual < maximaCantidadDeTurnos){
            System.out.println("Aun NO se finalizo el juego ----> cantidad de turnos para llegar a " + maximaCantidadDeTurnos +" es " + (maximaCantidadDeTurnos-turnoActual));
            devolver = false;
        }
        return devolver;
    }
}

