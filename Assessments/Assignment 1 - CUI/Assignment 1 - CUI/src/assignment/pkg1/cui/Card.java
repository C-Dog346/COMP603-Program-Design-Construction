/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

/**
 *
 * @author Callum
 * 
 * card super class used by the unit and equipment classes
 */
public class Card {
    private int numCards;
    private String type;
    private int cost;
    private int damage;
    private String name;
    private char[][] cardString;
  //private boolean special; YET TO BE IMPLEMENTED
    
    // template used for all cards
    private final char[][] TEMPLATE = { 
        "┌───────┐".toCharArray(),
        "│           ?|".toCharArray(),
        "│            |".toCharArray(),
        "│            |".toCharArray(),
        "│            |".toCharArray(),
        "│            |".toCharArray(),
        "│            |".toCharArray(),
        "│?          ?|".toCharArray(),
        "└───────┘".toCharArray()
    };
  
    public Card() {
        this.type = "Card";
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the attack
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the attack to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the numCards
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * @param numCards the numCards to set
     */
    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    /**
     * @return the special
     */
    /*
    public boolean isSpecial() {
        return special;
    }

    /**
     * @param special the special to set                 YET TO BE IMPLEMENTED
     *//*
    public void setSpecial(boolean special) {
        this.special = special;
    }*/

    /**
     * @return the cardString
     */
    public char[][] getCardString() {
        return cardString;
    }

    /**
     * @param cardString the cardString to set
     */
    public void setCardString(char[][] cardString) {
        this.cardString = cardString;
    }
    
    /**
     * to String method
     * @return output
     
    
    public String toString() {
        String output = "";
        
        for (int i=0; i  this.cardString.length; i++) {
            for (int j=0; j  this.cardString[i].length; j++) {
                output += this.cardString[i][j];
            }
            output += "  ";
        } 
        
        return output;
    }*/

    /**
     * @return the TEMPLATE
     */
    public char[][] getTEMPLATE() {
        return this.TEMPLATE;
    }
}    
