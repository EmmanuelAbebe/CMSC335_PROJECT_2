package Utility;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.shape.Shape3D;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;
import java.util.List;



/**
 * Manages the shape-related UI and operations in the application.
 * This includes updating UI elements for shape parameter input,
 * rendering shapes, and invoking shape calculations.
 */
public class ShapeManager {
    // Class/Instance variables with JavaDocs
    private VBox parameterFields; // Container for input fields
    private List<TextField> inputFields; // List of text fields for shape parameters
    private Label resultLabel; // Label to display calculation results
    private ShapeDrawer shapeDrawer; // Utility to draw shapes on canvas
    private Canvas shapeCanvas; // Canvas for drawing 2D shapes
    private Group shape3DGroup; // Group for adding 3D shapes
    private SubScene shape3DSubScene; // Subscene for rendering 3D shapes
    private PointLight pointLight; // Light source for 3D shapes
    private PerspectiveCamera camera; // Camera for 3D shape viewing



    /**
     * Constructor to initialize the ShapeManager with necessary UI components and utilities.
     * 
     * @param parameterFields VBox to contain parameter input fields.
     * @param resultLabel Label to display results.
     * @param shapeDrawer Utility to draw shapes.
     * @param shapeCanvas Canvas for drawing 2D shapes.
     * @param shape3DGroup Group for adding 3D shapes.
     * @param shape3DSubScene Subscene for rendering 3D shapes.
     * @param pointLight Light source for 3D shapes.
     * @param camera Camera for viewing 3D shapes.
     */
    public ShapeManager(VBox parameterFields, Label resultLabel, ShapeDrawer shapeDrawer, Canvas shapeCanvas, Group shape3DGroup, SubScene shape3DSubScene, PointLight pointLight, PerspectiveCamera camera) {
        this.parameterFields = parameterFields;
        this.resultLabel = resultLabel;
        this.shapeDrawer = shapeDrawer;
        this.shapeCanvas = shapeCanvas;
        this.shape3DGroup = shape3DGroup;
        this.shape3DSubScene = shape3DSubScene;
        this.inputFields = new ArrayList<>();
        this.pointLight = pointLight;
        this.camera = camera;
    }


    /**
     * Retrieves the VBox containing parameter input fields for shapes.
     * 
     * @return The VBox containing text fields for shape parameters.
     */
    public VBox getParameterFields() {
        return parameterFields;
    }


    /**
     * Retrieves the Label used for displaying calculation results.
     * 
     * @return The Label used to show results of shape computations.
     */
    public Label getResultLabel() {
        return resultLabel;
    }



    /**
     * Updates the UI representation based on the selected shape type.
     * Switches between 2D and 3D shape rendering.
     * 
     * @param shape The name of the shape to be represented.
     */
    public void updateShapeRepresentation(String shape) {
        if (is3DShape(shape)) {
            draw3DShape(shape);
            parameterFields.getChildren().remove(shapeCanvas);
            if (!parameterFields.getChildren().contains(shape3DSubScene)) {
                parameterFields.getChildren().add(shape3DSubScene);
            }
        } else {
            shapeDrawer.draw2DShape(shape);
            parameterFields.getChildren().remove(shape3DSubScene);
            if (!parameterFields.getChildren().contains(shapeCanvas)) {
                parameterFields.getChildren().add(shapeCanvas);
            }
        }
    }

    /**
     * Updates the parameter fields in the UI based on the selected shape.
     * 
     * @param shape The name of the shape whose parameters are to be set.
     */
    public void updateParameterFields(String shape) {
        parameterFields.getChildren().clear();
        inputFields.clear();

        switch (shape) {
            case "Circle":
                addParameterField("Radius");
                break;

            case "Square":
                addParameterField("Side Length");
                break;

            case "Triangle":
                addParameterField("Side 1");
                addParameterField("Side 2");
                addParameterField("Side 3");
                break;

            case "Rectangle":
                addParameterField("Width");
                addParameterField("Length");
                break;

            case "Sphere":
                addParameterField("Raduis");
                break;
            
            case "Cube":
                addParameterField("Side Length");
                break;
            
            
            case "Cone":
                addParameterField("Height");    
                addParameterField("Radius");                
                break;

            case "Cylinder":
                addParameterField("Height");
                addParameterField("Radius");
                break;

            case "Torus":
                addParameterField("Minor Radius");
                addParameterField("Major Radius");
                break;
        }
    }


    /**
     * Adds a parameter field to the UI for inputting shape parameters.
     * 
     * @param label The label for the parameter field.
     */
    public void addParameterField(String label) {
        HBox fieldContainer = new HBox(5);
        Label parameterLabel = new Label(label + ": ");
        TextField textField = new TextField();

        textField.setPromptText(label);
        fieldContainer.getChildren().addAll(parameterLabel, textField);
        parameterFields.getChildren().add(fieldContainer);
        inputFields.add(textField);
    }


