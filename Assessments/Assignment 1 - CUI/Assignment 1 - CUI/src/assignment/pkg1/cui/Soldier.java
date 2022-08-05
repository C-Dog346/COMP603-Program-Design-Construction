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
public class Soldier extends Unit {
    /**
     * set card to specific soldier type
     */
    public Soldier() {
        setNumCards(7);
        Random random = new Random();
        int rand = random.nextInt(getNumCards());
        
        switch (rand) {
            case 0:
                setToRecruit();
                break;
            case 1:
                setToDemoMan();
                break;
            case 2:
                setToSamurai();
                break;
            case 3:
                setToSeargent();
                break;
            case 4:
                setToTwins();
                break;
            case 5:
                setToSniper();
                break;
            case 6:
                setToMedic();
                break;
    }
}
    /**
     * following functions set up the card to the correct values 
     */

    private void setToRecruit() {
        setName("Recruit");
        setCost(1);
        setDamage(1);
        setHealth(2);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToDemoMan() {
        setName("DemoMan");
        setCost(7);
        setDamage(4);
        setHealth(4);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToSamurai() {
        setName("Samurai");
        setCost(5);
        setDamage(4);
        setHealth(4);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }
    
    private void setToSeargent() {
        setName("Seargent");
        setCost(2);
        setDamage(2);
        setHealth(3);
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToTwins() {
        setName("Twins");
        setCost(4);
        setDamage(2);
        setHealth(2);
        //setSpecial(true); YET TO BE IMPLEMENTED
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToSniper() {
        setName("Sniper");
        setCost(5);
        setDamage(4);
        setHealth(1);
        //setSpecial(true); YET TO BE IMPLEMENTED
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }

    private void setToMedic() {
        setName("Medic");
        setCost(3);
        setDamage(1);
        setHealth(3);
        //setSpecial(true); YET TO BE IMPLEMENTED
        setCardString(makeCardString(getName(), getCost(), getDamage(), getHealth()));
    }  
}
