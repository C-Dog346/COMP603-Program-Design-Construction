/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

/**
 *
 * @author Callum
 */
public class Player {
    
    private String name;
    private String emperor;
    private int health;
    //private boolean finalBlowCheck; YET TO BE IMPLEMENTED
    
    /**
     * set name and emperor
     * @param name
     * @param emperor 
     */
    Player(String name, int emperor) {  
        this.name = name;
        switch (emperor) {
            case 1:
                this.emperor = "Brutus";
                break;
            case 2:
                this.emperor = "Greg";
                break;
            case 3:
                this.emperor = "Sha'aria";
                break;
        }
        setEmperorStats();        
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
     * @return the emperor
     */
    public String getEmperor() {
        return emperor;
    }

    /**
     * @param emperor the emperor to set
     */
    public void setEmperor(String emperor) {
        this.emperor = emperor;
    }
    
    public void setEmperorStats() {
        //this.finalBlowCheck = false; YET TO BE IMPLEMENTED
        switch (this.emperor) {
            case "Brutus":
                this.setHealth(20);
                break;
            case "Sha'aria":
                //finalBlowCheck = true; YET TO BE IMPLEMENTED
                this.setHealth(15);
                break;
            default:
                this.setHealth(15);
                break;
        }
    }

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
}
