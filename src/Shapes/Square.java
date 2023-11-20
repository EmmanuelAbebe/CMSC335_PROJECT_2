package Shapes;

/**
 * Square.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Square, which is a two-dimensional shape.
 * This class extends the TwoDimensionalShape class and provides methods to calculate the area and perimeter of a square.
 */
public class Square extends TwoDimensionalShape {
    
    /** The length of one side of the square. */
    private double sideLength;

    /**
     * Constructs a Square with the specified side length.
     * 
     * @param sideLength The length of one side of the square.
     */
    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Constructs a Square with a default side length of 1.
     */
    public Square() {
        this(1);
    }

    /**
     * Calculates and returns the area of the square.
     * 
     * @return The area of the square.
     */
    public double getArea() {
        return Math.pow(this.sideLength, 2);
    }

    /**
     * Calculates and returns the perimeter of the square.
     * 
     * @return The perimeter of the square.
     */
    public double getPerimeter() {
        return 4 * this.sideLength;
    }

    /**
     * Returns a string representation of the square with its properties.
     * 
     * @return A string representation of the square.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
