/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_2;

/**
 *
 * @author Callum
 */
public class Printer {
    public static void main(String[] args) {
        Image_ img = new Image_();
        Star star = new Star(img);
        Space space = new Space(img);
        Thread starThread = new Thread(star);
        Thread spaceThread = new Thread(space);
        starThread.start();
        spaceThread.start();
    }
    
}
