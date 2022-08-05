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
public class Board {
    private Side userSide;
    private Side computerSide;
    private Hand userHand;
    private Player computer;
    private Player player;

    /**
     * creates sides and assigns user hand objects
     * 
     * @param userHand 
     */
    public Board(Hand userHand, Player computer, Player player) {
        this.userSide = new Side();
        this.computerSide = new Side();
        this.userHand = userHand;
        this.computer = computer;
        this.player = player;
    }
    

    /**
     * @return the userSide
     */
    public Side getUserSide() {
        return userSide;
    }

    /**
     * @param userSide the userSide to set
     */
    public void setUserSide(Side userSide) {
        this.userSide = userSide;
    }

    /**
     * @return the computerSide
     */
    public Side getComputerSide() {
        return computerSide;
    }

    /**
     * @param computerSide the computerSide to set
     */
    public void setComputerSide(Side computerSide) {
        this.computerSide = computerSide;
    }
    /**
     * prints out the board + hand (computer side, user side, user hand)
     */
    
    public void printFullBoard() {
        char computerArray[][] = this.computerSide.makeSideString();
        char userArray[][] = this.userSide.makeSideString();
        char userHandArray[][] = this.userHand.makeHandString();
        
        System.out.println("=================================================="
                + "==========================================================="
                + "================================================");
        
        System.out.println("");
        System.out.println("                      " + this.computer.getEmperor() + " - " + this.computer.getHealth());
        System.out.println("\n");
        
        System.out.println("─────────────────────────────"
                + "─────────────────────────────────────"
                + "──────────────────────────────────");
        String output = "";
        
        if (this.computerSide.getCards().isEmpty())
            System.out.println("\n\n\n\n\n\n\n\n");
        
        for (int i=0; i < computerArray.length; i++) {
            for (int j=0; j < computerArray[i].length; j++) {
                output += computerArray[i][j];
            }
        } 
        
        System.out.println(output+"\n");
        
        System.out.println("─────────────────────────────"
                + "─────────────────────────────────────"
                + "──────────────────────────────────\n");
        output = "";
        
        if (this.computerSide.getCards().isEmpty())
            System.out.println("\n\n\n\n\n\n");
        
        for (int i=0; i < userArray.length; i++) {
            for (int j=0; j < userArray[i].length; j++) {
                output += userArray[i][j];
            }
            //System.out.println(userArray[i]);
        } 
        
        System.out.println(output);
        
        output += "\n";
        
        System.out.print("---------------------------------------------------"
                + "----------------------------------------------------"
                + "-------------------------------------------------------");
        output = "";
        
       for (int i=0; i < userHandArray.length; i++) {
            for (int j=0; j < userHandArray[i].length; j++) {
                output += userHandArray[i][j];
            }
        } 
        
        System.out.println("\n"+output);
        System.out.println("");
        System.out.println("                      " + this.player.getEmperor() + " - " + this.player.getHealth());
        System.out.println("\n");
    }
}
