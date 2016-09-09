
import data.*;
import race.*;
import util.BoardGameHelper;
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

public class Test {
    public static void main(String[] args){
        
        /************************* Testing Warriors ***************************/
        
        System.out.println(" *************** Testing Warriors ***************\n");
        
        /* an elf attaks a dwarf : */
        System.out.println("\n********* an Elf attacks a Dwarf **********\n");
        Elf elf1 = new Elf();
        Dwarf dwarf1 = new Dwarf();
        while(!dwarf1.isDead()){
           Display.fight(elf1.attak(dwarf1));
        }
        
        /* a dwarf attaks an elf : */
        System.out.println("\n********* a Dwarf attacks an Elf  *********\n");
        Elf elf2 = new Elf();
        Dwarf dwarf2 = new Dwarf();
        while(!elf2.isDead()){
           Display.fight(dwarf2.attak(elf2));
        }

        /* an elf Overlord attaks a dwarf : */
        System.out.println("\n\n********* an Elf Overlord attacks a Dwarf *********\n");
        ElfOverlord elfoverlord1 = new ElfOverlord();
        Dwarf dwarf3 = new Dwarf();
        while(!dwarf3.isDead()){
           Display.fight(elfoverlord1.attak(dwarf3));
        }
        
        System.out.println("");
        
        /* an elf attaks a dwarfOverlord : */
        System.out.println("\n\n ********* an Elf attacks a Dwarf Overlord *********\n");
        Elf elf = new Elf();
        DwarfOverlord dwarfoverlord1 = new DwarfOverlord();
        while(!dwarfoverlord1.isDead()){
           Display.fight(elf.attak(dwarfoverlord1));
        }
        
        
        /**************************** Create BoardGame ************************/  
        
        BoardGame board_game = new BoardGame(5);


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
        
        Castle blue_castle = new Castle("Blue", blue_army);
        Castle red_castle = new Castle("Red", red_army);
        
        /******************************* Round ********************************/
        /* increment the resources of the castles */
        
        blue_castle.incrementResources();
        red_castle.incrementResources();
        
        /**************** checking resources and training warriors if any ******/
        
    }
}
