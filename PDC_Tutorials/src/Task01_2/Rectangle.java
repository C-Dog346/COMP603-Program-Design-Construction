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
public class Rectangle extends Shape {
    
    private double width;
    private double length;
    
    
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }
    
    public Rectangle(double side) {
        super("Rectangle");
        this.length = side;
        this.width = side;
    }
    
    /**
     * brain
     */
    @Override
    public void calculateArea(){
        setArea(width*length);
    }

    /**
     * @return the radius
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the radius to set
     */
    public void setWidth(double radius) {
        this.width = radius;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }
    
    public double gtArea(){
       return this.area;
    }
    
    public void setArea(double area){
       this.area = area;
    }
}

