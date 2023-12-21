package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Vista.PantallaMapa;

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
            //PantallaMapa.obtenerLabelObstaculo().setText("El jugador " +unGladiador.obtenerNombre() + " pierde el turno por estar lesionado.");
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

