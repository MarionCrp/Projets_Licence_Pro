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
    private final Warrior assailant;
    private final Warrior target;
    private final int target_pv_before_atk;
    private final int base_damage;
    private final int real_damage;
    
    public LogFight(Warrior assailant, Warrior target, int base_damage){
        this.assailant = assailant;
        this.target = target;
        this.base_damage = base_damage;
        this.real_damage = target.real_damage(base_damage);
        this.target_pv_before_atk = target.getPv() + this.real_damage;
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
    
    public int getBaseDamage(){
        return base_damage;
    }
    
    public int getTargetPvBeforeAtk(){
        return target_pv_before_atk;
    }
}
