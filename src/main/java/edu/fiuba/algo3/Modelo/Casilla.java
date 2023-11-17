package edu.fiuba.algo3.Modelo;

public class Casilla {
    Ocupacion unaOcupacion;
    Meta unaMeta;
    LLave unaLLave;
    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;
    }

    public Casilla(Meta meta) {
        this.unaMeta = meta;
    }
    public Casilla(LLave llave) {
        this.unaLLave = llave;
    }

    public int modificarEnergia(int unaEnergia){
        return (unaOcupacion.modificarEnergia(unaEnergia) );
    }
    public Ocupacion getEquipamiento() {return unaOcupacion;}

    public boolean seLLegoALaMeta() {
       return (unaMeta != null);
    }

}

