package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Seniority.Semisenior;

public class Turno {
    private int turno;

    public  Turno(int maximaCantidad){
        this.turno = maximaCantidad;
    }
    
    public boolean jugar(Gladiador unGladiador) {
        if (unGladiador.obtenerEnergia() <= 0){
            return false;
        }

        turno--;
        if (turno == 22) {
            unGladiador.cambiarSeniority(new Semisenior());
        }

        return true;
    }

    public int obtenerTurno(){
        return turno;
    }

}

