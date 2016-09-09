/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import data.*;
import java.util.LinkedList;
import race.*;

/**
 *
 * @author Marion
 */
public class TestResource {
    
    public static void main(String[] args){
        /**************************** Create BoardGame ************************/  
        
        BoardGame board_game = new BoardGame(7);


        /************************* Create Castles' Army ***********************/

        LinkedList<Warrior> blue_army = new LinkedList<>();
        blue_army.add(new Dwarf());
        blue_army.add(new Dwarf());
        blue_army.add(new Elf());
        blue_army.add(new Elf());
        blue_army.add(new DwarfOverlord());
        blue_army.add(new ElfOverlord());
        
        LinkedList<Warrior> red_army = new LinkedList<>();
        red_army.add(new Dwarf());
        red_army.add(new Dwarf());
        red_army.add(new Elf());
        red_army.add(new Elf());
        red_army.add(new DwarfOverlord());
        red_army.add(new ElfOverlord());
        
        /**************************** Create Castles **************************/  
        
        Castle blue_castle = new Castle("Blue", blue_army, board_game.getBlueCastleZone());
        Castle red_castle = new Castle("Red", red_army, board_game.getRedCastleZone());
        
        
        
        /************************************ Test  ***************************/
        
        //Display Resource : 
        System.out.println("\nResources : " + blue_castle.getResource());
        
        //Display Datas : 
        System.out.println("Number of warriors waiting in the Castle: " + blue_castle.getTrainingArmy().size());
        System.out.println("Number of warriors trained: " + blue_castle.getFightingArmy().size());
        System.out.println("Number of warriors placed on the staging area (ready to fight): " + board_game.getBlueCastleZone().getBlueWarriors().size());

        // Training Warrior : 
        System.out.println("\n*****************  Training a Warrior *************************\n");
        blue_castle.train_warrior();
        
                
        //Display Resource : 
        System.out.println("\nResources : " + blue_castle.getResource());
        
        //Display Data
        System.out.println("Number of warriors waiting in the Castle: " + blue_castle.getTrainingArmy().size());
        System.out.println("Number of warriors trained: " + blue_castle.getFightingArmy().size());
        System.out.println("Number of warriors placed on the staging area (ready to fight): " + board_game.getBlueCastleZone().getBlueWarriors().size());
        
        // Training Warrior :
        System.out.println("\n*****************  Training a Warrior *************************\n");
        blue_castle.train_warrior();
        
        //Display Resource : 
        System.out.println("\nResources : " + blue_castle.getResource());
        
        // Display Data :
        System.out.println("Number of warriors waiting in the Castle: " + blue_castle.getTrainingArmy().size());
        System.out.println("Number of warriors trained: " + blue_castle.getFightingArmy().size());
        System.out.println("Number of warriors placed on the staging area (ready to fight): " + board_game.getBlueCastleZone().getBlueWarriors().size());
        
        // Training Warrior :
        System.out.println("\n*****************  Training a Warrior *************************\n");
        blue_castle.train_warrior();
        
        //Display Resource : 
        System.out.println("\nResources : " + blue_castle.getResource());
    }

}
