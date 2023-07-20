
package guia6extra;

import java.util.Random;

public class Consola extends Dispositivo {
  private String estado;
  private int consumoEnergia;
  private boolean danado;

    public Consola() {
    }

    public Consola(String estado, int consumoEnergia, boolean danado) {
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

    public void mostrarMensaje(String mensaje) {
        System.out.println("Consola: " + mensaje);
    }
    
    @Override
public void reparar() {
        Random random = new Random();
        if (random.nextDouble() <= 0.4) {
            danado = false;
            System.out.println("¡Consola reparada!");
        } else {
            System.out.println("No se pudo reparar la consola.");
        }
}

}
