package Utility;

/**
 * Provides static methods for validating input values for various shapes.
 * This class includes methods to check general conditions such as non-negativity
 * and specific conditions for shapes like triangles and tori.
 */
public class InputValidator {

    /**
     * Validates that all provided input values are non-negative.
     * Additionally, if three inputs are provided, it checks if they can form a triangle.
     * 
     * @param inputs Array of input values to be validated.
     * @throws NumberFormatException If any input is negative or triangle conditions are not met.
     */
    public static void InputCheck(double... inputs){
        for (double input : inputs){
            if (input < 0) {
                throw new NumberFormatException("\n(Hint): Inputs must be non-negative");
            }
        }

        if (inputs.length == 3) {
            CheckTrianlgeInput(inputs[0], inputs[1], inputs[2]);
        }
    }

    /**
     * Checks if the given sides can form a valid triangle.
     * The sum of the lengths of any two sides must be greater than the third side.
     * 
     * @param a Length of the first side of the triangle.
     * @param b Length of the second side of the triangle.
     * @param c Length of the third side of the triangle.
     * @throws NumberFormatException If the inputs cannot form a valid triangle.
     */
    public static void CheckTrianlgeInput(double a, double b, double c){
        if (!(a + b > c && a + c > b && b + c > a)){
            throw new NumberFormatException("\n(Hint): not a triangle, the sum of two smaller sides of a triangle must be less than the largest side");
        }
    }

    /**
     * Validates the radii for a torus shape.
     * The minor radius must be less than the major radius.
     * 
     * @param radii Array containing the minor radius (first element) and the major radius (second element).
     * @throws NumberFormatException If the minor radius is not less than the major radius.
     */
    public static void CheckTorusInputs(double... radii){
        if (radii[0] >= radii[1]) throw new NumberFormatException("\n(Hint): Minor radius must be less than Major radius");
    }
}
