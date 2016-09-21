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
public class BoardGame {
    /* A Board has a certain numbers of squares
    * The first one and the last one are the staging ones where stand warriors ready to fight.
    * But they can't fight inside. 
    * When a warrior has reach the staging of the enemies Castle, his team wins.
    */
    private Square[] squares;
    private Square blue_castle_zone;
    private Square red_castle_zone;
    
    public BoardGame(int number_of_square){
        this.squares = new Square[number_of_square];
        for(int i = 0; i < number_of_square; i++){
            squares[i] = new Square();
        }
        this.blue_castle_zone = squares[0];
        this.red_castle_zone = squares[squares.length - 1];
    }
    
    /********************************* GETTERS ********************************/
    
    public Square[] getSquares(){
        return squares;
    }
    
    public Square getBlueCastleZone() {
        return blue_castle_zone;
    }
    
    public Square getRedCastleZone() {
        return red_castle_zone;
    }
    
    /*
    * Return the square where the enemy castle is
    */
    private Square squareToReach(Castle castle){
        return (castle.getColor().equals("Blue")) ? red_castle_zone : blue_castle_zone;
    }

    public boolean someone_won(){
        return !getBlueCastleZone().getRedWarriors().isEmpty() || !getRedCastleZone().getBlueWarriors().isEmpty();
    }
    
    public Castle winner_team(){
        if(!getBlueCastleZone().getRedWarriors().isEmpty()) return getBlueCastleZone().getRedWarriors().peekFirst().getCastle();
        else return getRedCastleZone().getBlueWarriors().peekFirst().getCastle();
    }
    
    public void moving(Castle castle){
        /* On gère les déplacements des bleus */
        if(castle.getColor().equals("Blue")){
            //Debuggage: 
            /*System.out.println("Situation d'avant déplacement :");
            for(int i = 0; i <= getSquares().length - 1; i++){
                Square square = getSquares()[i];
                System.out.println(square.getBlueWarriors().size());
            }*/
            
            /* On cherche la position la plus avancée des bleus sur le jeu */
            for(int i = getSquares().length - 1; i >= 0; i--){
                Square square = getSquares()[i];
                /* Si il n'y a pas de rouge et que des guerriers bleus sont sur la case */
                if(!square.is_a_fithing_zone() && !square.getBlueWarriors().isEmpty()){
                    /* Si les guerriers bleus ont atteind leur objectif, ils gagnent */
                    if(square == squareToReach(castle)){
                        System.out.println("The Blue Castle won !");
                    } else {
                        getSquares()[i+1].getBlueWarriors().addAll(square.getBlueWarriors());
                        square.getBlueWarriors().clear();
                    }
                }
            }
            //Débuggage : 
            /*System.out.println("Situation d'après déplacement :");
            for(int i = 0; i <= getSquares().length - 1; i++){
                Square square = getSquares()[i];
                System.out.println(square.getBlueWarriors().size());
            }*/
            
        } else {
             /* On gère les déplacements des rouges */
            
            //Debuggage
            /*System.out.println("Situation d'avant déplacement :");
            for(int i = 0; i <= getSquares().length - 1; i++){
                Square square = getSquares()[i];
                System.out.println(square.getRedWarriors().size());
            }*/
            /* On cherche la position la plus avancée des rouges sur le jeu */
            for(int i = 0; i <= getSquares().length - 1; i++){
                Square square = getSquares()[i];
                /* Si il n'y a pas de bleu et que des guerriers rouges sont sur la case */
                if(!square.is_a_fithing_zone() && !square.getRedWarriors().isEmpty()){
                    /* Si les guerriers rouges ont atteind leur objectif, ils gagnent */
                    if(square == squareToReach(castle)){
                        System.out.println("The Red Castle won !");
                    } else {
                        getSquares()[i-1].getRedWarriors().addAll(square.getRedWarriors());
                        square.getRedWarriors().clear();
                    }
                }
            }
            // Debuggage
            /*System.out.println("Situation d'après déplacement :");
            for(int i = 0; i <= getSquares().length - 1; i++){
                Square square = getSquares()[i];
                System.out.println(square.getRedWarriors().size());
            }*/
        }
    }
    
    public void fighting(Castle blue_castle, Castle red_castle){
        for(Square square : squares){
            if(square.is_a_fithing_zone()){
                square.battle();
            }
        }
    }
}



