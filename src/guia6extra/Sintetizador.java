
package guia6extra;

import java.util.Random;


class Sintetizador extends Dispositivo {
   private String estado;
   private int consumoEnergia;
   private boolean danado;
   
   Sintetizador() {
    }
   
   public Sintetizador(String estado, int consumoEnergia, boolean danado) {
        this.estado = estado;
        this.consumoEnergia = consumoEnergia;
        this.danado = danado;
    }

    public boolean isDanado() {
        return danado;
    }

    public void setDanado(boolean danado) {
        this.danado = danado;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   public int usar(int intensidad, int tiempo) {
        int energiaConsumida = consumoEnergia * intensidad * tiempo;
        return energiaConsumida;
    }

    public void emitirSonido(String mensaje) {
        System.out.println("Sintetizador: " + mensaje);
    }
    
    public void hablar(String mensaje) {
        if (!danado) {
            System.out.println("JARVIS: " + mensaje);
        } else {
            System.out.println("El sintetizador está dañado y no puede hablar.");
        }
    }
    
    @Override
    public void reparar() {
        Random random = new Random();
        if (random.nextDouble() <= 0.4) {
            danado = false;
            System.out.println("¡Sintetizador reparado!");
        } else {
            System.out.println("No se pudo reparar la consola.");
        }
}
}
