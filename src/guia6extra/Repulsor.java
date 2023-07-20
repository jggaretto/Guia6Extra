
package guia6extra;

import java.util.Random;


class Repulsor extends Dispositivo{
    private String estado;
    private int consumoEnergia;
    private boolean danado;
    private boolean sano;
    
    public Repulsor() {
    }
    
        public Repulsor(String estado, int consumoEnergia, boolean danado, boolean sano) {
        this.estado = estado;
        this.consumoEnergia= consumoEnergia;
        this.danado = danado;
        this.sano = sano;
    }

    public boolean isSano() {
        return sano;
    }

    public void setSano(boolean sano) {
        this.sano = sano;
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
    
    @Override
     public void reparar() {
        Random random = new Random();
        if (random.nextDouble() <= 0.4) {
            danado = false;
            System.out.println("¡Repulsor reparado!");
        } else {
            System.out.println("No se pudo reparar el repulsor.");
        }
     }

}