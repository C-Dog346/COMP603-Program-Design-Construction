/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Callum
 */
public class FileWork {
    
    private String username;
    final Path path = Paths.get("./resources/T04_users.txt");
    
    public boolean checkUsername(String username) throws FileNotFoundException, IOException {
    
        try (BufferedReader br = new BufferedReader(new FileReader("./resources/T04_users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(username))
                    return true;
            }
        }
        return false;
    }
    
    public void saveUsernameAndScore(String username, int score) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/T04_users.txt", true))) {
            bw.append(username + " " + score);
            bw.newLine();
        }
    }
    
    public void overwriteScore(String username, int score) throws IOException {
        String content;
        content = new String(Files.readAllBytes(path));
        
        try (BufferedReader br = new BufferedReader(new FileReader("./resources/T04_users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (username.equals(line.split(" ")[0])) {
                    content = content.replaceAll(line.split(" ")[0] +" "+ line.split(" ")[1], line.split(" ")[0] + " "+ Integer.toString(score+ Integer.valueOf(line.split(" ")[1])));
                    Files.write(path, content.getBytes());
                }
            }   
        }  
    }
    
    public boolean returnScore(String username) throws IOException {
        String content = new String(Files.readAllBytes(path));
        try (BufferedReader br = new BufferedReader(new FileReader("./resources/T04_users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (username.equals(line.split(" ")[0]))
                    return true;
            }
        }
        return false;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
