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
public class TestClasses {
    
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
    }
}
