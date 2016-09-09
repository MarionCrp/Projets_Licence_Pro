/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author Marion
 */
public class Square {
    /* a square contains a list of warriors (fighting or moving) */
    private LinkedList<Warrior> warriors = new LinkedList<>();
    public Square(){
    }
    
    /*
    * 
    */
    public LinkedList<Warrior> getWarriors(){
        return warriors;
    }
    
    /*
    * Comparing if a square has any warriors from the enemy Castle.
    * @param warrior : looking for enemy to fight with.
    */
    public boolean has_any_enemy(Warrior warrior){
        for(Warrior other_warrior: warriors){
            if(other_warrior.getCastle() == warrior.getCastle()) return true;
        }
        return false;
    }
}