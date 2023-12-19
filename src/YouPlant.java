import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.reflections.Reflections;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;

import java.awt.geom.Rectangle2D;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

public class YouPlant {


    private CanvasWindow canvas, canvas1;

    
    private double xpos = 0;
    private double ypos = 150;
    private double SOIL_WIDTH = 800; 
    private double SOIL_HEIGHT = 500;
    private int MAX_DAYS = 100;
    private static int numDays = 1;
    private List<Critter> critters;
    private final Random rand = new Random();
    private List<Class<? extends Critter>> critterClasses;
    private static final boolean CAPTIONS_ENABLED = false;
    priva

    public YouPlant() {
        critters = new ArrayList<>();
        mainScreen();
    }
    
    public static void main(String[] args) {
        new YouPlant();
    }


    //---------------CRITTER-----------------------//
    private void loadCritterClasses() {
        Reflections reflections = new Reflections(getClass().getPackage().getName());
        critterClasses = new ArrayList<>(
        reflections.getSubTypesOf(Critter.class));
    }
 



private Critter addNewCritter(int buttonIndex) {
    Critter critter = createChoosenCritter(buttonIndex);
    GraphicsObject g = critter.getGraphics();
    Point point = randLocationFor(critter);
    g.setPosition(point.getX(), point.getY());
    chooseNewGoal(critter);

    canvas.add(critter.getGraphics());
    critters.add(critter);
    return critter;
}



private Point randLocationFor(Critter critter) {
    GraphicsObject g = critter.getGraphics();
    Rectangle2D bounds = g.getBounds();
    double maxX = canvas.getWidth() - (bounds.getWidth() + critter.getxOffset());
    double maxY = canvas.getHeight() - (bounds.getHeight() + critter.getyOffset());
    double x = Math.max(xpos, Math.min(rand.nextDouble() * maxX, xpos + SOIL_WIDTH - bounds.getWidth()));
    double y = Math.max(ypos, Math.min(rand.nextDouble() * maxY, ypos + SOIL_HEIGHT - bounds.getHeight()));

    return new Point(x, y);
}


private Critter createChoosenCritter(int buttonIndex) {
    Class<? extends Critter> critterClass;

    switch (buttonIndex) {
        case 0:
            critterClass = critterClasses.get(3); // plant 0
            
            break;
        case 1:
            critterClass = critterClasses.get(9); // plant 1  
            
            break;
        case 2:
            critterClass = critterClasses.get(7); // plant 2     
            
            break;
        case 3:
            critterClass = critterClasses.get(4); // plant 3   
            
            break;
        case 4:
            critterClass = critterClasses.get(6); // plant 4     
            
            break;
        case 5:
            critterClass = critterClasses.get(8); // plant 5   
            
            break;
        case 6:
            critterClass = critterClasses.get(5); // plant 6
            
            break;
        case 7:
            critterClass = critterClasses.get(0); // plant 7 
            
            break;
        case 8:
            critterClass = critterClasses.get(1); // plant 8
            
            break;
        case 9:
            critterClass = critterClasses.get(2); // plant 9
            break;
        default:
            throw new IllegalArgumentException("Invalid button index");
    }

    try {
        Critter critter = critterClass.getConstructor().newInstance();
        if (CAPTIONS_ENABLED) {
            GraphicsText caption = new GraphicsText(critterClass.getSimpleName());
            caption.setFont("Avenir Next", FontStyle.PLAIN, 11);
            critter.getGraphics().add(caption);
            caption.setCenter(
                critter.getGraphics().getCenter().getX(),
                critter.getGraphics().getHeight());
        }
        return critter;
    } catch (Exception e) {
        throw new RuntimeException("Cannot instantiate " + critterClass, e);
    }
}





    private void chooseNewGoal(Critter critter) {
        critter.setGoal(randLocationInRange(critter.getGraphics()));
    }

