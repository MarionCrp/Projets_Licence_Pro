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
        return "\n\nA new round begins! Each castle owns a new resource !" + castles_resources(blue_castle_resource, red_castle_resource);
    }
    
    public static String castles_resources(int blue_castle_resource, int red_castle_resource){
        return "\nCastles Resources:"
                + "\nBlue Castle: " + blue_castle_resource
                + "\nRed Castle: " + red_castle_resource;
    }
    
    /*
    * Display training annoucement
    */
    public static String training(){
        return ("Each castle trains its army! \n");
        
    }
    
}
