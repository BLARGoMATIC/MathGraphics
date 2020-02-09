package mathGraphics;
import java.awt.Color;
/**
 * Stores the x and y coordinates for a given point along with a given color
 * @param Integer x, horizontal X coordinate
 * @param Integer y, vertical Y coordinate
 * @param Color c , Color value of the point
 */
public class Coordinates {
	public int x, y;
	public Color c;
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		c = Color.WHITE;
	}
	public Coordinates(int x, int y, Color c) {
		this(x, y);
		this.c = c;
	}
}
