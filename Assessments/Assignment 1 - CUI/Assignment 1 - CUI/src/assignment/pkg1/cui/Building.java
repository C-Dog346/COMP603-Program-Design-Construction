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
public class Building extends Unit {
    /**
     * makes the building card a specific type of building
     */
    public Building() {
        setNumCards(2);
        Random random = new Random();
        int rand = random.nextInt(getNumCards());
        
        switch (rand) {
            case 0:
                setToArtillery();
                break;
            case 1:
                setToSandbags();
                break;
        }
    }

    /**
     * following functions set up the card to the correct values 
     */
    
    private void setToArtillery() {
        setName("Artillery");
        setCost(0);
        setDamage(3);
        setHealth(2);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToSandbags() {
        setName("Sandbags");
        setCost(0);
        setDamage(0);
        setHealth(5);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }
    
}