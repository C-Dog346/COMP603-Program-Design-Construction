package Task04_1;

import java.io.IOException;

/**
 *
 * @author Shiqing Wu
 */
public class MathQuiz2 {

    public static void main(String[] args) throws IOException {

        int rounds = 10;
        Quiz newQuiz = new Quiz(rounds);
        
        newQuiz.enterUsername();
        
        while (newQuiz.getRounds() > 0) {
            newQuiz.quizUser();
            newQuiz.setScore(newQuiz.getScore() + newQuiz.q.checkAnswer(newQuiz.getuAnswer(), newQuiz.getcAnswer()));
            newQuiz.setRounds(newQuiz.getRounds() - 1);
        }   
        
        System.out.println("You got: " + newQuiz.getScore());
        
        newQuiz.updateScore();
    }
}
