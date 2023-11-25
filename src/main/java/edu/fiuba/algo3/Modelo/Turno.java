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
        Gladiador gladiadorActual = gladiadores.get(turnoActual % gladiadores.size());
        turnoActual++;
        return gladiadorActual;
    }

}

