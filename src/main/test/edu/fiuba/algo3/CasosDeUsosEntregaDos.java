package edu.fiuba.algo3;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CasosDeUsosEntregaDos {

    /**
     * Verifico que se haya deserializado "ancho" y "largo" del mapa json
     * */
    @Test
    public void Test013SeVerificaElFormatoValidoDelJsonDelMapa() {

        // Ruta al archivo JSON
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();

        int valorEsperadoAncho = 10;
        int valorEsperadoLargo = 18;

        assertEquals(valorEsperadoAncho,deserializadorJSON.extraerValorAnchoDelMapa(rutaDelArchivo));
        assertEquals(valorEsperadoLargo,deserializadorJSON.extraerValorLargoDelMapa(rutaDelArchivo));

    }

    /**
     * Verifico que se haya deserializado "obstaculo" y "premio" de las celdas json
     *
     * Supuesto: si una celda tiene mal el contenido de la ocupacion entonces
     * no se guardará en la lista de casillas que tiene adentro la clase DeserializadorJson()
     * Recordar que ocupaciones puede ser  premio y/o obstaculos
     *
     * */
    @Test
    public void Test014SeVerificaElFormatoValidoDelJsonDeObstaculosYPremios() {

        // Ruta al archivo JSON
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerOcupacionesDeLasCeldas(rutaDelArchivo);

        int valorEsperado = 39;

        assertEquals(valorEsperado,deserializadorJSON.cantidadCeldasDeserealizadas());

    }



    @Test
    public void Test015SeVerificaLaLecturayConversionDeObstaculosDelJsonAlModelo() {//los contenidos de obstaculos vincularlos con los objetos del modelo

        /*String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            List<String> listaObstaculosJSON = new ArrayList<>();

            for (JsonNode celda : celdas) {
                String obstaculo = celda.get("obstaculo").asText().toUpperCase();
                listaObstaculosJSON.add(obstaculo);
            }

            assertTrue(conversionObstaculosJsonAlModelo(listaObstaculosJSON), "\nNo se pudo convertir a los objetos del Modelo");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }*/

    }
    @Test
    public void test016SeVerificaLaLecturayConversionDePremiosDelJsonAlModelo() {

       /* String rutaDelArchivo = "src/main/java/edu/fiuba/algo3/Modelo/Mapa/mapa.json";
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(rutaDelArchivo));
            JsonNode celdas = jsonNode.get("camino").get("celdas");
            List<String> listaPremiosJSON = new ArrayList<>();

            for (JsonNode celda : celdas) {
                String premio = celda.get("premio").asText().toUpperCase();
                listaPremiosJSON.add(premio);
            }

            assertTrue(conversionDePremiosJsonAlModelo(listaPremiosJSON), "\nNo se pudo convertir a los objetos del Modelo");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al leer el archivo JSON");
        }*/

    }


    @Test
    public void Test017VerificarQueElJuegoSeCreaAcordeALosPuntoJson() {


    }

    /*
    @Test
    public void Test018SeVerificaLaCreacionDeAmbosJson() {
    }*/

    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {

        Tablero tablero = new Tablero(1, new Turno(5));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        boolean JugadorEsGanador= true;
        assertEquals(JugadorEsGanador, tablero.validarGanador(unGladiador));

    }

    /*@Test
    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    }*/
}
