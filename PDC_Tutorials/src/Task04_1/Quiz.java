/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04_1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Callum
 */
public class Quiz {

    
    private int rounds;
    private int score;
    private double cAnswer, uAnswer ;
    
    final Scanner sc = new Scanner(System.in);
    final Question q = new Question();
    final FileWork f = new FileWork();
    
    public Quiz(int rounds) {
        this.rounds = rounds;
        this.cAnswer = 0d;
        this.uAnswer = 0d;
    }

    public int quizUser() {
            
            
            setcAnswer(q.generateQuestion());
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Your answer is: ");
                String line = sc.nextLine();                // Exit the game if the user inputs 'x' or 'X'.
                if (line.trim().equalsIgnoreCase("x")) {
                    System.out.println("You got: " + getScore());
                    System.exit(0);
                }
                try {
                    setuAnswer(Double.parseDouble(line));
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid inpit. Please input again.");
                }
            }    
        return 0;
    }

    /**
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @param rounds the rounds to set
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the cAnswer
     */
    public double getcAnswer() {
        return this.cAnswer;
    }

    /**
     * @param cAnswer the cAnswer to set
     */
    public void setcAnswer(double cAnswer) {
        this.cAnswer = cAnswer;
    }
    
    /**
     * @return the uAnswer
     */
    public double getuAnswer() {
        return this.uAnswer;
    }

    /**
     * @param uAnswer the uAnswer to set
     */
    public void setuAnswer(double uAnswer) {
        this.uAnswer = uAnswer;
    }
    
    public void enterUsername() throws IOException {
        System.out.println("Please enter your username: ");
        String line = sc.nextLine();
           
        f.setUsername(line);  
    }
    
    public void updateScore() throws IOException {   
        String username = f.getUsername();
        
        if (f.returnScore(username))
            f.overwriteScore(username, this.score);
        else {
            f.saveUsernameAndScore(username, this.score);
        }
    }
}

