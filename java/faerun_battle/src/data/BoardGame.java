/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

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
    private Square squareToReach(Warrior warrior){
        if(warrior.getCastle().getStagingArea() == blue_castle_zone) return red_castle_zone;
        else return blue_castle_zone;
    }

    public boolean someone_won(){
        return !getBlueCastleZone().getRedWarriors().isEmpty() || !getRedCastleZone().getBlueWarriors().isEmpty();
    }
    
    public Castle winner_team(){
        if(!getBlueCastleZone().getRedWarriors().isEmpty()) return getBlueCastleZone().getRedWarriors().peekFirst().getCastle();
        else return getRedCastleZone().getBlueWarriors().peekFirst().getCastle();
    }
}
