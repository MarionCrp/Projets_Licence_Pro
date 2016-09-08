/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Warrior;

/**
 *
 * @author Marion
 */
public class LogFight {
    private Warrior assailant;
    private Warrior target;
    private int base_damage;
    private int real_damage;
    
    public LogFight(Warrior assailant, Warrior target, int base_damage){
        this.assailant = assailant;
        this.target = target;
        this.base_damage = base_damage;
        this.real_damage = target.real_damage(base_damage);
    }
    
    public Warrior getAssailant(){
        return assailant;
    }
    
    public Warrior getTarget(){
        return target;
    }
    
    public int getRealDamage(){
        return real_damage;
    }
    
    private int getBaseDamage(){
        return base_damage;
    }
    
    public void displayFightInfo(){
      System.out.println(getAssailant().getClass().getName());
    }
}
