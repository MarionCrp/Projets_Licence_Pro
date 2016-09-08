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
    private Square[] squares;
    
    public BoardGame(int number_of_square){
        this.squares = new Square[number_of_square];
        
        for(int i = 0; i < number_of_square; i++){
            squares[i] = new Square();
        }
    }
    
    public Square[] getSquares(){
        return this.squares;
    }
}
