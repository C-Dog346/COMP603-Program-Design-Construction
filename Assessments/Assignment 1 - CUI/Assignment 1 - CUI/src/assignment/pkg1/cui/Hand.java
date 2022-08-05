/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

//import java.util.ArrayList;


/**
 *
 * @author Callum
 */
public class Hand {
    
    private Deck deck;
    private Card currentHand[] = new Card[4]; 
    
    /**
     * make hand by grabbing cards from deck
     */
    
    public Hand(Deck deck) {
        this.deck = deck;
        for (int i = 0; i < 4; i++) {
            //this.currentHand.add(this.deck.Grab());
            this.currentHand[i] = this.deck.grab();
        }
        //this.toString();
    }

    /**
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * @return the currentHand
     */
    public Card[] getCurrentHand() {
        return currentHand;
    }

    /**
     * @param currentHand the currentHand to set
     */
    public void setCurrentHand(Card[] currentHand) {
        this.currentHand = currentHand;
    }

    /**
     * remove the specified card
     * @param card 
     */
    public void remove(int card) {
      
        this.currentHand[card] = null;
        for (int i = card+1; i < 4; i++) {                
            currentHand[i-1] = currentHand[i];
        }
        this.currentHand[3] = null;
}
    
    /**
     * make the hand string via a 2D character array
     * @return 
     */
    public char[][] makeHandString() {
        char[][] boardArray = new char[30][100];
        
        int pos = 0; 
        for (int i = 0; i < 9;i++) {
            for (int j = 0; j < this.currentHand.length;j++) { 
                if (this.currentHand[j] != null) {
                    for (int k = 0; k < this.currentHand[j].getCardString()[i].length;k++) {
                        boardArray[i][pos] = this.currentHand[j].getCardString()[i][k];
                        pos++; 
                    }
                    boardArray[i][pos] = '\t';
                    pos++;
                    boardArray[i][pos] = '\n';
                }    
            }
            pos = 0;
        } 
        
        return boardArray;
    }
    
    public boolean isEmpty() {
        for (int i = 0;i < this.currentHand.length;i++)
            if (this.currentHand[i] != null)
                return false;
        
        return true;
    }
}
