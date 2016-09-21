/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * Containing annoucement of the game
 * @author Marion
 */
public final class Display {
    /*
    * Display the logs of a fight. 
    */
    public static void fight(LogFight log){
        System.out.println(log.getAssailant().getName() 
                           + "[" + log.getAssailant().getPv() 
                           + " PV] attaks " 
                           + log.getTarget().getName() 
                           + "[" + log.getTargetPvBeforeAtk()
                           + " PV]");
        if(log.getTarget().isDead()){
            System.out.println(log.getTarget().getName() + " is dead.");
        } else {
             System.out.println(log.getTarget().getName() + " losts " + log.getRealDamage() + " pv.");
        }
    }
    
    /*
    * Display resource annoucement
    */
    public static String newResource(int blue_castle_resource, int red_castle_resource){
        return "\nA new round begins! Each castle owns a new resource !" + castlesResources(blue_castle_resource, red_castle_resource);
    }
    
    public static String castlesResources(int blue_castle_resource, int red_castle_resource){
        return "\nCastles Resources:"
                + "\nBlue Castle: " + blue_castle_resource
                + "\nRed Castle: " + red_castle_resource;
    }
    
    /*
    * Display training annoucement
    */
    public static String training_announcement(){
        return ("Each castle trains its army! \n");
    }
    
    /*
    * Display Army to train
    */
    public static String armyToTrain(Castle castle){
        String annoucement = "\n" + castle.getColor() + " Castle Army to train : \n";
         for(Warrior warrior: castle.getTrainingArmy()){
                    annoucement += "- " + warrior.getName() + " (" + warrior.getResource() + ")" + "\n";
         }
        return annoucement;
    }
    
    /*
    * Display fighting army
    */
    public static String fightingArmy(Castle castle){
        String annoucement;
        if(castle.getFightingArmy().isEmpty()){
            annoucement = "\n" + castle.getColor() + " army has been slaughtered!";
        } else {
        annoucement = "\n" + castle.getColor() + " Castle fighting Army : \n";
         for(Warrior warrior: castle.getFightingArmy()){
                    annoucement += "- " + warrior.getName() + " (" + warrior.getPv()+ "/100 )" + "\n";
         }
        }
        return annoucement;
    }
    
    /*
    * Display the movement of Armies
    */
    public static String moving_annoucement(){
        return "ARMIES ARE MOVING";
    }
    
    public static String winner_annoucenemnt(Castle castle){
        return castle.getColor() + " Castle won !";
    }
           
}