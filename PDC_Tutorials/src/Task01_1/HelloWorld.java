/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01_1;

/**
 *
 * @author Weihua Li
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
        
        //create a Students instance
        Students s1 = new Students("Leo", 30);
        System.out.println("Student Name: " + s1.getName());
    }

}
