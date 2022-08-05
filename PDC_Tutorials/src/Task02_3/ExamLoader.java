/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task02_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Callum
 */
public class ExamLoader {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("./resources/T02_scores.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/T02_scores.txt", true));
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please input a students name.");
        String student = sc.nextLine();
       
        System.out.println("Please input his/her mark.");
        int mark = sc.nextInt();
        
        boolean breakCheck = false;
        
        String line;
        while ((line = br.readLine()) != null && breakCheck != true) {

            StringTokenizer st = new StringTokenizer(line, " ");
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(student)) {
                    
                    System.out.println("Do you want to overwrite the record? Y/N");
                    sc.nextLine();
                    String answer = sc.nextLine();
                    
                    switch (answer){
                        case "Y":
                            
                            String x = st.nextToken();
                            
                            Path path = Paths.get("./resources/T02_scores.txt");

                            String content = new String(Files.readAllBytes(path));
                            content = content.replaceAll(student +" "+ x, student + " "+ Integer.toString(mark));
                            System.out.println(x);
                            System.out.println(Integer.toString(mark));
                            Files.write(path, content.getBytes());

                            breakCheck = true;
                            break;
                        case "N":
                            break;
                        default:
                            System.out.println("Wrong input");
                            break;
                    } 
                }
            }
        } 
        
        if (breakCheck != true){
            bw.newLine();
            bw.append(student+" "+mark);
            br.close();
            bw.close();
        }
    }  
    
    
}
    
    
 
