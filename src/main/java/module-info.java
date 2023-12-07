module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.Controlador.ManejarJson;
    exports edu.fiuba.algo3.Modelo;
    exports edu.fiuba.algo3.Modelo.Dados;
}