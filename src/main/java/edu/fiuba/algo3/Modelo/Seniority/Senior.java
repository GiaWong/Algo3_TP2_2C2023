package edu.fiuba.algo3.Modelo.Seniority;

public class Senior extends Seniority{
    public Senior() {
        super(12);
    }
    @Override
    public int modificarEnergia(int unaEnergia) {
        return unaEnergia + 10;
    }

    @Override
    public Seniority sumarTurno() {
        this.turnoActual++;
        return this;
    }
}
