/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.util.Random;

/**
 *
 * @author Callum
 */
public class Equipment extends Card {
    public Equipment() {
        setNumCards(1);
        Random random = new Random();
        int rand = random.nextInt(getNumCards());
        setType("Equipment");       
        
        switch (rand) {
            case 0:
                setToGrenade();
                break;
    }
}
    /**
     * following functions set up the card to the correct values 
     */
    private void setToGrenade() {
        setName("Grenade");
        setDamage(3);
        setCardString(makeCardString(getName(), getCost(), getDamage()));
    }
    /**
     * make the card string using TEMPLATE and a 2D character array
     * 
     * @param name
     * @param cost
     * @param damage
     * @return 
     */
    
    public char[][] makeCardString(String name, int cost, int damage) {
        char newCardString[][] = getTEMPLATE();
        
        int pos = (int) ((13-name.length())/2) + 1;
        

        for (int i = 0;i < name.length();i++) {  
            newCardString[4][pos] = name.toCharArray()[i];
            pos++;
        }
       
        // set cost and damage
        newCardString[1][12] = Character.forDigit(cost, 10);
        newCardString[7][1] = Character.forDigit(damage, 10);
        newCardString[7][12] = ' ';
        
        return newCardString;
    }
}