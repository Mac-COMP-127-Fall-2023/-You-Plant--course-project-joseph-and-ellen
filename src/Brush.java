import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public interface Brush {
   void apply(GraphicsGroup paintLayer, Point location, BrushOptions brushOptions);
   String getName();
}

