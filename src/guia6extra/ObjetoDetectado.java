
package guia6extra;

public class ObjetoDetectado {
    private double coordenadaX;
    private double coordenadaY;
    private double coordenadaZ;
    private boolean hostil;
    private int resistencia;

    public ObjetoDetectado() {
    }

    public ObjetoDetectado(double coordenadaX, double coordenadaY, double coordenadaZ, boolean hostil, int resistencia) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
        this.hostil = hostil;
        this.resistencia = resistencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(double coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }
    
    
}
