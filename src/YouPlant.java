import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

public class YouPlant {
    private Brush currentBrush;
    private CanvasWindow canvas, canvas1;
    public PaintSettingsView paintSettingsView;
    private List<Brush> availableBrushes;
    private GraphicsGroup paintLayer;
    private double xpos = 0;
    private double ypos = 150;
    private double SOIL_WIDTH = 800;
    private double SOIL_HEIGHT = 500;

    public YouPlant() {
        mainScreen();
    }

    private void mainScreen() {
        canvas1 = new CanvasWindow("You Plant", 800, 500);
        canvas1.setBackground(new Color(54, 209, 255));
        canvas1.draw();

        Ellipse sun = new Ellipse(700, 20, 60, 60);
        sun.setFillColor(new Color(255, 224, 63));
        canvas1.add(sun);

        Soil soil = new Soil(xpos, ypos, SOIL_WIDTH, SOIL_HEIGHT);
        soil.setFillColor(new Color(46, 125, 40));
        canvas1.add(soil);

        addDrawYourPlantButton();
 
    }

    private void drawingKit() {
        canvas = new CanvasWindow("Tools", 160, 240);
        paintLayer = new GraphicsGroup();
        canvas1.add(paintLayer);

        paintSettingsView = new PaintSettingsView(Color.BLUE, 60);
        canvas.add(paintSettingsView, 8 - paintSettingsView.getBounds().getMinX(), 10);

        availableBrushes = new ArrayList<>();
        availableBrushes.add(new SolidDot());
        availableBrushes.add(new Eraser());

        double yCoordinate = 50;
        for (Brush brush : availableBrushes) {
            addBrushButton(brush, yCoordinate);
            yCoordinate += 30;
        }

        canvas1.onMouseDown(event -> paint(event.getPosition()));
        canvas1.onDrag(event -> paint(event.getPosition()));
    }

    //----------------------BRUSH---------------------//
    private void addBrushButton(Brush brush, double y) {
        Button changeBrushButton = new Button(brush.getName());
        changeBrushButton.setPosition(10, y);
        canvas.add(changeBrushButton);
        changeBrushButton.onClick(() -> {
            currentBrush = brush;
        });
    }
    //----------------------BRUSH---------------------//

    //----------------------PAINT METHOD---------------------//
       private void paint(Point location) {
        BrushOptions brushOptions = paintSettingsView.getBrushOptions();
        if (isWithinSoilBounds(location)) {
            currentBrush.apply(paintLayer, location, brushOptions);
        }}
        
    private boolean isWithinSoilBounds(Point location) {
        return location.getX() >= xpos && location.getX() <= xpos + SOIL_WIDTH &&
               location.getY() >= ypos && location.getY() <= ypos + SOIL_HEIGHT;
    }
    //----------------------PAINT METHOD---------------------//


    //----------------------Add your plant button---------------------//

    private void addDrawYourPlantButton() {
        Button drawYourPlantButton = new Button("Draw plants");
        drawYourPlantButton.setPosition(5, 10);
        canvas1.add(drawYourPlantButton);
        Runnable drawingKitRunnable = new Runnable() {
            @Override
            public void run() {
                drawingKit();
            }
        };

        drawYourPlantButton.onClick(drawingKitRunnable);
    }

     //----------------------Add your plant button---------------------//



     


    public static void main(String[] args) {
        new YouPlant();
    }
}




    //     canvas.draw();
        // Add soil to canvas (and background if we add one)
        //Add buttons for options for user: (1) Plant
        // (2) Monitor Soil/Water (3) Go to next day 
        // When User creates a plant, provide them with the options 
        // for the plants (or if it is easier for them to make their own 
        // plants implement that). When user monitors soil/water quality, 
        // collect results from soil and environmental factors 
        // and then provide them the next day
        // option 3 self explanatory
        // record number of plants and plant stage/health in plant manager
        // after max days have passed, stop game and tell user how well 
        // they did

    // }




