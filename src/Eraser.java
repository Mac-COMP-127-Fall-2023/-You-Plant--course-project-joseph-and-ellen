
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class Eraser implements Brush {
 
    public void apply(GraphicsGroup paintLayer, Point location, BrushOptions brushOptions) {

        GraphicsObject object = paintLayer.getElementAt(location);

        if (object != null) {
            paintLayer.remove(object);
        }
    }
    public String getName() {
        return "Eraser";
    }
}