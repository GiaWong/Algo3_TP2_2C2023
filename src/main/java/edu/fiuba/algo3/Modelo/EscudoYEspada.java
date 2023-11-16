package edu.fiuba.algo3.Modelo;

public class EscudoYEspada implements Ocupacion{
    private int energia;
    public EscudoYEspada(int energia) {
        this.energia=energia;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return unaEnergia - energia ;
    }
}
