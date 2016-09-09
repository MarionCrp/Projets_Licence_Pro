package util;


import data.LogFight;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Containing helpful methods for the boardgame.
 * @author Marion
 */
public class BoardGameHelper {
    
    private static final Random RANDOM = new Random();
    
    /*
    * Randomly set a number between 1 and 3.
    */
    public static int Dice3() {  
        return RANDOM.nextInt(3)+1; 
    }
    
    /*
    * Randomly set "diceNumber" times number between 1 and 3 and return the sum.
    */
    public static int Dice3(int diceNumber) {  
        int sum = 0;
        for (int i = 0; i < diceNumber; i++) {
            sum = sum + Dice3();
        }   
        return sum; 
    }
}
