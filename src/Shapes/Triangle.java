package Shapes;

/**
 * Triangle.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Triangle, which is a two-dimensional shape.
 * This class extends the TwoDimensionalShape class and provides methods to calculate the area and perimeter of a triangle.
 */
public class Triangle extends TwoDimensionalShape {
    
    /** The first side length of the triangle. */
    private double sideA;

    /** The second side length of the triangle. */
    private double sideB;

    /** The third side length of the triangle. */
    private double sideC;

    /**
     * Constructs a Triangle with the specified side lengths.
     * 
     * @param sideA The first side length of the triangle.
     * @param sideB The second side length of the triangle.
     * @param sideC The third side length of the triangle.
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Calculates and returns the area of the triangle using Heron's formula.
     * 
     * @return The area of the triangle.
     */
    public double getArea() {
        double s = (this.sideA + this.sideB + this.sideC) / 2.0; // semi-perimeter
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC)); // Heron's formula for a triangle
    }

    /**
     * Calculates and returns the perimeter of the triangle.
     * 
     * @return The perimeter of the triangle.
     */
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    /**
     * Returns a string representation of the triangle with its properties.
     * 
     * @return A string representation of the triangle.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
