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
    
    /********************************* GETTERS ********************************/
    
    public int getResource() {
        return resource;
    }
    
    public String getColor() {
        return color;
    }

    public LinkedList<Warrior> getTrainingArmy() {
        return training_army;
    }

    public LinkedList<Warrior> getFightingArmy() {
        return fighting_army;
    }
    
    /********************************* SETTERS ********************************/
    
    public void setResource(int resource) {
      this.resource = resource;
    }
        
    /****************************** PUBLIC METHODES ***************************/
    
    
    /*
    * Add a resource point every round
    */
    public void incrementResources(){
        this.setResource(getResource() + 1);
    }
    
    /*
    * train warrior
    */
    public boolean train_warrior(BoardGame board_game){
        /* First we check if we have any resource */
        if (getResource() > 0 && !getTrainingArmy().isEmpty()){
            /* We pick the first warrior of the training army to train.
               We compare the resources we had and the resources we need to train the warrior */
            Warrior warrior_to_train = getTrainingArmy().peekFirst();
            // If we have enough resource we train the warrior
            if(warrior_to_train.getResource() <= getResource()){
                setResource(getResource() - warrior_to_train.getResource());
                getFightingArmy().add(warrior_to_train);
                getTrainingArmy().remove(warrior_to_train);
                System.out.println(warrior_to_train.getName() + " is ready to fight!");
                if (getColor().toLowerCase().equals("blue")){
                    board_game.getBlueCastleZone().getBlueWarriors().add(warrior_to_train);
                    return true;
                } else if (getColor().toLowerCase().equals("red")){
                    board_game.getRedCastleZone().getRedWarriors().add(warrior_to_train);
                    return true;
                } else {
                    // When the castle name is not "red" or "blue", error
                    System.out.println("Erreur dans les couleurs des chateaux");
                    return false;
                }
            }
        }
        if(getTrainingArmy().isEmpty()){
            System.out.println("No more warrior to train");
        }
        else{
            System.out.println("Not enough resources to train a " + getColor() + " " + getTrainingArmy().peekFirst().getClass().getSimpleName() + "\n");  
        }
        return false;
    }
    
    /****************************** PRIVATE METHODES ***************************/
    
    /*
    * Add an army of warrior to the castle
    */
    private void paint_warriors(LinkedList<Warrior> training_army){
        for(Warrior warrior: training_army){
            warrior.setCastle(this);
        }
    }
    
    
}
