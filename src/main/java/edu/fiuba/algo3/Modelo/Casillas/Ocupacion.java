package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;

public interface  Ocupacion {

    //Por ahora premio y equipamiento estan alpedo
    Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador);


}
