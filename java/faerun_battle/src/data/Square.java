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
    private LinkedList<Warrior> red_warriors = new LinkedList<>();
    private LinkedList<Warrior> blue_warriors = new LinkedList<>();
    
    public Square(){
    }
    
    public LinkedList<Warrior> getBlueWarriors(){
        return blue_warriors;
    }
    
    public LinkedList<Warrior> getRedWarriors(){
        return red_warriors;
    }

    /*
    * Comparing if a square has any warriors from the enemy Castle.
    * @param warrior : looking for enemy to fight with.
    */
    public boolean is_a_fithing_zone(){
        return !getBlueWarriors().isEmpty() && !getRedWarriors().isEmpty();
    }
}