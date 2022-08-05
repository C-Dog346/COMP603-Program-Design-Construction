/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01_2;

/**
 *
 * @author Callum
 */
public class Square extends Rectangle{
    
    public double length;
    
    public Square(double length) {
       super(length);
       this.length = length;

    }
   
    @Override
    public void calculateArea(){

        this.area = length*length;
    }
    /**
     * @return the length
     */
    @Override
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    @Override
    public void setLength(double length) {
        this.length = length;
    }
}
