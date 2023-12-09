package edu.fiuba.algo3.Modelo.Seniority;

public class Semisenior extends Seniority {
    public Semisenior() {
        super(8);
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return unaEnergia + 5;
    }

    @Override
    public Seniority sumarTurno() {
        this.turnoActual++;
        if (turnoActual ==12) {
            return new Senior();
        }
        return this;
    }
}
