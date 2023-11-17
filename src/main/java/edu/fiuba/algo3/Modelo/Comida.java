package edu.fiuba.algo3.Modelo;

import java.io.ObjectStreamConstants;

public class Comida implements Ocupacion  {

    private int energia;
    public Comida(int energiaPropia){this.energia = energiaPropia;}
    @Override
    public int modificarEnergia(int unaEnergia){return (unaEnergia + energia);}
}
