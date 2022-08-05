/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task02_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Callum
 */
public class TextReverser {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       /* String str = "abc,,,,,dec. xyz:txt*****aaa.bbb";
        Scanner sc = new Scanner();
        sc.useDelimiter(",,*");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }*/
       
     
        try {
            BufferedReader br = new BufferedReader(new FileReader("./resources/T02_input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/T02_input_2.txt"));
            // Create a variable to store a line
            String line = "";
            while ((line = br.readLine()) != null) {
                //process the text for each line
                line = line.toUpperCase();
                System.out.println(line);
                bw.append(line);
                bw.newLine();
            }
            br.close();
            bw.close();
            } 

        catch (IOException ex) {
            System.err.println("IOException Error: " + ex.getMessage());
        }
        
        File out = new File("T02_output.txt");
        RandomAccessFile raf = new RandomAccessFile(out, "rw");
        File in = new File("./resources/T02_input_2.txt");
        FileInputStream f = new FileInputStream(in);
       
       try {
            Reader r = new InputStreamReader(f);
            
            char[] buff = new char[1];
            long position = in.length();
                    
            while((r.read(buff))>-1) {
                Character c = buff[0];
                String s = c+"";
                byte[] bBuff = s.getBytes();
                
                int x = new BigInteger(bBuff).intValue();
                
                if (x < 123 && x > 63 || x == 13){
                    if (x < 97 && x > 90){
                        
                    }
                    /*else  if (x == 13){
                        position = position-bBuff.length;
                        raf.seek(position);
                        raf.write(bBuff);
                    }*/
                    else
                    {
                        position = position-bBuff.length;
                        raf.seek(position);
                        raf.write(bBuff);
                    }
                   
                }
                
                else{
                    
                }
                
                
            }

            System.out.println("... written to T02_output.txt.");

            //see what happens without closing the outputsream? 
            //outputStream.close();
        }
        
        catch (IOException e) {
        } 
       
        finally {
            // clean up
            try {
                f.close();
            } 
            catch (IOException e2) {
            }
            try {
                raf.close();
            } 
            catch (IOException e2) {
            }
        }
    }
}
