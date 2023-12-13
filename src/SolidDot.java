
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class SolidDot implements Brush {

    public void apply(GraphicsGroup paintLayer, Point location, BrushOptions brushOptions) {
        GraphicsObject dot = PaintUtils.createSolidDot(
                location,
                brushOptions.getColor(),
                brushOptions.getRadius());
        dot.setCenter(location);
        paintLayer.add(dot);
    }

    public String getName() {
        return "Solid Dot";
    }
}
