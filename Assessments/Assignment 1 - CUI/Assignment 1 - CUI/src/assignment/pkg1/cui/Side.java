/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.util.ArrayList;

/**
 *
 * @author Callum
 */
public class Side {
    private ArrayList<Unit> cards;
    
    /**
     * make cards ArrayList for placing cards on board
     */
    public Side() {
        this.cards = new ArrayList<Unit>();
    }

    /**
     * @return the cards
     */
    public ArrayList<Unit> getCards() {
        return this.cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(ArrayList<Unit> cards) {
        this.cards = cards;
    }    
    
    /**
     * make the side string via a 2D character array
     * @return 
     */
    public char[][] makeSideString() {
        char[][] boardArray = new char[30][130];
        
        int pos = 0;        
        if (!this.cards.isEmpty()) 
            for (int i = 0; i < 9;i++) {
                for (int j = 0; j < this.cards.size();j++) {
                    for (int k = 0; k < this.cards.get(j).getCardString()[i].length;k++) {
                        boardArray[i][pos] = this.cards.get(j).getCardString()[i][k];
                        pos++;
                    }
                    boardArray[i][pos] = '\t';
                    pos++;
                    boardArray[i][pos] = '\n';
                }
                pos = 0;
            } 
        
        return boardArray;
    }
}
