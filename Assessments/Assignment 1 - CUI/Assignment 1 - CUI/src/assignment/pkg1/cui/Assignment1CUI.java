/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.io.IOException;

/**
 *
 * @author Callum
 * 
 * READ ME
 * 
 * The CUI output doesn't seem to work properly (get random boxes instead of an 
 * empty space, which then messes up the cards) on MacOS (from my experience)
 * - hopefully this is not an issue.
 * Have also seen formatting issues on computers other than my own. 
 * I'm not sure if this is something I should be responsible for
 * I have attached an image in resources of what the ideal card template
 * as well as a txt file with the same template i used in my code
 * 
 * Yet to be implemented
 *  - Special card effects
 *  - Cost of cards (displayed but has no affect)
 *  - Natural disasters!
 */
public class Assignment1CUI {

    /**
     * @param args the command line arguments
     * 
     * runs the game
     */
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        
        game.runGame();
    }
    
}

/*
TO DO

MAKE THE CARDS RANDOM CODE INTO A FUNCTION INSIDE OF Card SUPER CLASS




*/