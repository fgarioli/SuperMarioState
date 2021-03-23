/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.mario.pattern;

/**
 *
 * @author Fernando
 */
public abstract class MarioState {
    public abstract MarioState pegarCogumelo();
    public abstract MarioState pegarFlor();
    public abstract MarioState pegarPena();
    public abstract MarioState levarDano();
}
