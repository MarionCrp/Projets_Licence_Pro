/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author Marion
 */
public class Castle {
   
    /*warriors to train*/
    private LinkedList<Warrior> training_army = new LinkedList<>();
    
    /* warriors ready to fight */
    private LinkedList<Warrior> fighting_army = new LinkedList<>();
    
    private int resource;
    private final String color;
   
    
    public Castle(String color, LinkedList training_army) {
       this.training_army = training_army;
       this.resource = 3;
       this.color = color;
       paint_warriors(this.training_army);
    }
    
    public int getResource() {
        return resource;
    }
    
    public String getColor() {
        return color;
    }

    public LinkedList<Warrior> getTraining_army() {
        return training_army;
    }

    public LinkedList<Warrior> getFighting_army() {
        return fighting_army;
    }
    
    public void setResource(int resource) {
      this.resource = resource;
    }
    
    /*
    * Add a resource point every round
    */
    public void incrementResources(){
        this.setResource(getResource() + 1);
    }
    
    /*
    * Add an army of warrior to the castle
    */
    public void paint_warriors(LinkedList<Warrior> training_army){
        for(Warrior warrior: training_army){
            warrior.setCastle(this);
        }
    }
}
