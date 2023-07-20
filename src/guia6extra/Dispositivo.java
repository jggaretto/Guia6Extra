/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6extra;

import java.util.Random;

/**
 *
 * @author jgare
 */
abstract class  Dispositivo {
    
    private boolean danado;

    public Dispositivo() {
    }

    public Dispositivo(boolean danado) {
        this.danado = danado;
    }

    public boolean isDanado() {
        return danado;
    }

    public void setDanado(boolean danado) {
        this.danado = danado;
    }
    
    public boolean intentarReparar() {
        Random random = new Random();
        if (random.nextDouble() <= 0.3) {
            danado = false;
            System.out.println(getClass().getSimpleName() + " reparado con éxito!");
            return true;
        } else {
            System.out.println("No se pudo reparar " + getClass().getSimpleName() + ".");
            return false;
        }
    }

    void reparar() {
        System.out.println("Dispositivo reparado");
    }
}
