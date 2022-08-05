/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.cui;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * runs the various sections of the game and creates the necessary objects
 * @author Callum
 */
class Game {

    private Board board;
    private Hand playerHand;
    private Hand computerHand;
    private Deck playerDeck;
    private Deck computerDeck;
    private Scanner sc;
    private Player player; 
    private Player computer;
    private IO IO;
    
    static boolean gameDone = false;
    /**
     * create objects needed
     */
    public Game() {
        this.playerDeck = new Deck();
        this.computerDeck = new Deck();
        this.playerHand = new Hand(playerDeck);
        this.computerHand = new Hand(computerDeck);
        this.sc = new Scanner(System.in);
        this.IO = new IO();
    }
    
    /**
     * start the game with welcome message and different
     * options for the user to choose
     * @throws IOException 
     */
    public void runGame() throws IOException {
        
        System.out.println("Welcome to CUI Card Battler!");
        
        System.out.println("\nHi there! ");
        
        boolean exit = false;
        
        while(!exit) {
            try {
                System.out.print("What would you like to do?\n"
                        + "\n1. Play"
                        + "\n2. View stats"
                        + "\n3. View rules"
                        + "\n4. Exit\n"
                        + "> ");
                int choice = this.sc.nextInt();

                switch(choice) {
                    case 1:
                        startMatch();
                        exit = true;
                        break;
                    case 2:
                        IO.loadStats();
                        System.out.println(IO.loadStats());
                        break;
                    case 3:
                        System.out.println(printRules());
                        break;
                    case 4:
                        System.out.println("Bye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Please input a valid number :)");
                        break;
                }
            
            }
            catch (Exception e) {
                System.out.println("Please input a valid number :)");
                this.sc = new Scanner(System.in);
            }
        }
        
        
    }
    /**
     * 
     * @return rules string
     */
    
    public String printRules() {
        return "The aim of the game is to defeat the opponents cards that are on the board and overpower the "
                + "opponents emperor by lowering their health to 0. Here's how to play!\n"
                + "1. Once a game has started, you will be presented with a hand of 4 cards\n"
                + "2. You can choose which card to play and which card to attack. If there are no cards to "
                + "attack, you can attack the emperor.\n"
                + "3. The computer will take a turn to play its own card and attack you.\n"
                + "4. You and the computer take turns until an emperor reaches 0 health.\n"
                + "The emperor with health remaining is the winner!\n"
                + "\nIMPORTANT DETAILS\n"
                + "- Cost of a card is the top right number on the card. This does not do anything right now"
                + "- The bottom left number is damage\n"
                + "- The bottom right number is health\n"
                + "- One card per turn\n"
                + "- "
                + "- When your deck is empty, no more cards can be drawn.\n\n\n ";
    }
    /**
     * start the match 
     */
    private void startMatch() throws IOException {
        Random random = new Random();
        int rand = random.nextInt(3);
        int emperor = 0;
        boolean leave = false;
        
        System.out.print("\nEnter your name: ");
        this.sc.nextLine();
        String name = this.sc.nextLine();
        
        emperor = IO.loadThisUser(name);
                
        if (emperor != 0) {           
            while (!leave) {
                System.out.print("Would you like the same emperor as last time? (Y/N)\n>");
                String choice = this.sc.nextLine().toUpperCase();
                
                switch(choice) {
                    case "Y":
                        leave = true;
                        break;
                    case "N":
                        System.out.print("\nSo, " + name + ", which Emperor would you like to play as?\n"
                        + "Please enter the corresponding number\n"
                        + "1. Brutus - Extra 5 starting HP"
                        + "\n2. Greg - Nothing extra because Greg is cool enough as it is\n"
                        + "3. Sha'aria - Greg but female (currently)\n"
                        + "> ");
                        emperor = this.sc.nextInt();
                        leave = true;
                        break;
                    default:
                        System.out.println("Please input a valid option!\n");
                        break;
                }
            }
        }
        else {
            System.out.print("\nSo, " + name + ", which Emperor would you like to play as?\n"
                    + "Please enter the corresponding number\n"
                    + "1. Brutus - Extra 5 starting HP"
                    + "\n2. Greg - Nothing extra because Greg is cool enough as it is\n"
                    + "3. Sha'aria - Greg but female (currently)\n"
                    + "> ");
            emperor = this.sc.nextInt();
        }
            
        setPlayer(new Player(name, emperor));
        setComputer(new Player(name, emperor));
        setBoard(new Board(playerHand, this.computer, this.player));
        
        getBoard().printFullBoard();        
        
        while (!gameDone) {
            userTurn();
            computerTurn();
        }       
        
        gameFinish();
    }

