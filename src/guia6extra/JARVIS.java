
package guia6extra;

import java.util.List;
import java.util.Random;

public class JARVIS {
    private Armadura armadura;
    private Radar radar;
    
    
    public JARVIS(Armadura armadura) {
        this.armadura = armadura;
        
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

   

    public void mostrarEstado() {
        System.out.println("Estado de la Armadura:");
        System.out.println("Color Primario: " + armadura.getColorPrimario());
        System.out.println("Color Secundario: " + armadura.getColorSecundario());
        System.out.println("Resistencia: " + armadura.getResistencia());
        System.out.println("Salud: " + armadura.getSalud());

        // Mostrar estado del generador
        Generador generador = armadura.getGenerador();
        System.out.println("Generador: Nivel de Energía: " + generador.getNivelEnergia());

        // Mostrar estado de la consola
        Consola consola = armadura.getConsola();
        System.out.println("Consola: Estado: " + consola.getEstado());

        // Mostrar estado del sintetizador
        Sintetizador sintetizador = armadura.getSintetizador();
        System.out.println("Sintetizador: Estado: " + sintetizador.getEstado());

        // Mostrar estado de los propulsores
        System.out.println("Propulsores: ");
        Propulsor[] propulsores = armadura.getPropulsores();
        for (int i = 0; i < propulsores.length; i++) {
            System.out.println("Propulsor " + (i + 1) + ": Estado: " + propulsores[i].getEstado());
        }

        // Mostrar estado de los repulsores
        System.out.println("Repulsores: ");
        Repulsor[] repulsores = armadura.getRepulsores();
        for (int i = 0; i < repulsores.length; i++) {
            System.out.println("Repulsor " + (i + 1) + ": Estado: " + repulsores[i].getEstado());
        }
    }
    
   public void informarEstadoBateria() {
        armadura.mostrarEstadoBateria();
    }
   
   public void mostrarInformacionReactor() {
        float estadoReactorCelsius = armadura.getGenerador().getEstadoReactor();
        float estadoReactorKelvin = celsiusAKelvin(estadoReactorCelsius);
        float estadoReactorRankine = celsiusARankine(estadoReactorCelsius);

        System.out.println("Estado del Reactor:");
        System.out.println("Celsius: " + estadoReactorCelsius);
        System.out.println("Kelvin: " + estadoReactorKelvin);
        System.out.println("Rankine: " + estadoReactorRankine);
    }

    // Método para convertir grados Celsius a Kelvin
    private float celsiusAKelvin(float celsius) {
        return celsius + 273.15f;
    }

    // Método para convertir grados Celsius a Rankine
    private float celsiusARankine(float celsius) {
        return (celsius + 273.15f) * 9 / 5;
    }
    
     // Método para revisar y arreglar los dispositivos de la armadura
    public void revisarDispositivos() {
        for (Propulsor propulsor : armadura.getPropulsores()) {
            do {
                if (propulsor.isDanado()) {
                    if (intentarReparar(propulsor)) {
                        break;
                    }
                }
            } while (propulsor.isDanado());
        }

        for (Repulsor repulsor : armadura.getRepulsores()) {
            do {
                if (repulsor.isDanado()) {
                    if (intentarReparar(repulsor)) {
                        break;
                    }
                }
            } while (repulsor.isDanado());
        }

        if (armadura.getConsola().isDanado()) {
            do {
                if (intentarReparar(armadura.getConsola())) {
                    break;
                }
            } while (armadura.getConsola().isDanado());
        }

        if (armadura.getSintetizador().isDanado()) {
            do {
                if (intentarReparar(armadura.getSintetizador())) {
                    break;
                }
            } while (armadura.getSintetizador().isDanado());
        }
    }

    // Método para intentar reparar un dispositivo
    private boolean intentarReparar(Dispositivo dispositivo) {
        Random random = new Random();
        if (random.nextDouble() <= 0.3) {
            dispositivo.reparar();
            return true;
        }
        return false;
    }
    
     // Método para informar a qué distancia se encuentra cada enemigo
    public void informarDistanciaEnemigos() {
        List<ObjetoDetectado> objetosDetectados = armadura.getRadar().getObjetosDetectados();
        for (ObjetoDetectado objeto : objetosDetectados) {
            double distancia = calcularDistancia(objeto.getCoordenadaX(), objeto.getCoordenadaY(), objeto.getCoordenadaZ());
            System.out.println("Enemigo detectado: Coordenadas (" + objeto.getCoordenadaX() + ", " + objeto.getCoordenadaY() +
                    ", " + objeto.getCoordenadaZ() + "), Distancia: " + distancia + " unidades.");
        }
    }

    // Método para calcular la distancia desde el punto (0,0,0) hasta un objeto detectado
    private double calcularDistancia(double coordenadaX, double coordenadaY, double coordenadaZ) {
        return Math.sqrt(coordenadaX * coordenadaX + coordenadaY * coordenadaY + coordenadaZ * coordenadaZ);
    }
    
     public void simularObjetosEnRadar(Radar radar) {
        Random random = new Random();
        int numeroObjetos = random.nextInt(20) + 1; // Simularemos entre 1 y 20 objetos

        for (int i = 0; i < numeroObjetos; i++) {
            double coordenadaX = random.nextDouble() * 100;
            double coordenadaY = random.nextDouble() * 100;
            double coordenadaZ = random.nextDouble() * 100;
            boolean hostil = random.nextBoolean();
            int resistencia = random.nextInt(100);

            ObjetoDetectado objeto = new ObjetoDetectado(coordenadaX, coordenadaY, coordenadaZ, hostil, resistencia);
            radar.agregarObjetoDetectado(objeto);
        }
     }
     
      public void destruirEnemigos() {
        List<ObjetoDetectado> objetosDetectados = armadura.getRadar().getObjetosDetectados();
        for (ObjetoDetectado objeto : objetosDetectados) {
            if (objeto.isHostil() && calcularDistancia(objeto) <= 5000) {
                // Verificar que los guantes estén sanos y el nivel de batería sea suficiente
                if (armadura.getRepulsores()[0].isSano() && armadura.getRepulsores()[1].isSano()
                    && armadura.getGenerador().getNivelBateria() >= calcularConsumoDisparo()) {
                    
                    int resistenciaObjeto = objeto.getResistencia();
                    int danioPorDisparo = calcularDanioPorDisparo(objeto);

                    while (resistenciaObjeto > 0) {
                        // Disparar al objeto y restar resistencia
                        resistenciaObjeto -= danioPorDisparo;

                        // Descontar consumo de batería por el disparo
                        armadura.getGenerador().consumirEnergia(calcularConsumoDisparo());

                        // Mostrar mensaje de disparo y resistencia restante
                        System.out.println("Disparando al enemigo... Resistencia restante: " + resistenciaObjeto);

                        // Verificar si el objeto ha sido destruido
                        if (resistenciaObjeto <= 0) {
                            System.out.println("Enemigo destruido.");
                            break;
                        }
                    }
                } else {
                    System.out.println("No es posible disparar, guantes dañados o nivel de batería insuficiente.");
                }
            }
        }
    }

    // Métodos auxiliares para calcular la distancia, consumo de disparo y daño por disparo...
      
       private double calcularDistancia(ObjetoDetectado objeto) {
        double coordenadaX = objeto.getCoordenadaX();
        double coordenadaY = objeto.getCoordenadaY();
        double coordenadaZ = objeto.getCoordenadaZ();

        double distancia = Math.sqrt(coordenadaX * coordenadaX + coordenadaY * coordenadaY + coordenadaZ * coordenadaZ);
        return distancia;
    }

    // Método auxiliar para calcular el consumo de energía necesario para realizar un disparo
    private int calcularConsumoDisparo() {
        // Supongamos que cada disparo consume 30 unidades de energía
        return 30;
    }

    // Método auxiliar para calcular el daño que se inflige al enemigo por cada disparo
    private int calcularDanioPorDisparo(ObjetoDetectado objeto) {
        // Supongamos que el daño es inversamente proporcional a la distancia,
        // es decir, cuanto más lejos, menos daño se hace.
        double distancia = calcularDistancia(objeto);

        // Supongamos que la distancia máxima para causar daño total es de 5000 metros
        double distanciaMaxima = 5000;

        // Si la distancia es menor o igual a la distancia máxima, el daño será máximo (100%).
        // Si es mayor, el daño se reducirá proporcionalmente.
        double porcentajeDanio = 1.0 - (distancia / distanciaMaxima);

        // Supongamos que el daño base es 50 y se multiplica por el porcentaje de daño.
        int danio = (int) (50 * porcentajeDanio);
        return danio;
    }
    
    // Método para realizar acciones evasivas en caso de batería baja y enemigos hostiles
    public void accionesEvasivas() {
        // Obtener el nivel de batería de la armadura
        float nivelBateria = armadura.getGenerador().getNivelBateria();

        // Verificar si el nivel de batería es menor al 10%
        if (nivelBateria < 0.1) {
            // Calcular la distancia a la que debe alejarse (al menos 10 km)
            // Supongamos que la velocidad de vuelo promedio es de 300 km / hora
            double distanciaAlejarse = 10.0; // Distancia mínima para alejarse en km
            double tiempoVueloHoras = distanciaAlejarse / 300.0;

            // Alejarse de los enemigos
            System.out.println("Nivel de batería bajo. Realizando acción evasiva.");
            System.out.println("Alejándose de los enemigos por al menos 10 km...");

            // Simular el vuelo durante el tiempo necesario para alejarse
            // Supongamos que esto pausa la ejecución por el tiempo de vuelo
            try {
                Thread.sleep((long) (tiempoVueloHoras * 3600000)); // Convertir horas a milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Acción evasiva completada. Ahora a una distancia segura.");

        } else {
            // Si el nivel de batería es suficiente, realizar ataques normales
            System.out.println("Nivel de batería suficiente. Realizando ataques...");
            destruirEnemigos();
        }
    }
}



