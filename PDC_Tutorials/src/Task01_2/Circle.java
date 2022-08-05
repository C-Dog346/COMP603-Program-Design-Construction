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
public class Circle extends Shape {
    
    private double radius;
    
    public Circle(String shapeName){
        super(shapeName);
    }
    
    /**
     * brain
     */
    @Override
    public void calculateArea(){
       setArea(3.1415*getRadius()*getRadius());
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}

