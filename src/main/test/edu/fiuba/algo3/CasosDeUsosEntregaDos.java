package edu.fiuba.algo3;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;


public class CasosDeUsosEntregaDos {

    @Test
    public void Test013SeVerificaJsonDeMapaEsValido() { //verifico la estructura del .json

        // Ruta al archivo JSON
        String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";
        try {
            // Creando un ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Leeyendo el archivo JSON y mapeando a un árbol de nodos
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));

            // Verifico la existencia y el tipo de los campos
            assertTrue(jsonNode.has("mapa"));
            assertTrue(jsonNode.get("mapa").isObject());
            assertTrue(jsonNode.get("mapa").has("ancho"));
            assertTrue(jsonNode.get("mapa").has("largo"));
            assertTrue(jsonNode.get("mapa").get("ancho").isInt());
            assertTrue(jsonNode.get("mapa").get("largo").isInt());

            // Verifico la existencia y el tipo de los campos en las celdas/Casillas del camino
            assertTrue(jsonNode.has("camino"));
            assertTrue(jsonNode.get("camino").isObject());
            assertTrue(jsonNode.get("camino").has("celdas"));
            assertTrue(jsonNode.get("camino").get("celdas").isArray());

            // Itero sobre las celdas/Casillas del camino y verifico sus campos
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            for (JsonNode celda : celdas) {
                assertTrue(celda.has("x"));//son las claves
                assertTrue(celda.has("y"));
                assertTrue(celda.has("tipo"));
                assertTrue(celda.has("obstaculo"));
                assertTrue(celda.has("premio"));
                assertTrue(celda.get("x").isInt());
                assertTrue(celda.get("y").isInt());
                assertTrue(celda.get("tipo").isTextual());
                assertTrue(celda.get("obstaculo").isTextual());
                assertTrue(celda.get("premio").isTextual());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Test014SeVerificaJsonDeObstaculosYPremiosSonValidos() {
    }

    @Test
    public void Test015SeVerificaLaLecturayConversionDeEnemigosDeJsonEsValido() {
    }

    @Test
    public void Test016SeVerificaLaLecturayConversionDeEnemigosDeJsonEsValido() {
    }

    @Test
    public void Test017SeVerificaElsistemaLog() {
    }

    @Test
    public void Test018SeVerificaLaCreacionDeAmbosJson() {
    }

    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {
    }

    @Test
    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    }
}
