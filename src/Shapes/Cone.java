package Shapes;

/**
 * Cone.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Cone, which is a three-dimensional shape.
 * This class extends the ThreeDimensionalShape class and provides methods to calculate the volume and surface area of a cone.
 */
public class Cone extends ThreeDimensionalShape {

    /** The height of the cone. */
    private double height;

    /** The base radius of the cone. */
    private double radius;

    /**
     * Constructs a Cone with the specified height and base radius.
     * 
     * @param height The height of the cone.
     * @param radius The base radius of the cone.
     */
    public Cone(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    /**
     * Constructs a Cone with default values for height and base radius (both set to 1).
     */
    public Cone() {
        this(1, 1);
    }

    /**
     * Calculates and returns the volume of the cone.
     * 
     * @return The volume of the cone.
     */
    public double getVolume() {
        return (1/3.0) * Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    /**
     * Calculates and returns the surface area of the cone.
     * 
     * @return The surface area of the cone.
     */
    public double getSurfaceArea() {
        return Math.PI * this.radius * ( this.radius + Math.hypot(this.height, this.radius) );
    }

    /**
     * Returns a string representation of the cone with its properties.
     * 
     * @return A string representation of the cone.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
