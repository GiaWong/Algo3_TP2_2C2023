package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;

public interface  Ocupacion {
    Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador);


}
