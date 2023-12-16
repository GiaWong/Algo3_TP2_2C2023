package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Turno {
    private int turnoActual;
    private int maximaCantidadDeTurnos;

    public  Turno(int maximaCantidad){
        this.maximaCantidadDeTurnos = maximaCantidad;
        this.turnoActual = 0;
    }

    public boolean jugar(Gladiador unGladiador) {
        if (unGladiador.obtenerEnergia() <= 0 || unGladiador.estaLesionado() ) {
            unGladiador.rehabilitar();
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
        return  turnoActual >= maximaCantidadDeTurnos ;
    }

    public static void perderSiguienteTurno(Gladiador unGladiador){
        unGladiador.lesionar();
        System.out.println("\n Gladiador se lesionó, pierde un turno ... ");
    }
}

