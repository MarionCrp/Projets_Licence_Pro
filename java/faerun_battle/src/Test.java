
import data.Castle;
import data.Warrior;
import java.util.LinkedList;
import race.*;
import util.BoardGameHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marion
 */
public class Test {
    public static void main(String[] args){
        /* an elf attaks a dwarf : */
        System.out.println("an Elf attacks a Dwarf");
        Elf elf1 = new Elf();
        Dwarf dwarf1 = new Dwarf();
        System.out.println(elf1.getResistance());
        System.out.println(elf1.getStrength());
        while(!dwarf1.isDead()){
           BoardGameHelper.displayFight(elf1.attak(dwarf1));
        }
        
        /* a dwarf attaks an elf : */
        System.out.println("\na Dwarf attacks an Elf");
        Elf elf2 = new Elf();
        Dwarf dwarf2 = new Dwarf();
        while(!elf2.isDead()){
           BoardGameHelper.displayFight(dwarf2.attak(elf2));
        }

        /* an elf Overlord attaks a dwarf : */
        System.out.println("\nan Elf Overlord attacks a Dwarf");
        ElfOverlord elfoverlord1 = new ElfOverlord();
        Dwarf dwarf3 = new Dwarf();
        while(!dwarf3.isDead()){
           BoardGameHelper.displayFight(elfoverlord1.attak(dwarf3));
        }
        
        System.out.println("");
        
        /* an elf attaks a dwarfOverlord : */
        System.out.println("\nan Elf attacks a Dwarf Overlord");
        Elf elf = new Elf();
        DwarfOverlord dwarfoverlord1 = new DwarfOverlord();
        while(!dwarfoverlord1.isDead()){
           BoardGameHelper.displayFight(elf.attak(dwarfoverlord1));
        }
        
        LinkedList<Warrior> blue_army = new LinkedList<>();
        blue_army.add(new Dwarf());
        blue_army.add(new Dwarf());
        blue_army.add(new Elf());
        blue_army.add(new Elf());
        Castle cast = new Castle("Blue", blue_army);
        System.out.println(cast.getColor());
        
    }
}
