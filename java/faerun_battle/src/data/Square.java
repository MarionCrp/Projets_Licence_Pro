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
    
    public LinkedList<Warrior> getWarriors(Castle castle){
        return castle.getColor().equals("Blue") ? getBlueWarriors() : getRedWarriors();
    }
    
    public LinkedList<Warrior> getEnnemies(Castle castle){
        return castle.getColor().equals("Blue") ? getRedWarriors() : getBlueWarriors();
    }
    
    
    
    public void setBlueWarriors(LinkedList<Warrior> blue_warriors){
        this.blue_warriors = blue_warriors;
    }
    
    public void setRedWarriors(LinkedList<Warrior> red_warriors){
        this.red_warriors = red_warriors;
    }
    
    public void setWarriors(Castle castle, LinkedList<Warrior> army){
        if(castle.getColor().equals("Blue")) setBlueWarriors(army);
        else if(castle.getColor().equals("Red")) setRedWarriors(army);
        else System.out.println("Erreur");
    }

    /*
    * Comparing if a square has any warriors from the enemy Castle.
    * @param warrior : looking for enemy to fight with.
    */
    public boolean is_a_fithing_zone(){
        return !getBlueWarriors().isEmpty() && !getRedWarriors().isEmpty();
    }
    
    public void battle(){
        for(Warrior blue_warrior : getBlueWarriors()){
            if(!getRedWarriors().isEmpty()){
                Warrior red_target = getRedWarriors().peekFirst();
                Display.fight(blue_warrior.attak(red_target));
                if(red_target.isDead()){
                    getRedWarriors().remove(red_target);
                    red_target.getCastle().getFightingArmy().remove(red_target);
                }
            }
        }
        for(Warrior red_warrior : getRedWarriors()){
            if(!getBlueWarriors().isEmpty()){
                Warrior blue_target = getBlueWarriors().peekFirst();
                Display.fight(red_warrior.attak(blue_target));
                if(blue_target.isDead()) {
                    getBlueWarriors().remove(blue_target);
                    blue_target.getCastle().getFightingArmy().remove(blue_target);
                }
            }
        }
}
}