    private Point randLocationInRange(GraphicsObject g) {
        double maxRange = 500.0;
        Rectangle2D bounds = g.getBounds();
        edu.macalester.graphics.Point p0 = g.getPosition();
        double dx = rand.nextDouble() * (2.0 * maxRange) - maxRange;
        double dy = rand.nextDouble() * (2.0 * maxRange) - maxRange;
        double forwardProgess = -bounds.getHeight() * 2 - 10;  // critters tend upward, off the top edge of the screen
        return new Point(0, forwardProgess).add(
            Point.max(
                Point.ORIGIN,
                Point.min(
                    new Point(canvas.getWidth() - bounds.getWidth(), canvas.getHeight() - bounds.getHeight()),
                    new Point(p0.getX() + dx, p0.getY() + dy))));
    }



//---------------CRITTER-----------------------//

    private void mainScreen() {
        canvas = new CanvasWindow("You Plant", 800, 500);
        canvas.setBackground(new Color(54, 209, 255));
      
        Ellipse sun = new Ellipse(370, 20, 60, 60);
        sun.setFillColor(new Color(255, 224, 63));
        canvas.add(sun);

        Soil soil = new Soil(xpos, ypos, SOIL_WIDTH, SOIL_HEIGHT);
        soil.setFillColor(new Color(46, 125, 40));
        canvas.add(soil);

        addchooseYourPlantButton();
        addNextDayButton();
        

        // nextDayButton();
 
    }


    //--------------PLANT OPTIONS---------------------//
    private void addchooseYourPlantButton() {
        Button drawYourPlantButton = new Button("Draw plants");
        drawYourPlantButton.setPosition(5, 10);
        canvas.add(drawYourPlantButton);
        Runnable drawingKitRunnable = new Runnable() {
            @Override
            public void run() {
                plantOptions();

            }
        };

        drawYourPlantButton.onClick(drawingKitRunnable);
    }



