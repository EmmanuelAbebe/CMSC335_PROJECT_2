package Shapes;

/**
 * Represents a Circle which is a type of TwoDimensionalShape.
 * This class provides methods to get the area, perimeter, and other properties of a circle.
 *
 * @author Emmanuel Abebe
 */
public class Circle extends TwoDimensionalShape {
    
    /** The radius of the circle. */
    private double radius;

    /**
     * Constructs a Circle with the specified radius.
     * 
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructs a Circle with default values.
     * Default radius is 1.
     */
    public Circle() {
        this(1);
    }

    /**
     * Calculates and returns the area of the circle.
     * 
     * @return The area of the circle.
     */
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    /**
     * Calculates and returns the perimeter of the circle.
     * 
     * @return The perimeter of the circle.
     */
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }


    /**
     * Returns a string representation of the circle with its properties.
     * 
     * @return A string representation of the circle.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}