/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

/**
 * unit super class for soldier and building classes
 * @author Callum
 */
public class Unit extends Card implements UnitInterface {
    
    private int health;

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * make the card string using TEMPLATE and a 2D character array
     * @param name
     * @param cost
     * @param damage
     * @param health
     * @return the attack
     */
    
    
    public char[][] makeCardString(String name, int cost, int damage, int health) {
        char newCardString[][] = getTEMPLATE();
        int pos = (int) ((13-name.length())/2) + 1;
        
        // set name
        for (int i = 0;i < name.length();i++) {  
            newCardString[4][pos] = name.toCharArray()[i];
            pos++;
        }

        // set cost, damage and health
        newCardString[1][12] = Character.forDigit(cost, 10);
        newCardString[7][1] = Character.forDigit(damage, 10);
        newCardString[7][12] = Character.forDigit(health, 10);
        
        
        return newCardString;
    }
    
    public void update() {
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }
}
