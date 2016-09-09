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
public class Display {
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
    public static String newResource(){
        return "A new round begins! Each castle owns a new resource !";
    }
    
    /*
    * Display training annoucement
    */
    public static String training(){
        return "Each castle trains its army!";
    }
    
}
