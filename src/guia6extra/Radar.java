
package guia6extra;

import java.util.ArrayList;
import java.util.List;


public class Radar {
    private List<ObjetoDetectado> objetosDetectados;

    public Radar() {
        objetosDetectados = new ArrayList<>();
    }

    public List<ObjetoDetectado> getObjetosDetectados() {
        return objetosDetectados;
    }

    public void setObjetosDetectados(List<ObjetoDetectado> objetosDetectados) {
        this.objetosDetectados = objetosDetectados;
    }

    // Método para agregar un objeto detectado a la lista
    public void agregarObjetoDetectado(double coordenadaX, double coordenadaY, double coordenadaZ, boolean hostil) {
        ObjetoDetectado objeto = new ObjetoDetectado();
        objeto.setCoordenadaX(coordenadaX);
        objeto.setCoordenadaY(coordenadaY);
        objeto.setCoordenadaZ(coordenadaZ);
        objeto.setHostil(hostil);
        objetosDetectados.add(objeto);
    }
    public void agregarObjetoDetectado(ObjetoDetectado objeto) {
        objetosDetectados.add(objeto);
    }
}
