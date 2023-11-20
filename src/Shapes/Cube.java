package Shapes;

/**
 * Cube.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Cube, which is a three-dimensional shape.
 * This class extends the ThreeDimensionalShape class and provides methods to calculate the volume and surface area of a cube.
 */
public class Cube extends ThreeDimensionalShape {

    /** The side length of the cube. */
    private double sideLength;

    /**
     * Constructs a Cube with the specified side length.
     * 
     * @param sideLength The side length of the cube.
     */
    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Constructs a Cube with a default side length of 1.
     */
    public Cube() {
        this(1);
    }

    /**
     * Calculates and returns the volume of the cube.
     * 
     * @return The volume of the cube.
     */
    public double getVolume() {
        return Math.pow(this.sideLength, 3);
    }

    /**
     * Calculates and returns the surface area of the cube.
     * 
     * @return The surface area of the cube.
     */
    public double getSurfaceArea() {
        return 6 * Math.pow(this.sideLength, 2);
    }

    /**
     * Returns a string representation of the cube with its properties.
     * 
     * @return A string representation of the cube.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
