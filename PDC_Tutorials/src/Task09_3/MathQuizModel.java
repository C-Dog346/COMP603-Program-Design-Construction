/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task09_3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Callum
 */
public class MathQuizModel extends Observable {

    private Connection conn = null;
    private final String url = "jdbc:derby:PlayerDB;create=true";  //url of the DB host
    private final String dbusername = "pdc";  //your DB username
    private final String dbpassword = "pdc";   //your DB password
    
    private String username;
    private String password;
    private int score = 0;
    int answer = 0;

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            
            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            System.out.println("DATABASE MADE");
            //statement.executeUpdate("INSERT INTO " + tableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
            statement.close();

        }
        catch (Throwable e) {
            System.out.println("error");
        }
    }    

    private boolean checkName(String username, String password) {
        boolean userCheck = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                if (password.compareTo(pass) == 0) {
                    score = rs.getInt("score");
                    userCheck = true;
                }
                else {
                    userCheck = false;
                }
            }
            else {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                userCheck = true;

            }

        }
        catch (SQLException ex) {
            Logger.getLogger(MathQuizGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userCheck;
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex) {
        }
        return flag;
    }
    
    public void startQuiz() {
        newQuestion();
        setChanged();
        notifyObservers("Start quiz");
    }
    
    public void next(JTextField cSol) {
        System.out.println("You clicked the next button");
        String userAnswer = cSol.getText();
        if (userAnswer.compareTo(answer + "") == 0) {
            score += 10;
            newQuestion();
        }
        else {
            score -= 10;
            newQuestion();
        }
        System.out.println(score);            
    }
    
    public void quit(JTextField cSol) {
        System.out.println("You clicked the quit button");
        //String userAnswer = cSol.getText();

        quitGame();
    }
        
    public void login(JTextField uField, JTextField pField) {
            System.out.println("You clicked the login button");
            this.username = uField.getText();
            this.password = pField.getText();
            if (this.username != null && this.password != null) {
                if (checkName(this.username, this.password));
                {
                    startQuiz();
                }
            }
            setChanged();
            notifyObservers("Logged in");
    }

    private void newQuestion() {
        int num1 = getNumber();
        int num2 = getNumber();
        this.answer = num1 + num2;
        
        int[] numbers = new int[3];
        numbers[0] = num1;
        numbers[1] = num2;
        numbers[2] = this.answer;
        setChanged();
        notifyObservers(numbers);
    }

    private int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }

    private void quitGame() {
        Statement statement;
        try {
            statement = this.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + this.score + " WHERE userid='" + this.username + "'");
            System.out.println(this.username + this.score);
            setChanged();
            notifyObservers(this.score);
        }
        catch (SQLException ex) {
            Logger.getLogger(MathQuizGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}