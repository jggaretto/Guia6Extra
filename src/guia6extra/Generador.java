
package guia6extra;

public class Generador {
   private float nivelEnergia;
   private float estadoReactor;
   private float nivelBateria;
   Generador() {
    }
    
   public Generador(float nivelEnergia, float estadoReactor, float nivelBateria) {
        this.nivelEnergia = nivelEnergia;
        this.estadoReactor = estadoReactor;
        this.nivelBateria = nivelBateria;
    }

    public float getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(float nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public float getEstadoReactor() {
        return estadoReactor;
    }

    public void setEstadoReactor(float estadoReactor) {
        this.estadoReactor = estadoReactor;
    }

    
    public float getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(float nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }
   public void consumirEnergia(int cantidad) {
        nivelEnergia -= cantidad;
   }
   
}