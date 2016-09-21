
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
        
        // TODO : Avancer les unités sur le plateau en vérifiant d'abord qu'il n'y a pas d'ennemi sur la case actuelle. Puis vérifier sru la suivante.
        
        /**************************** Create BoardGame ************************/  
        
        BoardGame board_game = new BoardGame(5);


        /************************* Create Castles' Army ***********************/

        LinkedList<Warrior> blue_army = new LinkedList<>();
        blue_army.add(new Dwarf());
        blue_army.add(new Dwarf());
        blue_army.add(new Elf());
        blue_army.add(new Elf());
        blue_army.add(new ElfOverlord());
        
        LinkedList<Warrior> red_army = new LinkedList<>();
        red_army.add(new Dwarf());
        red_army.add(new Dwarf());
        red_army.add(new Elf());
        red_army.add(new Elf());
        red_army.add(new DwarfOverlord());
        red_army.add(new ElfOverlord());
        red_army.add(new ElfOverlord());
        
        /**************************** Create Castles **************************/  
        
        Castle blue_castle = new Castle("Blue", blue_army);
        Castle red_castle = new Castle("Red", red_army);
        
        /**************************** First_Round *****************************/
        
        /*********************** displaying resources *************************/
        System.out.println(Display.castlesResources(blue_castle.getResource(), red_castle.getResource()));
        
        /*********************** displaying army to train *********************/
        System.out.println(Display.armyToTrain(blue_castle));
        System.out.println(Display.armyToTrain(red_castle));     

        
        /* increment the resources of the castles */        
        blue_castle.incrementResources();
        red_castle.incrementResources();

        /************** checking resources and TRAINING WARRIORS if any *******/
        
        System.out.println(Display.training_announcement().toUpperCase());
        while(blue_castle.train_warrior(board_game));
        while(red_castle.train_warrior(board_game));

        
        /****************** Armies are moving *********************************/
        System.out.println(Display.moving_annoucement());
        board_game.moving(blue_castle);
        board_game.moving(red_castle);
        
                
        /************************ Fighting Time *******************************/       
        
        board_game.fighting(blue_castle, red_castle);
        
        
        /************************ end of a tour *******************************/
        
        /************************ rounds to the end ***************************/
        
        while(!board_game.someone_won()){
             
            /*********************** Other_Rounds *****************************/
        
            /******************* displaying resources *************************/
           
            blue_castle.incrementResources();
            red_castle.incrementResources();
            System.out.println(Display.newResource(blue_castle.getResource(), red_castle.getResource()));
            
            /********** checking resources and TRAINING WARRIORS if any *******/
        
            System.out.println(Display.training_announcement().toUpperCase());
            while(blue_castle.train_warrior(board_game));
            while(red_castle.train_warrior(board_game));


            /****************** Armies are moving *****************************/
            System.out.println(Display.moving_annoucement());
            board_game.moving(blue_castle);
            board_game.moving(red_castle);
            
            /*********************** displaying army to train ******************/
            System.out.println(Display.fightingArmy(blue_castle));
            System.out.println(Display.fightingArmy(red_castle)); 

            /************************ Fighting Time ***************************/       

            board_game.fighting(blue_castle, red_castle);
        }
        if(board_game.someone_won()) System.out.println(Display.winner_annoucenemnt(board_game.winner_team()));
    }
}