    /**
     * Checks if the given shape name corresponds to a 3D shape.
     * 
     * @param shape The name of the shape to check.
     * @return true if the shape is a 3D shape, false otherwise.
     */
    private boolean is3DShape(String shape) {
        return shape.equals("Sphere") || shape.equals("Cube") || shape.equals("Cylinder") || shape.equals("Cone") || shape.equals("Torus");
    }

    /**
     * Sets the lighting for rendering 3D shapes.
     * 
     * @param x X-coordinate for the light source.
     * @param y Y-coordinate for the light source.
     * @param z Z-coordinate for the light source.
     * @param color The color of the light.
     */
    private void setLighting(int x,int y,int z, Color color) {
        pointLight.setColor(color);
        pointLight.setTranslateX(x);
        pointLight.setTranslateY(y);
        pointLight.setTranslateZ(z);
    }


    /**
     * Positions a 3D shape within the canvas view.
     * 
     * @param shape The 3D shape to position.
     */
    private void set3DShapePosition(Shape3D shape){
        shape.setTranslateX(shapeCanvas.getWidth() / 2);
        shape.setTranslateY(shapeCanvas.getHeight() / 2);
        shape.setScaleX(1.0);
        shape.setScaleY(1.0);
        shape.setScaleZ(1.0);
    }


    /**
     * Sets the position of the camera for viewing 3D shapes.
     * 
     * @param x X-coordinate for the camera position.
     * @param y Y-coordinate for the camera position.
     * @param z Z-coordinate for the camera position.
     */
    private void setCameraPosition(int x, int y, int z){
        camera.setTranslateX(x);
        camera.setTranslateY(y);
        camera.setTranslateZ(z);
    }


    /**
     * Draws a 3D shape based on the specified shape type. 
     * This method handles clearing previous shapes, setting the camera position, 
     * lighting, and rendering the new 3D shape within the canvas view.
     * 
     * @param shape The type of 3D shape to draw (e.g: "Sphere", "Cube").
     */
    private void draw3DShape(String shape) {
        shape3DGroup.getChildren().clear(); // clear canvas

        setCameraPosition(0, 0, 500);
        setLighting(200, -100, -300, Color.WHITE);

        Shape3D shape3D = shapeDrawer.draw3DShape(shape); // checks if the shape is 3D, returns the shape object or null for 2D shapes
        if (shape3D != null) {
            shapeDrawer.applyRotation(shape3D, 45, 45, 0);
            set3DShapePosition(shape3D);
            shape3DGroup.getChildren().add(shape3D);
        }
    }


    /**
     * Calculates and displays the result of the selected shape based on input parameters.
     * 
     * @param shape The name of the shape to calculate.
     */
    public void calculateShape(String shape) {
        try {
            double[] parameters = inputFields.stream().mapToDouble(field -> Double.parseDouble(field.getText())).toArray();
            InputValidator.InputCheck(parameters);

            switch (shape) {
                case "Circle":
                    Shapes.Circle circle = new Shapes.Circle(parameters[0]);
                    resultLabel.setText(circle.getResult());
                    break;
            
                case "Square":
                    Shapes.Square square = new Shapes.Square(parameters[0]);
                    resultLabel.setText(square.getResult());
                    break;

                case "Triangle":
                    Shapes.Triangle tirangle = new Shapes.Triangle(parameters[0], parameters[1], parameters[2]);
                    resultLabel.setText(tirangle.getResult());
                    break;

                case "Rectangle":
                    Shapes.Rectangle rectangle = new Shapes.Rectangle(parameters[0], parameters[1]);
                    resultLabel.setText(rectangle.getResult());
                    break;


                case "Sphere":
                    Shapes.Sphere sphere= new Shapes.Sphere(parameters[0]);
                    resultLabel.setText(sphere.getResult());
                    break;

                case "Cube":
                    Shapes.Cube cube= new Shapes.Cube(parameters[0]);
                    resultLabel.setText(cube.getResult());
                    break;

                case "Cone":
                    Shapes.Cone cone = new Shapes.Cone(parameters[0], parameters[1]);
                    resultLabel.setText(cone.getResult());
                    break;

                case "Cylinder":
                    Shapes.Cylinder cylinder = new Shapes.Cylinder(parameters[0], parameters[1]);
                    resultLabel.setText(cylinder.getResult());
                    break;

                case "Torus":
                    InputValidator.CheckTorusInputs(parameters);
                    Shapes.Torus torus = new Shapes.Torus(parameters[0], parameters[1]);
                    resultLabel.setText(torus.getResult());
                    break;

                default:
                    resultLabel.setText("Invalid shape selected");
                    break;
            }

            
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input " + e.getMessage()); // Display error in the GUI
        }
    }
}
