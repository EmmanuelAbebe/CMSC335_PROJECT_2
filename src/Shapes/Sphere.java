package Shapes;

/**
 * Sphere.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a Sphere, which is a three-dimensional shape.
 * This class extends the ThreeDimensionalShape class and provides methods to calculate the volume and surface area of a sphere.
 */
public class Sphere extends ThreeDimensionalShape {
    
    /** The radius of the sphere. */
    private double radius;

    /**
     * Constructs a Sphere with the specified radius.
     * 
     * @param radius The radius of the sphere.
     */
    public Sphere(double radius) {
        this.radius = radius;
    }

    /**
     * Constructs a Sphere with a default radius of 1.
     */
    public Sphere() {
        this(1);
    }

    /**
     * Calculates and returns the volume of the sphere.
     * 
     * @return The volume of the sphere.
     */
    public double getVolume() {
        return (4.0/3) * Math.PI * Math.pow(this.radius, 3);
    }

    /**
     * Calculates and returns the surface area of the sphere.
     * 
     * @return The surface area of the sphere.
     */
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Returns a string representation of the sphere with its properties.
     * 
     * @return A string representation of the sphere.
     */
    @Override
    public String toString() {
        return super.toString(getClass().getSimpleName());
    }
}
