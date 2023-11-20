package Shapes;

/**
 * Torus.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Torus, which is a three-dimensional shape.
 * This class extends the ThreeDimensionalShape class and provides methods to calculate the volume and surface area of a torus.
 */
public class Torus extends ThreeDimensionalShape {

    /** The minor radius of the torus (radius of the tube). */
    private double minorRadius;

    /** The major radius of the torus (distance from the center of the tube to the center of the torus). */
    private double majorRadius;

    /**
     * Constructs a Torus with the specified minor and major radii.
     *
     * @param minorRadius The minor radius of the torus.
     * @param majorRadius The major radius of the torus.
     */
    public Torus(double minorRadius, double majorRadius) {
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
    }

    /**
     * Calculates and returns the volume of the torus.
     * 
     * @return The volume of the torus.
     */
    public double getVolume() {
        return 2 * Math.pow(Math.PI, 2) * this.majorRadius * Math.pow(this.minorRadius, 2);
    }
    
    /**
     * Calculates and returns the surface area of the torus.
     * 
     * @return The surface area of the torus.
     */
    public double getSurfaceArea() {
        return 4 * Math.pow(Math.PI, 2) * this.majorRadius * this.minorRadius;
    }

    /**
     * Returns a string representation of the torus with its properties.
     * 
     * @return A string representation of the torus.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
