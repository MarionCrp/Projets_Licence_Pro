
import data.*;
import race.*;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marion
 */

// TODO : Faire avancer mes nains sur le plateau et ressources.

public class Game {
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
        
        /**************************** First_Round *****************************/
        
        /*********************** displaying resources *************************/
        System.out.println(Display.castles_resources(blue_castle.getResource(), red_castle.getResource()));
        
        /*********************** displaying army to train *********************/
        //System.out.println(Display.trainingArmy(blue_castle, red_castle));
        
        System.out.println(board_game.getSquares()[0].getBlueWarriors().isEmpty());
        /************** checking resources and training warriors if any *******/
        
        
        /* increment the resources of the castles */
        
        blue_castle.incrementResources();
        red_castle.incrementResources();
        
       
        System.out.println(Display.newResource(blue_castle.getResource(), red_castle.getResource()));
    }
}
