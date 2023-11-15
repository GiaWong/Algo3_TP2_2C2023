package edu.fiuba.algo3.Modelo;

import java.io.ObjectStreamConstants;

public class Comida implements Ocupacion  {

    private int puntos;
    public Comida(int unosPuntos){

        this.puntos = unosPuntos;
    }
    @Override
    public int modificarEnergia(int unaEnergia){
        int energiaModificada = unaEnergia + 15;

        return energiaModificada;
    }
}
