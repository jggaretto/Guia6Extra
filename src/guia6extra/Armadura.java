
package guia6extra;


class Armadura {
    private String colorPrimario;
    private String colorSecundario;
    private Propulsor[] propulsores;
    private Repulsor[] repulsores;
    private int resistencia;
    private int salud;
    private Generador generador;
    private Consola consola;
    private Sintetizador sintetizador;
    private float nivelEnergia = 100f;
    private Radar radar;

   
    Armadura(Radar radar) {
        this.radar = radar;
    }
    public Armadura(String colorPrimario, String colorSecundario, Propulsor[] propulsores, Repulsor[] repulsores, int resistencia, int salud, Generador generador, Consola consola, Sintetizador sintetizador) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.propulsores = propulsores;
        this.repulsores = repulsores;
        this.resistencia = resistencia;
        this.salud = salud;
        this.generador = generador;
        this.consola = consola;
        this.sintetizador = sintetizador;
        
    }

    

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }


    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Propulsor[] getPropulsores() {
        return propulsores;
    }

    public void setPropulsores(Propulsor[] propulsores) {
        this.propulsores = propulsores;
    }

    public Repulsor[] getRepulsores() {
        return repulsores;
    }

    public void setRepulsores(Repulsor[] repulsores) {
        this.repulsores = repulsores;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }

    public void setNivelEnergia(float nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }
    
    public float getNivelEnergia() {
        return nivelEnergia;
    }

  public void caminar(int tiempo) {
        int intensidad = 1;
        int energiaConsumida = propulsores[0].usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
        }
    }

    public void correr(int tiempo) {
        int intensidad = 2;
        int energiaConsumida = propulsores[0].usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
        }
    }

     public void propulsarse(int tiempo) {
        int intensidad = 3;
        int energiaConsumida = propulsores[0].usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
        }
    }

   public void volar(int tiempo) {
        int intensidadBotas = 3;
        int intensidadGuantes = 2;
        int energiaConsumidaBotas = propulsores[0].usar(intensidadBotas, tiempo);
        int energiaConsumidaGuantes = repulsores[0].usar(intensidadGuantes, tiempo);
        if (energiaConsumidaBotas > 0 && energiaConsumidaGuantes > 0) {
            generador.consumirEnergia(energiaConsumidaBotas + energiaConsumidaGuantes);
        }
    }

    public void usarGuantesComoArmas(int tiempo) {
        int intensidad = 3;
        int energiaConsumida = repulsores[0].usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
        }
    }

    public void escribirEnConsola(String mensaje) {
        int intensidad = 1;
        int tiempo = 1;
        int energiaConsumida = consola.usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
            consola.mostrarMensaje(mensaje);
        }
    }

    public void hablarEnSintetizador(String mensaje) {
        int intensidad = 1;
        int tiempo = 1;
        int energiaConsumida = sintetizador.usar(intensidad, tiempo);
        if (energiaConsumida > 0) {
            generador.consumirEnergia(energiaConsumida);
            sintetizador.hablar(mensaje);
    } else {
            System.out.println("¡El sintetizador está dañado o no tiene suficiente energía para hablar!");
        }
    }
     public void mostrarEstadoBateria() {
        System.out.println("Estado de la Batería: " + nivelEnergia + "%");
    }
     
     public void repararDanios() {
        for (Propulsor propulsor : propulsores) {
            if (propulsor.isDanado()) {
                propulsor.reparar();
            }
        }

        for (Repulsor repulsor : repulsores) {
            if (repulsor.isDanado()) {
                repulsor.reparar();
            }
        }

        if (consola.isDanado()) {
            consola.reparar();
        }

        if (sintetizador.isDanado()) {
            sintetizador.reparar();
        }
     }
}

    
    
  