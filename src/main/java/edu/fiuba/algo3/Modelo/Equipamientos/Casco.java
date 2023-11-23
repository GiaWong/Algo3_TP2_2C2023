package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class Casco implements Ocupacion,Equipamiento {
    private int energia;
    public Casco(int energia) {
        this.energia = energia;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia + energia);
    }


    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }
    @Override
    public String obtenerNombre() {
        return "Casco";
    }

}
