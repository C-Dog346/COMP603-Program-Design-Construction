
package Task11_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Question {

    //common attributes
    public String questionText;
    public Object questionAnswer;
    public int questionScore;

    //for quiz question
    private int num1 = 0;
    private int num2 = 0;
    private String mathOp;

    //for multiple choice question
    private String questionOptions;
    private String explanation;

    //some question information
    private String createdBy;
    private Date createdOn;

    //type of the question : 0 means quiz, 1 denotes multiple choice
    private int questionType;

    public Question() {

        //randomly generate a number which represents the question type
        this.questionType = generateNumber(2);

        if (questionType == 0) {
            this.num1 = this.generateNumber(100);
            this.num2 = this.generateNumber(100);
            this.mathOp = this.generateOperator();
            while (mathOp.equals("/") && num2 == 0) {
                this.num2 = this.generateNumber(100);
            }

            //the attributes inherited from the parent: QuestionAbstract
            this.questionText = num1 + mathOp + num2 + "= ?";
            this.questionAnswer = getResult() + "";
            this.questionScore = 5;
            this.createdBy = getHostName();
            this.createdOn = new Date();

        } else if (questionType == 1) {
            //Obtain all the questions from text file
            List<String> questionList = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader("./resources/T11_ml_question.txt"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    questionList.add(line.trim());
                }
                br.close();
            } catch (IOException ex) {
                System.err.println("IOException Error: " + ex.getMessage());
            }

            String[] questionArray = questionList.get(generateNumber(questionList.size())).split("\\|");
            this.questionText = questionArray[0];
            this.questionOptions = questionArray[1];
            this.questionAnswer = questionArray[2];
            this.explanation = questionArray[3];
            this.questionScore = 10;
            this.createdBy = getHostName();
            this.createdOn = new Date();
        }
    }

    public boolean checkAnswer(String userAnswer) {
        boolean result = false;

        if (this.questionType == 0) {
            double userAnswerInt = 0;
            try {
                userAnswerInt = Double.parseDouble(userAnswer);
                if (Math.abs(userAnswerInt - getResult()) < 0.1) {
                    result = true;
                }
            } catch (Exception ex) {
                //System.out.println("User's input is invalid!");
            }
        } else if (this.questionType == 1) {
            if (this.questionAnswer.toString().trim().
                    equalsIgnoreCase(userAnswer.trim())) {
                result = true;
            }
        }
        return result;
    }

    public int generateNumber(int range) {
        Random generator = new Random();
        int i = generator.nextInt(range);
        return i;
    }

    public String generateOperator() {
        Random generator = new Random();
        int i = generator.nextInt(4);
        String mo;
        switch (i) {
            case 0:
                mo = "+";
                break;
            case 1:
                mo = "-";
                break;
            case 2:
                mo = "*";
                break;
            default:
                mo = "/";
                break;
        }
        return mo;

    }

    public double getResult() {
        double result = 0;
        switch (mathOp) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;
            default:
                result = 1.0 * num1 / num2;
                break;
        }
        return result;
    }

    public void printQuestion() {

        if (questionType == 0) {
            System.out.println("Quiz Question: " + this.questionText);
            System.out.println("Your answer is: ");
        } else if (questionType == 1) {
            System.out.println("Multiple Choice Question: " + this.questionText);
            System.out.println(this.questionOptions);
            System.out.println("Your answer is: ");
        } else {

        }

    }

    public void printQuestionInfo() {

        if (questionType == 0) {
            System.out.println("Quiz Question: " + this.questionText);
            System.out.println("The correct answer is: " + this.questionAnswer);
            System.out.println("The score of this question weights: " + this.questionScore);
            System.out.println("Created by " + this.createdBy + ", Created on " + this.createdOn);

        } else if (questionType == 1) {
            System.out.println("Multiple Choice Question: " + this.questionText);
            System.out.println(this.questionOptions);
            System.out.println("The correct answer is: " + this.questionAnswer);
            System.out.println("Explanation: " + this.explanation);
            System.out.println("The score of this question weights: " + this.questionScore);
            System.out.println("Created by " + this.createdBy + ", Created on " + this.createdOn);
        } else {

        }
    }

    private String getHostName() {
        String hostname = "Unknown";

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Question
                && ((Question) obj).questionText.equals(this.questionText);
    }

    @Override
    public int hashCode() {
        String s = this.questionText;
        //System.out.println(s);
        return s.hashCode();
    }
}
