package edu.fiuba.algo3.Modelo;

public class Casilla {
    Ocupacion unaOcupacion;
    int energiaModificada;
    public Casilla(Ocupacion ocupacion) {
        
        this.unaOcupacion = ocupacion;
        this.energiaModificada = 0;
    }

    
    public int modificarEnergia(int unaEnergia){
        energiaModificada = unaOcupacion.modificarEnergia(unaEnergia);
        
        return energiaModificada;
    }
}
