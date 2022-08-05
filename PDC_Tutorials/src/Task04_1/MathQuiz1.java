package Task04_1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Shiqing Wu
 */
public class MathQuiz1 {

    public static void main(String[] args) {

        int score = 0;
        int rounds = 3;
        Scanner sc = new Scanner(System.in);
        MathQuiz1 qm = new MathQuiz1();

        while (rounds > 0) {
            double cAnswer = 0d, uAnswer = 0d;
            cAnswer = qm.generateQuestion();
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Your answer is: ");
                String line = sc.nextLine();
                // Exit the game if the user inputs 'x' or 'X'.
                if (line.trim().equalsIgnoreCase("x")) {
                    System.out.println("You got: " + score);
                    System.exit(0);
                }
                try {
                    uAnswer = Double.parseDouble(line);
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid inpit. Please input again.");
                }
            }
            score += qm.checkAnswer(uAnswer, cAnswer);
            rounds--;
        }
        System.out.println("You got: " + score);
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
                operation = "+";
                result = num1 + num2;
                break;
            case 1:
                operation = "-";
                result = num1 - num2;
                break;
            case 2:
                operation = "*";
                result = num1 * num2;
                break;
            case 3:
                operation = "/";
                //Keep assigning a new random number to num2 if num2 is 0.
                while (num2 == 0) {
                    num2 = this.generateNumber(100);
                }
                // In java, the result of an integer divided by an integer is still an integer.
                result = 1d * num1 / num2;
                // Hence, we first let num1 times 1.0 to make num1 become a double type number.
                break;
            default:
                break;
        }
        System.out.println(num1 + operation + num2 + "=?");
        return result;
    }

    public int generateNumber(int range) {
        return (new Random()).nextInt(range);
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

}
