import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.PointLight;
import Utility.*;


/**
 * Main application class for the Shape Calculator program.
 * This class sets up the user interface and integrates different components
 * for drawing and calculating properties of various shapes.
 */
public class App extends Application {
    private VBox root;
    private ShapeManager shapeManager;
    private ShapeDrawer shapeDrawer;
    private Canvas shapeCanvas;
    private PerspectiveCamera camera;
    private Group shape3DGroup;
    private SubScene shape3DSubScene;
    private PointLight pointLight;


    /**
     * Starts the application and sets up the user interface.
     * 
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        root = new VBox(10);
        shapeCanvas = new Canvas(200, 200);
        shapeDrawer = new ShapeDrawer(shapeCanvas.getGraphicsContext2D());
        camera = new PerspectiveCamera();
        shape3DGroup = new Group();
        shape3DSubScene = new SubScene(shape3DGroup, 200, 200);
        pointLight = new PointLight();
        shapeManager = new ShapeManager(new VBox(5), new Label(), shapeDrawer, shapeCanvas, shape3DGroup, shape3DSubScene, pointLight, camera);

        Label shapeSelectorLabel = new Label("Select Shape:");
        ComboBox<String> shapeSelector = new ComboBox<>();
        shapeSelector.getItems().addAll("Circle", "Square", "Triangle", "Rectangle", "Sphere", "Cube", "Cone", "Cylinder", "Torus");

        // Set up action listeners for UI elements
        shapeSelector.setOnAction(event -> {
            String selectedShape = shapeSelector.getValue();
            shapeManager.updateParameterFields(selectedShape);
            shapeManager.updateShapeRepresentation(selectedShape);
        });

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> {
            String selectedShape = shapeSelector.getValue();
            shapeManager.calculateShape(selectedShape);
        });

        HBox shapeSelectorContainer = new HBox(10);
        shapeSelectorContainer.getChildren().addAll(shapeSelectorLabel, shapeSelector);

        // Add components to the root container
        root.getChildren().addAll(shapeSelectorContainer, shapeManager.getParameterFields(), calculateButton, shapeManager.getResultLabel());

        // Set up the stage and scene
        primaryStage.setTitle("Shape Calculator");
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }

    /**
     * Main method to launch the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        launch(args);
    }



}

