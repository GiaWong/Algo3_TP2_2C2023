package edu.fiuba.algo3.Modelo.Seniority;

public abstract class Seniority {

    protected int turnoActual;

    public Seniority(int turno) {
        this.turnoActual = turno;
    }
    public abstract int  modificarEnergia(int unaEnergia);

    public Seniority sumarTurno(){
        return this;
    }
}
