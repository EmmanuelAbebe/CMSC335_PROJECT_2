package Shapes;


/**
 * TwoDimensionalShape.java
 * Date: Oct 31, 2023
 * Author: Emmanuel Abebe
 * 
 * Represents a generic two-dimensional shape.
 * This abstract class extends the Shape class and provides a foundation for specific two-dimensional shapes.
 */
public abstract class TwoDimensionalShape extends Shape {
    
    /**
     * Constructs a TwoDimensionalShape with a fixed dimension of 2.
     */
    public TwoDimensionalShape() {
        super(2);
    }

    /**
     * Abstract method to calculate and return the area of the shape.
     * 
     * @return The area of the shape.
     */
    public abstract double getArea();

    /**
     * Abstract method to calculate and return the perimeter of the shape.
     * 
     * @return The perimeter of the shape.
     */
    public abstract double getPerimeter();

    /**
     * Returns a string representation of the two-dimensional shape, detailing its properties such as area and perimeter.
     * 
     * @param shape The specific name of the two-dimensional shape.
     * @return A string representation of the two-dimensional shape.
     */
    @Override
    public String toString(String shape) {
        return "The " + shape +  " has the following properties:" +  
               "\n\tArea      : " + this.getArea() +
               "\n\tPerimeter : " + this.getPerimeter() +
               "\n\n\n";
    }

    /**
     * Returns a string representation of the two-dimensional shape, detailing its properties such as area and perimeter.
     * @return A string representation of the two-dimensional shape.
     */
    public String getResult() {
        return String.format("Area         : %.3f%n", this.getArea()) +
               String.format("Perimeter : %.3f%n", this.getPerimeter());
    }
}