    /**
     * user takes their turn
     */
    private void userTurn() {
        Scanner sc = getSc();
        
        boolean equipmentPlayedFlag = false;
        int useChoice = -1;
        int attackWith = -1;
        int attackTarget = -1;
        
        
        
        if (!this.playerHand.isEmpty()) {
            do {
                System.out.print("What card would you like to place?\n> ");
                try {
                    useChoice  = sc.nextInt()-1;
                    equipmentPlayedFlag = placeCard(this.playerHand, this.board.getUserSide(), useChoice);
                    if (!equipmentPlayedFlag)
                        getBoard().printFullBoard();
                }
                catch (Exception e) {
                   // System.out.println(e);
                    System.out.println("That is not a valid choice! Please enter a valid card.");
                    sc = new Scanner(System.in);
                }    
            }
            while (useChoice+1 > this.playerHand.getCurrentHand().length || useChoice < 0);
        }
            
        if (!this.board.getUserSide().getCards().isEmpty() && !equipmentPlayedFlag ) { 
            int displayedSize = this.board.getComputerSide().getCards().size();
            do {
                try {
                    System.out.print("Which card would you like to use to attack?\n> ");
                    attackWith = sc.nextInt()-1;  
                    if (attackWith+1 > this.board.getUserSide().getCards().size()|| attackWith < 0)
                        throw new ArithmeticException();
                }
                  
                catch (Exception e) {
                    System.out.println("That is not a valid choice! Please enter a valid card.");
                    sc = new Scanner(System.in);
                }
            }
            while (attackWith+1 > this.board.getUserSide().getCards().size()|| attackWith < 0);
            
            do {
                try {    
                    if (!this.board.getComputerSide().getCards().isEmpty()) {
                        System.out.print("Which card would you like to attack?\n> ");
                        attackTarget = sc.nextInt()-1;
                        attackCard(this.board.getUserSide(), this.board.getComputerSide(), attackWith, attackTarget);
                    }
                    else {
                        attackEmperor(this.player, attackWith);
                    }
                        
                }
                catch (Exception e) {
                    System.out.println("That is not a valid choice! Please enter a valid card.");
                    sc = new Scanner(System.in);
                }
            }
            while (!attackTargetCheck(attackTarget, displayedSize));
        }
        
        if (!this.computerHand.getDeck().isEmpty())
            if (getTrueLength(this.computerHand) < 4)
                this.computerHand.getCurrentHand()[3] = this.computerHand.getDeck().grab();
        
        getBoard().printFullBoard();
    }
    
    private void computerTurn() {
        boolean equipmentPlayedFlag = false;
        Random random = new Random();
        int randHand = 0;
        if (!this.computerHand.isEmpty()) {    
            randHand = random.nextInt(getTrueLength(this.computerHand));            
            equipmentPlayedFlag = placeCard(this.computerHand, this.board.getComputerSide(), randHand);
        }
               
        if (!this.board.getComputerSide().getCards().isEmpty() && !equipmentPlayedFlag ) {                
            int randComputer = random.nextInt(this.board.getComputerSide().getCards().size());

        if (!this.board.getUserSide().getCards().isEmpty()) {
                int randPlayer = random.nextInt(this.board.getUserSide().getCards().size());
                attackCard(this.board.getComputerSide(), this.board.getUserSide(), randComputer, randPlayer);
            }
            else
                attackEmperor(this.computer, randComputer);
        }
        
        if (!this.playerHand.getDeck().isEmpty())
            if (getTrueLength(this.playerHand) < 4)
                this.playerHand.getCurrentHand()[3] = this.playerHand.getDeck().grab();
        
        getBoard().printFullBoard();
    }
    
    /**
     * place the card
     * @param use
     * @param attack 
     */
    public boolean placeCard(Hand hand, Side side, int use) {
        boolean equipmentPlayedFlag = false;
        
        if (!hand.getCurrentHand()[use].getType().equals("Equipment"))
            side.getCards().add((Unit) hand.getCurrentHand()[use]);
        
        else {
            equipmentPlayedFlag = true;
            equipmentAttack(side.equals(this.board.getUserSide()) ? 
                    this.board.getComputerSide() : this.board.getUserSide(), hand.getCurrentHand()[use].getDamage());
        }
        
        hand.remove(use);
        
        return equipmentPlayedFlag;
    }
    
 
    
    private void attackCard(Side sideFriendly, Side sideEnemy, int attackWith, int attackTarget) {        
        sideEnemy.getCards().get(attackTarget).setHealth(sideEnemy.getCards().
                get(attackTarget).getHealth()-sideFriendly.getCards().get(attackWith).getDamage());
        sideEnemy.getCards().get(attackTarget).update();
        if (sideEnemy.getCards().get(attackTarget).getHealth() <= 0)
                sideEnemy.getCards().remove(attackTarget);
    }

    private void equipmentAttack(Side side, int damage) {
        //deal damage to every card
        for (Unit unit : side.getCards()) {
            unit.setHealth(unit.getHealth()-damage);
            unit.update();
        }
        
        for (Iterator<Unit> iterator = side.getCards().iterator(); iterator.hasNext(); ) {
            Unit value = iterator.next();
            if (value.getHealth() <= 0)
                iterator.remove();
        }   
    }

    private void attackEmperor(Player player, int attackWith) {
        Side side = player.equals(this.player) ? this.board.getUserSide() : this.board.getComputerSide();
        Unit card = side.getCards().get(attackWith);
        
        if (player.equals(this.player))
            this.computer.setHealth(this.computer.getHealth() - card.getDamage());
        else
            this.player.setHealth(this.player.getHealth() - card.getDamage());
        
        if ((player.equals(this.player) ? this.computer.getHealth(): this.player.getHealth()) <= 0)
            gameDone = true;
    }

    public int getTrueLength(Hand hand) {
        int length = 0;
        for(Card pos : hand.getCurrentHand())
            if (pos != null)
               length++;
        return length;
    }
    
    private void gameFinish() throws IOException {
        if (this.player.getHealth() <= 0)
            System.out.println("\nOH NO! You lost! :(");
        else
            System.out.println("\nYAY! You won!");
        
        IO.writeStats();   
        IO.writeUsers(this.player.getName(), this.player.getEmperor());
    }
    
    private boolean attackTargetCheck(int attackTarget, int displayedSize) {
        if (attackTarget+1 > displayedSize|| attackTarget+1 < 0)
            return false;
        if (attackTarget == -1) {
            if (displayedSize != 0)
                return false;
        }
        
        return true;
    }
    
    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the sc
     */
    public Scanner getSc() {
        return sc;
    }

    /**
     * @param computer the computer to set
     */
    public void setComputer(Player computer) {
        this.computer = computer;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }
}