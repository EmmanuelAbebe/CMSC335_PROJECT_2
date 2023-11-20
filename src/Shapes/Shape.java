package Shapes;

/**
 * Shape.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a generic Shape with a specified number of dimensions.
 * This class serves as a base for other specific shape types.
 */
public abstract class Shape {
    
    /** The number of dimensions of the shape. */
    private int numberOfDimensions;

    /**
     * Constructs a Shape with the specified number of dimensions.
     * 
     * @param numberOfDimensions The number of dimensions of the shape.
     */
    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    /**
     * Returns the number of dimensions of the shape.
     * 
     * @return The number of dimensions of the shape.
     */
    public int getNumberOfDimensions() {
        return this.numberOfDimensions;
    }

    /**
     * Returns a string representation of the shape with its properties.
     * 
     * @param shapeName The name of the shape.
     * @return A string representation of the shape.
     */
    public abstract String toString(String shapeName);
}
