/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task03_2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Callum
 */
public class MathQuizProgram {
    private static double answer;
    private static int score;
    
    public static void main(String[] args) {       
        boolean exitCheck = false;
        String input = "";
        
        setScore(0);
        
        do {
            String question = question();
            
            System.out.println("Score: " + score + "\n" + question);
                          
            Scanner sc = new Scanner(System.in);
            try {
                input = sc.nextLine();
                
                if (Integer.parseInt(input) == getAnswer()) {
                    setScore(getScore() + 10);
                }
                else {
                    setScore(getScore() - 10);
                }
            }
            catch (NumberFormatException e) {
                if (!"x".equals(input.toLowerCase()))
                    System.out.println("\nPlease enter a number\n");
                else
                    System.out.println("Exiting...");
            }
        }
        while(!"x".equals(input));      
    } 
    
    public static String question() {
        Random rand = new Random();
        int upper = 101;
        double randOne = rand.nextInt(upper);
        double randTwo = rand.nextInt(upper);
        char operator = 0;

        switch (rand.nextInt(4)){
        case 0: operator = '+';
                setAnswer(randOne+randTwo);
                break;
        case 1: operator = '-';
                setAnswer(randOne-randTwo);
                break;
        case 2: operator = '*';
                setAnswer(randOne*randTwo);
                break;
        case 3: operator = '/';
                setAnswer(randOne/randTwo);
                break;
        default:
            break;
        }
        
        return randOne + " " + operator + " " + randTwo + " = ?";
    }

    /**
     * @return the answer
     */
    public static double getAnswer() {
        return answer;
    }

    /**
     * @param aAnswer the answer to set
     */
    public static void setAnswer(double aAnswer) {
        answer = aAnswer;
    }

    /**
     * @return the score
     */
    public static int getScore() {
        return score;
    }

    /**
     * @param aScore the score to set
     */
    public static void setScore(int aScore) {
        score = aScore;
    }
}
