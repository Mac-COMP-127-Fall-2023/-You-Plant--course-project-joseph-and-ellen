import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

import java.awt.Color;

public class PaintUtils {
    /**
     * Creates a solid circle (not fuzzy) with the specified color and radius.
     *
     * @param location Center of the dot
     * @param color    Color of the dot
     * @param radius   Radius of the solid circle
     * @return A graphics object representing the solid dot
     */
    public static GraphicsObject createSolidDot(Point location, Color color, float radius) {
        Ellipse dot = new Ellipse(0, 0, radius/3, radius/3);
        dot.setFillColor(color);
        dot.setStroked(false);
        dot.setCenter(location);
        return dot;
    }

    /**
     * Creates a new color with the same RGB value as the given one, but with a different transparency.
     */
    public static Color adjustTransparency(Color color, double alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) Math.round(alpha * 255));
    }
}