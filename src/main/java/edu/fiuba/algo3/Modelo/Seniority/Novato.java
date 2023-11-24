package edu.fiuba.algo3.Modelo.Seniority;

public class Novato extends Seniority {

    public Novato() {
        super(0);
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return unaEnergia;
    }

    public Seniority sumarTurno() {
        this.turnoActual++;
        if (turnoActual == 8) {
            return new Semisenior();
        }
        return this;
    }
}
