package Shapes;

// import javafx.scene.shape.Shape;

/**
 * Rectangle.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Rectangle, which is a two-dimensional shape.
 * This class extends the TwoDimensionalShape class and provides methods to calculate the area and perimeter of a rectangle.
 */
public class Rectangle extends TwoDimensionalShape {

    /** The width of the rectangle. */
    private double width;

    /** The length of the rectangle. */
    private double length;

    /**
     * Constructs a Rectangle with the specified width and length.
     * 
     * @param width The width of the rectangle.
     * @param length The length of the rectangle.
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructs a Rectangle with default values for width and length (both set to 1).
     */
    public Rectangle() {
        this(1, 1);
    }

    /**
     * Calculates and returns the area of the rectangle.
     * 
     * @return The area of the rectangle.
     */
    public double getArea() {
        return this.width * this.length;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     * 
     * @return The perimeter of the rectangle.
     */
    public double getPerimeter() {
        return 2 * this.width + 2 * this.length;
    }

    /**
     * Returns a string representation of the rectangle with its properties.
     * 
     * @return A string representation of the rectangle.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }

    // Implementation of the abstract method from TwoDimensionalShape class
    public javafx.scene.shape.Rectangle fxRectangle() {
        // Creates and returns a JavaFX Rectangle
        javafx.scene.shape.Rectangle fxRectangle = new javafx.scene.shape.Rectangle();
        fxRectangle.setWidth(this.width);
        fxRectangle.setHeight(this.length);

        // Additional styling can be added here if needed
        // For example, setting the fill, stroke, etc.

        return fxRectangle;
    }
}
