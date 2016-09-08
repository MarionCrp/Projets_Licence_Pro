/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import data.Warrior;

/**
 *
 * @author Marion
 */
public class Elf extends Warrior {
    
    public Elf() {
        this.setStrength(20);
    }
    
    public int getResource(){
        return 2;
    }
}
