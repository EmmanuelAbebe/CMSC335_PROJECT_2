package Utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.scene.shape.*;

/**
 * This class is responsible for drawing both 2D and 3D shapes.
 * It handles the drawing operations on a specified GraphicsContext
 * and provides methods to create and manipulate 3D shapes.
 */
public class ShapeDrawer {
    private GraphicsContext gc;

    /**
     * Constructor for the ShapeDrawer.
     * 
     * @param gc The GraphicsContext on which shapes are to be drawn.
     */
    public ShapeDrawer(GraphicsContext gc) {
        this.gc = gc;
    }

    /**
     * Checks if the given shape is a 3D shape.
     * 
     * @param shape Name of the shape to check.
     * @return true if the shape is a 3D shape, false otherwise.
     */
    public boolean is3DShape(String shape) {
        return shape.equals("Sphere") || shape.equals("Cube") || shape.equals("Cylinder") || shape.equals("Cone") || shape.equals("Torus"); // Add other 3D shapes here
    }


    /**
     * Applies rotation to a 3D shape.
     * 
     * @param shape The 3D shape to which the rotation is to be applied.
     * @param angleX The angle of rotation around the X-axis.
     * @param angleY The angle of rotation around the Y-axis.
     * @param angleZ The angle of rotation around the Z-axis.
     */
    public void applyRotation(Shape3D shape, double angleX, double angleY, double angleZ) {
        shape.getTransforms().addAll(
            new Rotate(angleX, Rotate.X_AXIS),
            new Rotate(angleY, Rotate.Y_AXIS),
            new Rotate(angleZ, Rotate.Z_AXIS)
        );
    }


    /**
     * Draws a 2D shape on the canvas.
     * 
     * @param shape The name of the 2D shape to draw.
     */
    public void draw2DShape(String shape) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());// Clear canvas
        switch (shape) {
            case "Circle":
                gc.strokeOval(50, 50, 100, 100);
                break;
            case "Square":
                gc.strokeRect(50, 50, 100, 100);
                break;

            case "Rectangle":
                gc.strokeRect(50, 50, 50, 100);
                break;

            case "Triangle":
                double[] xPoints = {100.0, 150.0, 50.0};
                double[] yPoints = {50.0, 150.0, 150.0};
                gc.strokePolygon(xPoints, yPoints, 3);
                break;
        }
    }


    /**
     * Creates and returns a 3D shape based on the specified shape name.
     * 
     * @param shape The name of the 3D shape to create.
     * @return The created 3D shape or null if the shape name is not recognized.
     */
    public Shape3D draw3DShape(String shape) {
        switch (shape) {
            case "Sphere":
                return new Sphere(50);  // Assuming params[0] is the radius

            case "Cube":
                return new Box(100, 100, 100); // Assuming params[0] is the side length

            case "Cylinder":
                return new Cylinder(50, 100); // Assuming params[0] is the radius, params[1] is the height

            case "Cone":
                return createHollowCone(100, 50);

            case "Torus":
                return createHollowTorus(50, 20);
        }
        return null;
    }

    /**
     * Creates a hollow cone 3D shape.
     * 
     * @param height The height of the cone.
     * @param baseRadius The radius of the base of the cone.
     * @return The created hollow cone as a MeshView.
     */
    public MeshView createHollowCone(int height, int baseRadius) {
        int rounds = 360;
        int r2 = baseRadius;
        int h = height;

        float[] points = new float[(rounds + 1) * 3];
        float[] textCoords = {0.5f, 0, 0, 1, 1, 1};
        int[] faces = new int[rounds * 6];

        for (int i = 0; i < rounds; i++) {
            int index = i * 3;
            points[index] = (float) Math.cos(Math.toRadians((double) i / rounds * 360)) * r2;
            points[index + 1] = (float) Math.sin(Math.toRadians((double) i / rounds * 360)) * r2;
            points[index + 2] = -h / 2;
        }
        // Apex of the cone
        points[rounds * 3] = 0;
        points[rounds * 3 + 1] = 0;
        points[rounds * 3 + 2] = h / 2;

        // Define faces (triangular faces connecting the base to the apex)
        for (int i = 0; i < rounds; i++) {
            int index = i * 6;
            faces[index] = i;
            faces[index + 1] = 1;
            faces[index + 2] = (i + 1) % rounds;
            faces[index + 3] = 2;
            faces[index + 4] = rounds;
            faces[index + 5] = 0;
        }

        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().addAll(points);
        mesh.getTexCoords().addAll(textCoords);
        mesh.getFaces().addAll(faces);

        MeshView meshView = new MeshView(mesh);

        // Rotate the cone to stand upright
        Rotate rotateX = new Rotate(90, Rotate.X_AXIS);
        meshView.getTransforms().add(rotateX);

        return meshView;
    }

    /**
     * Creates a hollow torus 3D shape.
     * 
     * @param majorRadius The major radius of the torus.
     * @param minorRadius The minor radius of the torus.
     * @return The created hollow torus as a MeshView.
     */
    public MeshView createHollowTorus(int majorRadius, int minorRadius) {
        TriangleMesh mesh = new TriangleMesh();

        int tubeDivisions = 50;
        int ringDivisions = 50;

        // Define points
        for (int ring = 0; ring <= ringDivisions; ring++) {
            double theta = 2.0 * Math.PI * ring / ringDivisions;
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);

            for (int tube = 0; tube <= tubeDivisions; tube++) {
                double phi = 2.0 * Math.PI * tube / tubeDivisions;
                double cosPhi = Math.cos(phi);
                double sinPhi = Math.sin(phi);
                double dist = majorRadius + minorRadius * cosPhi;

                mesh.getPoints().addAll(
                    (float) (dist * cosTheta),  // x
                    (float) (dist * sinTheta),  // y
                    (float) (minorRadius * sinPhi)  // z
                );
            }
        }

        // Define texture coordinates
        for (int ring = 0; ring <= ringDivisions; ring++) {
            for (int tube = 0; tube <= tubeDivisions; tube++) {
                mesh.getTexCoords().addAll(
                    (float) tube / tubeDivisions, // u-coordinate goes though the center of the tube in the torus
                    (float) ring / ringDivisions // v-coordinate goes around the surace of the torus
                );
            }
        }

        // Define faces
        for (int ring = 0; ring < ringDivisions; ring++) {
            for (int tube = 0; tube < tubeDivisions; tube++) {
                int p0 = ring * (tubeDivisions + 1) + tube;
                int p1 = p0 + 1;
                int p2 = p0 + (tubeDivisions + 1);
                int p3 = p2 + 1;

                mesh.getFaces().addAll(
                    p0, p0, p1, p1, p2, p2,
                    p3, p3, p2, p2, p1, p1
                );
            }
        }


        MeshView torusView = new MeshView(mesh);
        return torusView;
    }
    
}