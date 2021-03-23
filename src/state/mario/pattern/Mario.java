/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.mario.pattern;

import java.util.Observable;

/**
 *
 * @author Fernando
 */
public class Mario extends Observable {

    private MarioState estado;

    public Mario() {
        this.estado = new MarioPequeno();
        notifica();
    }

    public void pegarCogumelo() {
        if (estado != null) {
            estado = estado.pegarCogumelo();
            notifica();
        }
    }

    public void pegarFlor() {
        if (estado != null) {
            estado = estado.pegarFlor();
            notifica();
        }
    }

    public void pegarPena() {
        if (estado != null) {
            estado = estado.pegarPena();
            notifica();
        }
    }

    public void levarDano() {
        if (estado != null) {
            estado = estado.levarDano();
            notifica();
        }
    }

    public void notifica() {
        setChanged();
        notifyObservers(estado);
    }

}
