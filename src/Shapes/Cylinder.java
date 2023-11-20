package Shapes;

/**
 * Cylinder.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Cylinder, which is a three-dimensional shape.
 * This class extends the ThreeDimensionalShape class and provides methods to calculate the volume and surface area of a cylinder.
 */
public class Cylinder extends ThreeDimensionalShape {
    
    /** The height of the cylinder. */
    private double height;

    /** The base radius of the cylinder. */
    private double radius;

    /**
     * Constructs a Cylinder with the specified height and base radius.
     * 
     * @param height The height of the cylinder.
     * @param radius The base radius of the cylinder.
     */
    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    /**
     * Constructs a Cylinder with default values for height and base radius (both set to 1).
     */
    public Cylinder() {
        this(1, 1);
    }

    /**
     * Calculates and returns the volume of the cylinder.
     * 
     * @return The volume of the cylinder.
     */
    public double getVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    /**
     * Calculates and returns the surface area of the cylinder.
     * 
     * @return The surface area of the cylinder.
     */
    public double getSurfaceArea() {
        return 2 * Math.PI * Math.pow(this.radius, 2) + 2 * Math.PI * this.radius * this.height;
    }

    /**
     * Returns a string representation of the cylinder with its properties.
     * 
     * @return A string representation of the cylinder.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
