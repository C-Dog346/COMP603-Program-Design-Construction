/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04_1;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Callum
 */

public class Question {
    
    private ArrayList<String> questionList = new ArrayList<String>();
    
    private int generateNumber(int range) {
        return (new Random()).nextInt(range);
    }
    
    public double generateQuestion() {
        //Generate two numbers between 0 to 100 randomly.
        int num1 = this.generateNumber(100);
        int num2 = this.generateNumber(100);
        String operation = "";
        double result = 0d;

        //Determine the operation randomly, and calculate the result.
        switch (this.generateNumber(4)) {
            case 0:
                do {
                    operation = "+";
                    if (!this.checkDupe(num1, num2, operation)) {
                        result = num1 + num2;
                    }
                    else {
                        num1 = this.generateNumber(100);
                        num2 = this.generateNumber(100);
                    }
                }
                while (this.checkDupe(num1, num2, operation));
                
                break;
            case 1:
                do {
                    operation = "-";
                    if (!this.checkDupe(num1, num2, operation)) {
                        result = num1 - num2;
                    } 
                }
                while (this.checkDupe(num1, num2, operation));
               
                break;
            case 2:
                do {
                    operation = "*";
                    if (!this.checkDupe(num1, num2, operation)) {
                        result = num1 * num2;
                    }                     
                }
                while (this.checkDupe(num1, num2, operation));

                break;
            case 3:
                do {
                    operation = "/";
                    if (!this.checkDupe(num1, num2, operation)) {
                    //Keep assigning a new random number to num2 if num2 is 0.
                        while (num2 == 0) {
                            num2 = this.generateNumber(100);
                        }
                    // In java, the result of an integer divided by an integer is still an integer.
                        result = 1d * num1 / num2;
                    // Hence, we first let num1 times 1.0 to make num1 become a double type number.
                    } 
                }
                while (this.checkDupe(num1, num2, operation));
                break;
            default:
                break;
        }
        
        String question = num1 + operation + num2 + "=?";
        this.questionList.add(question);
        
        System.out.println(question);
        return result;
    }
    
    public int checkAnswer(double uAnswer, double cAnswer) {
        int reward = 0;
        //Check the answer based on the absolute value of the difference between uAnswer and cAnswer. 
        if (Math.abs(cAnswer - uAnswer) < 0.0001) {
            reward = 10;
            System.out.println("Correct!");
        } else {
            reward = -10;
            System.out.println("Wrong!");
        }
        return reward;
    }

    private boolean checkDupe(int num1, int num2, String operation) {
        String compareQuestion =  num1 + operation + num2 + "=?";
        
        return this.questionList.contains(compareQuestion);
    }
    
}
