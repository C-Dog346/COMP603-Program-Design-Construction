/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01_2;

import java.util.Scanner;

/**
 *
 * @author Callum
 */
public class ShapeCalculator1 {

    public static void main(String[] args) {

        System.out.println("Please select:");
        System.out.println("(1) Rectangle");
        System.out.println("(2) Circle");
        System.out.println("(3) Square");

        Scanner sc = new Scanner(System.in);
        
        boolean exit = false;
        
        while (exit !=  true)
        try {
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    Rectangle recObj = new Rectangle(12, 16.5);
                    recObj.setWidth(12);
                    recObj.setLength(16.5);
                    recObj.calculateArea();
                    recObj.printInfo();
                    break;
                    
                case 2:
                    Circle cirObj = new Circle("Circle");
                    cirObj.setRadius(2.5);
                    cirObj.calculateArea();
                    cirObj.printInfo();
                    cirObj.setName("bnob");
                    cirObj.printInfo();
                    break;
                    
                case 3:
                    Square squObj = new Square(3.3);
                    squObj.setLength(3.3);
                    squObj.calculateArea();
                    squObj.printInfo();
                    break;
                    
                default:
                    System.out.println("Wrong input");
                    exit = true;
                    break;
            }
        }
        
        catch (Exception InputMismatchException) {
            System.out.println("Invalid input. Not an integer");
            exit = true;
        }        
    }
}
