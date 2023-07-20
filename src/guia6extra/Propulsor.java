
package guia6extra;

import java.util.Random;

public class Propulsor extends Dispositivo {
    private String estado;
    private int consumoEnergia;
    private boolean danado;
    
    public Propulsor() {
    }

    public Propulsor(String estado, int consumoEnergia, boolean danado) {
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
        if (!danado) {
            Random random = new Random();
            if (random.nextDouble() <= 0.3) {
                danado = true;
                System.out.println("¡Propulsor dañado al utilizarlo!");
            } else {
                int energiaConsumida = consumoEnergia * intensidad * tiempo;
                return energiaConsumida;
            }
        }
        return 0;
    }
   
   @Override
   public void reparar() {
        Random random = new Random();
        if (random.nextDouble() <= 0.4) {
            danado = false;
            System.out.println("¡Propulsor reparado!");
        } else {
            System.out.println("No se pudo reparar el propulsor.");
        }
    }
}