    private void plantOptions() {
        canvas1 = new CanvasWindow("Plants", 750, 350);
        //-------PLANT 1------//
        Button americanplumButton = new Button("American Plum");
        americanplumButton.setPosition(5,10);
        canvas1.add(americanplumButton);
        
        Image americanplum = new Image(10, 40, "americanplum_stage1.png");
        canvas1.add(americanplum);
        

        //-------PLANT 2------//
        Button bluestemButton = new Button("Bluestem");
        bluestemButton.setPosition(155,10);
        canvas1.add(bluestemButton);
        
        Image bluestem = new Image(160, 40, "bluestem_stage1.png");
        canvas1.add(bluestem);


        //-------PLANT 3------//
        Button commonmilkweedButton = new Button("Milkweed");
        commonmilkweedButton.setPosition(305,10);
        canvas1.add(commonmilkweedButton);
        
        Image commonmilkweed = new Image(310, 40, "commonmilkweed_stage1.png");
        canvas1.add(commonmilkweed);

        //-------PLANT 4------//
        Button easternbottlebrushgrassButton = new Button("Bottlebrush Grass");
        easternbottlebrushgrassButton.setPosition(455,10);
        canvas1.add(easternbottlebrushgrassButton);
        
        Image easternbottlebrushgrass = new Image(460, 40, "easternbottlebrushgrass_stage1.png");
        canvas1.add(easternbottlebrushgrass);


        //-------PLANT 5------//
        Button goldenrodButton = new Button("Goldenrod");
        goldenrodButton.setPosition(605,10);
        canvas1.add(goldenrodButton);
        
        Image goldenrod = new Image(610, 40, "goldenrod_stage1.png");
        canvas1.add(goldenrod);

        //-------PLANT 6------//
        Button leadplantButton = new Button("Leadplant");
        leadplantButton.setPosition(5,200);
        canvas1.add(leadplantButton);
        
        Image leadplant = new Image(10, 230, "leadplant_stage1.png");
        canvas1.add(leadplant);

        //-------PLANT 7------//
        Button shagbarkhickoryButton = new Button("Shagbark Hickory");
        shagbarkhickoryButton.setPosition(155,200);
        canvas1.add(shagbarkhickoryButton);
        
        Image shagbarkhickory = new Image(160, 230, "shagbarkhickory_stage1.png");
        canvas1.add(shagbarkhickory);

        //-------PLANT 8------//
        Button stjohnswortButton = new Button("St Johnswort");
        stjohnswortButton.setPosition(305,200);
        canvas1.add(stjohnswortButton);
        
        Image stjohnswort = new Image(310, 230, "stjohnswort_stage1.png");
        canvas1.add(stjohnswort);

        //-------PLANT 9------//
        Button sumacButton = new Button("Sumac");
        sumacButton.setPosition(455,200);
        canvas1.add(sumacButton);
        
        Image sumac = new Image(460, 230, "sumac_stage1.png");
        canvas1.add(sumac);

        //-------PLANT 10------//
        Button tallmeadowrueButton = new Button("Tall meadow rue");
        tallmeadowrueButton.setPosition(605,200);
        canvas1.add(tallmeadowrueButton);
        
        Image tallmeadowrue = new Image(610,230, "tallmeadowrue_stage1.png");
        canvas1.add(tallmeadowrue);
    



        Runnable drawAmericanPlum = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(0); // 0 
            }
        };
        
        Runnable drawBluestem = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(1); // 1 
            }
        };
        
        Runnable drawCommonMilkWeed = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(2); // 2 
            }
        };
        
        Runnable drawEasternBottleBrushGrass = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(3); // 3
            }
        };

        Runnable drawGoldenRod = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(4); // 4
            }
        };

        Runnable drawLeadplant = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(5); // 5
            }
        };

        Runnable drawShagBarkHickory = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(6); // 6
            }
        };

        Runnable drawStJohnsWort = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(7); // 7
            }
        };

        Runnable drawSumac = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(8); // 8
            }
        };

        Runnable drawTallmeadowrue = new Runnable() {
            @Override
            public void run() {
                loadCritterClasses();
                // critters = new ArrayList<>();
                addNewCritter(9); // 9
            }
        };


        
    
        americanplumButton.onClick(drawAmericanPlum);
        bluestemButton.onClick(drawBluestem);
        commonmilkweedButton.onClick(drawCommonMilkWeed);
        easternbottlebrushgrassButton.onClick(drawEasternBottleBrushGrass);
        goldenrodButton.onClick(drawGoldenRod);
        leadplantButton.onClick(drawLeadplant);
        shagbarkhickoryButton.onClick(drawShagBarkHickory);
        stjohnswortButton.onClick(drawStJohnsWort);
        sumacButton.onClick(drawSumac);
        tallmeadowrueButton.onClick(drawTallmeadowrue);


    }
    


    //--------------NEXT DAY BUTTON---------------------//
       public void addNextDayButton() {
        Button nextDayButton = new Button("Go to the Next Day");
        nextDayButton.setPosition(120, 10);
        canvas.add(nextDayButton);
        Runnable drawingKitRunnable = new Runnable() {
            @Override
            public void run() {
                numDays += 1;
                System.out.println("Day" + numDays + ":");
                System.out.println(critters.size());
                System.out.println(critters.get(0).getGraphics().getSize());
                
                    for(Critter plant: critters) {
                        if (isAlive(plant)) {
                            if (plant.daysAlive() >= 20 && plant.daysAlive() < 40) {
                            plant.stage2();
                            }
                            if (plant.daysAlive() >= 40) {
                            plant.stage3();
                            }
                            plant.addOneDay();
                        }
                        else {
                            plant.remove();
                        }

                    }

            }
        };
        nextDayButton.onClick(drawingKitRunnable);
    }
    public static double getNumDays() {
        return numDays;
    }

    public boolean isAlive(Critter plant) {
        String plantName = plant.getClass().getName();
        if (plantName.equalsIgnoreCase("AmericanPlum")) {
        }
        if (plantName.equalsIgnoreCase("Bluestem")) {
            System.out.println("2");
        }
        if (plantName.equalsIgnoreCase("CommonMilkWeed")) {
            System.out.println("3");
        }
        if (plantName.equalsIgnoreCase("easternbottlebrushgrass")) {
            System.out.println("4");
        }
        if (plantName.equalsIgnoreCase("goldenrod")) {
            System.out.println("5");
        }
        if (plantName.equalsIgnoreCase("leadplant")) {
            System.out.println("6");
        }
        if (plantName.equalsIgnoreCase("shagbarkhickory")) {
            System.out.println("7");
        }
        if (plantName.equalsIgnoreCase("stjohnswort")) {
            System.out.println("8");
        }
        if (plantName.equalsIgnoreCase("sumac")) {
            System.out.println("9");
        }
        if (plantName.equalsIgnoreCase("tallmeadowrue")) {
            System.out.println("10");
        }
        return true;
    }



}