package util;


import data.LogFight;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marion
 */
public class BoardGameHelper {
    private static final Random RANDOM = new Random();
    
    public static int Dice3() {  
        return RANDOM.nextInt(3)+1; 
    }
    
    public static int Dice3(int diceNumber) {  
        int sum = 0;
        for (int i = 0; i < diceNumber; i++) {
            sum = sum + Dice3();
        }   
        return sum; 
    }
    
    public static void displayFight(LogFight log){
        System.out.println(log.getAssailant().getName() + "[" + log.getAssailant().getPv() + " PV] attaks " + log.getTarget().getName());
        System.out.println(log.getTarget().getName() + " losts " + log.getRealDamage() + " pv.");
        System.out.println(log.getTarget().getName() + " still has " + log.getTarget().getPv() + " pv left.");
        if(log.getTarget().isDead()){
            System.out.println(log.getTarget().getName() + " is dead.");
        }
    }
}
