package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;

public abstract class Ocupacion {
    public abstract Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador);
}
