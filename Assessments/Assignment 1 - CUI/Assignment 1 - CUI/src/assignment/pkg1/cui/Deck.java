/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Callum
 */
public class Deck {    
    private Stack<Card> deck = new Stack<Card>();
    
    public Deck() {
        
        // creates a deck of 10 cards. 50% chance for a soldier, 30% for a building and 20% for an equipment
        for (int i = 0;i < 10;i++) {
            Random random = new Random();
            int rand = random.nextInt(10);
            switch (rand) {
                case 0:
                    deck.add(new Soldier());
                    break;
                case 1:
                    deck.add(new Soldier());
                    break;
                case 2:
                    deck.add(new Soldier());
                    break;
                case 3:
                    deck.add(new Soldier());
                    break;
                case 4:
                    deck.add(new Soldier());
                    break;
                case 5:
                    deck.add(new Building());
                    break;
                case 6:
                    deck.add(new Building());
                    break;
                case 7:
                    deck.add(new Building());
                    break;
                case 8:
                    deck.add(new Equipment());
                    break;
                case 9:
                    deck.add(new Equipment());
                    break;
                
            }
            
        }
    }
    
    public Card grab() {
        return deck.pop();
    }

    public boolean isEmpty() {
        return (deck.isEmpty());
    }
    
}
