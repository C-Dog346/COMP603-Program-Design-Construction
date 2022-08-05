/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task05_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Callum
 */
public class Image_ {
    private static int n;
    private static boolean spacePrinted = false;;
    private static boolean starPrinted = false;
    
    public synchronized void printSpace(int n) {
        if (spacePrinted != false) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Image_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < n; i++) {
                System.out.print(" ");
        }
        spacePrinted = true;
        notify();
    }
    
    public synchronized void printStar(int n) {
        if (spacePrinted != true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Image_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < n*2-1; i++) {
            System.out.print("*");
        }
        System.out.println();
        spacePrinted = false;
        notify();
    }    
}
