package Shapes;

/**
 * ThreeDimensionalShape.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a generic three-dimensional shape.
 * This abstract class extends the Shape class and provides a foundation for specific three-dimensional shapes.
 */
public abstract class ThreeDimensionalShape extends Shape {
    
    /**
     * Constructs a ThreeDimensionalShape with a fixed dimension of 3.
     */
    public ThreeDimensionalShape() {
        super(3);
    }

    /**
     * Abstract method to calculate and return the volume of the shape.
     * 
     * @return The volume of the shape.
     */
    public abstract double getVolume();

    /**
     * Abstract method to calculate and return the surface area of the shape.
     * 
     * @return The surface area of the shape.
     */
    public abstract double getSurfaceArea();

    /**
     * Returns a string representation of a three-dimensional shape, detailing its properties such as volume and surface area.
     * 
     * @param shape The specific name of the three-dimensional shape.
     * @return A string representation of the three-dimensional shape.
     */
    @Override
    public String toString(String shape) {
        return "The " + shape +  " has the following properties:" +  
               "\n\tVolume       : " + this.getVolume() +
               "\n\tSurface Area : " + this.getSurfaceArea() +
               "\n\n\n";
    }

    /**
     * Returns a string representation of the three-dimensional shape, detailing its properties such as volume and surface area.
     * @return A string representation of the three-dimensional shape.
     */
    public String getResult() {
        return String.format("Volume         : %.3f%n", this.getVolume()) +
               String.format("Surface Area : %.3f%n", this.getSurfaceArea());
    }
    
}
