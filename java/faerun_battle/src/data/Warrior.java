/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import util.BoardGameHelper;

/**
 *
 * @author Marion
 */
public abstract class Warrior {
    
    // Constante
    private static final int PV_MAX = 100;
    private static final int STRENGTH_BASE = 10;
    private int strength;
    private int resistance;
    private int pv;
    private int resource;
    private Castle castle;
    private Square square;

    public Warrior() {
        this.pv = PV_MAX;
        this.strength = STRENGTH_BASE;
        this.resistance = 1;
    }

    public int getPv() {
        return pv;
    }
        
    public int getStrength(){
        return strength;
    }
    
    public int getResistance(){
        return resistance;
    }
        
    public int getResource(){
        return resource;
    }
    
    public Castle getCastle(){
        return castle;
    }
    
    public Square getSquare(){
        return square;
    }
    
    public void setSquare(BoardGame board_game){
        if(this.getSquare() == null) this.square = board_game.getSquares()[0];
        
    }
    
    public void setStrength(int strength){
        this.strength = strength;
    }
    
    public void setResistance(int resistance){
        this.resistance = resistance;
    }
    
    public void setResource(int resource){
        this.resource = resource;
    }
    
    public void setCastle(Castle castle){
        this.castle = castle;
    }


    /**
     * @param pv the pv to set
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    public LogFight attak(Warrior target){
        /* randomly set the damage points */
        int base_damage = BoardGameHelper.Dice3(this.getStrength());
        target.getDamage(base_damage);
        
        /* increment the resources of the castles */
        /*target.getCastle().incrementResources();
        this.getCastle().incrementResources();*/
        
        LogFight log = new LogFight(this, target, base_damage);
        return log;
    }

    /* calculates the real damages according to the target strength */
    public int real_damage(int base_dmg){
        return base_dmg / this.getResistance();
    }

    /*
    * removes "dmg" from pv points.
    */
    public void getDamage(int base_dmg) {
       this.setPv(getPv() - this.real_damage(base_dmg));
    }
    
    /*
    * checks if the warrior is dead
    */
    public boolean isDead(){
        return getPv() <= 0;
    }
    
    public String getName(){
        return this.getClass().getSimpleName();
    }
}
