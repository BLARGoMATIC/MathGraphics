package mathgraphics;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrawPatterns { //TODO clean up methods, it's kind of messy at the moment.

	private LEDGrid grid;
	private SecureRandom rand = new SecureRandom();
	public DrawPatterns(LEDGrid grid) {
		this.grid = grid;
	}
	public Mark at(Coordinates c) { //similar to addPoint() however this one uses a Modulus window wrapping function to keep the point within the grid
		return grid.leds[c.x][c.y];
	}
	public void addPoint(Coordinates a) {
		addPoint(a.x, a.y, a.mark);
	}
	public void addPoint(int x, int y) {
		addPoint(x, y, Color.WHITE);
	}
	public void addPoint(int x, int y, Color c) {
		x = Math.floorMod(x, grid.getHorizontalLEDs());
		y = Math.floorMod(y, grid.getVerticalLEDs());
		grid.leds[x][y] = new Mark(c);
	}
	public void addPoint(int x, int y, Mark m) {
		x = Math.floorMod(x, grid.getHorizontalLEDs());
		y = Math.floorMod(y, grid.getVerticalLEDs());
		grid.leds[x][y] = m;
	}
	public void addLine(int x0, int y0, int x1, int y1) {//start color, end color

		int maxDif = Math.max(Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0)), 1);
		int i;
		int j = 0;
		try {
			for(i = 0; i <= maxDif; i++) {
				addPoint((x0 + (i * (x1 - x0) / maxDif)),(y0 + (i * (y1 - y0) / maxDif)), Color.WHITE);
				j=i;
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(x0 + " " +
					x1 + " " +
					y0 + " " +
					y1 + " " +
					j + " " +
					maxDif);
		}
	}
	/** Draw a line
	 * @param x0 Starting x coordinate
	 * @param y0 Starting y coordinate
	 * @param x1 Ending x coordinate
	 * @param y1 Ending y coordinate
	 * @param c0 Starting Color, fades smoothly to the ending color
	 * @param c1 Ending Color, fades smoothly from the starting color
	 */
	public void addLine(int x0, int y0, int x1, int y1, Color c0, Color c1) {//start color, end color

		int maxDif = Math.max(Math.abs(x1 - x0), 
				Math.abs(y1 - y0));
		int i;

		for(i = 0; i <= maxDif; i++) {
			addPoint(		(x0 + i * (x1 - x0) / maxDif),
					(y0 + i * (y1 - y0) / maxDif),
					new Color(
							c0.getRed()		+ i * (c1.getRed() 		- c0.getRed()	)	/maxDif,
							c0.getGreen() 	+ i * (c1.getGreen() 	- c0.getGreen()	)	/maxDif,
							c0.getBlue() 	+ i * (c1.getBlue() 	- c0.getBlue()	)	/maxDif));

		}
	}
	public void addLine(Coordinates a, Coordinates b) {
		int maxDif = Math.max(Math.max(Math.abs(b.x - a.x), Math.abs(b.y - a.y)), 1);
		int i;
		int j = 0;
		try {
			for(i = 0; i <= maxDif; i++) {
				addPoint((a.x + (i * (b.x - a.x) / maxDif)),(a.y + (i * (b.y - a.y) / maxDif)), new Color(
						a.mark.getRed()		+ i * (b.mark.getRed() 		- a.mark.getRed()	)	/maxDif,
						a.mark.getGreen() 	+ i * (b.mark.getGreen() 	- a.mark.getGreen()	)	/maxDif,
						a.mark.getBlue() 	+ i * (b.mark.getBlue() 	- a.mark.getBlue()	)	/maxDif));
				j=i;
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(a.x + " " +
					b.x + " " +
					a.y + " " +
					b.y + " " +
					j + " " +
					maxDif);
		}
	}
	public void addTriangle(int x0, int y0, int x1, int y1,int x2, int y2, Color c) {
		// draw side 1
		addLine( x0, y0, x1, y1, c, c);
		// ... draw the other two sides ...
		addLine( x1, y1, x2, y2, c, c);
		addLine( x2, y2, x0, y0, c, c);
	}
	public void addTriangle(int x0, int y0,int x1, int y1,int x2, int y2, Color c0, Color c1, Color c2) {  // Colors for vertices 0, 1, 2
		// draw side 1
		addLine( x0, y0, x1, y1, c0, c1);
		// ... draw the other two sides ...
		addLine( x1, y1, x2, y2, c1, c2);
		addLine( x2, y2, x0, y0, c2, c0);
	}
	public void addTriangle(Coordinates a, Coordinates b, Coordinates c) { 
		addLine(a,b);
		addLine(b,c);
		addLine(c,a);
	}
	/**No color parameters, defaults to white.
	 * @param radius - the radius of the circle
	 * @param x - the x-coordinate of the circle's center
	 * @param y - the y-coordinate of the circle's center
	 */
	public void addCircle(double radius, double x, double y) {//No color parameters, defaults to white
		addCircle(0, radius, x, y, Color.WHITE, Color.WHITE);
	}
	/**One color parameter, no gradient
	 * @param radius - the radius of the circle
	 * @param x - the x-coordinate of the circle's center
	 * @param y - the y-coordinate of the circle's center
	 * @param color - The color of the circle
	 */
	public void addCircle(double radius, double x, double y, Color color) {
		addCircle(0, radius, x, y, color, color);
	}
	/**No rotation parameter, defaults to 0 degrees, primary color on the right, secondary color on the left.
	 * @param radius - the radius of the circle
	 * @param x - the x-coordinate of the circle's center
	 * @param y - the y-coordinate of the circle's center
	 * @param color1 - Primary color of the circle, changes gradually to the secondary color, right to left, on the bottom half of the circle
	 * @param color2 - Secondary color of the circle, changes gradually to the primary color, left to right, on the top half of the circle
	 */
	public void addCircle(int radius, int x, int y, Color color1, Color color2) {
		addCircle(0, radius, x, y, color1, color2);
	}
	/**Draws a circle at coordinates (x,y) with a two-color gradient between the two halves of the circle.
	 * @param theta - rotation of the circle, in degrees. Used for orientation of Color Gradient.
	 * @param radius - the radius of the circle
	 * @param x - the x-coordinate of the circle's center
	 * @param y - the y-coordinate of the circle's center
	 * @param c0 - Primary color of the circle, changes gradually to the secondary color, right to left, on the bottom half of the circle
	 * @param c1 - Secondary color of the circle, changes gradually to the primary color, left to right, on the top half of the circle
	 */
	public void addCircle(double theta, double radius, double x, double y, Color c0, Color c1) {
		theta = theta * Math.PI/180; //convert from degrees to radians
		for(double i = theta; i <= theta+(2*Math.PI); i += (2*Math.PI)/15000) {//Java calculates sine and cosine in radians, so I have to convert to degrees

			int ledX = (int) Math.rint(x + radius * Math.cos(i)); //Find x coordinate and round to nearest int.
			int ledY = (int) Math.rint(y + radius * Math.sin(i)); //Find y coordinate and round to nearest int.

			if(i <= (theta + Math.PI)) {//First half of the circle
				addPoint(ledX, ledY, new Color(
						(int)Math.rint(c0.getRed()		+ (i-theta) * (c1.getRed() 		- c0.getRed()	)	/(Math.PI)),
						(int)Math.rint(c0.getGreen() 	+ (i-theta) * (c1.getGreen() 	- c0.getGreen()	)	/(Math.PI)),	//This half changes from color1 to color2
						(int)Math.rint(c0.getBlue() 	+ (i-theta) * (c1.getBlue() 	- c0.getBlue()	)	/(Math.PI))));
			}
			else {		//second half
				addPoint(ledX,ledY, new Color(
						(int)Math.rint(c1.getRed()		+ ((i-theta)-Math.PI) * (c0.getRed() 	- c1.getRed()	)	/(Math.PI)),
						(int)Math.rint(c1.getGreen() 	+ ((i-theta)-Math.PI) * (c0.getGreen() 	- c1.getGreen()	)	/(Math.PI)),	//This half changes from color2 to color1
						(int)Math.rint(c1.getBlue() 	+ ((i-theta)-Math.PI) * (c0.getBlue() 	- c1.getBlue()	)	/(Math.PI))));	
				//The (i-Math.PI) in the middle is required to avoid an outOfBounds exception
				//(i-Math.PI) is 'i' subtract a half-circle in radians,
				//since I want the color gradient to reset halfway through the circle.
			}			
		}
	}
	/** An interesting animation/pattern creator that draws larger and larger circles taking advantage of the window wrapping function.
	 * @param size Radius of the largest circle
	 * @param c1 Primary color of the circles
	 * @param c2 secondary color of the circles
	 * @param showIncrement set true to see the radius of the current largest circle
	 * 
	 */
	public void circleAnimation(int size, Color c1, Color c2, boolean showIncrement) {
		grid.setShowIncrement(showIncrement);
		for(int k=0; k <= size; k++) {
			addCircle(0,k,grid.getHorizontalLEDs()/2,grid.getVerticalLEDs()/2, c1, c2); //Draw many circles in the center, gradually getting bigger
			grid.setIncrement(k);
			grid.repaint();
		}
	}
	public void circleFractal(double radius, double x, double y, Color c1, Color c2) {
		grid.repaint();
		addCircle(0, radius, x, y, c1, c2);
		if(radius > 4) {
			circleFractal(radius/2, x + radius, y, c1, c2);
			circleFractal(radius/2, x - radius, y, c1, c2);
			circleFractal(radius/2, x, y + radius, c1, c2);
			circleFractal(radius/2, x, y - radius, c1, c2);
		}
	}
	public void addSquare(int x, int y, int size, double rotation) {

		int x0 = x;
		int x1 = x + (int) Math.rint(size * Math.cos(rotation));
		int y0 = y;
		int y1 = y + (int) Math.rint(size * Math.sin(rotation));

		for(int i = 0; i < 4; i++) {
			addLine(x0, y0, x1, y1);

			rotation -= Math.PI/2;
			x0 = x1;
			x1 = x0 + (int) Math.rint(size * Math.cos(rotation));
			y0 = y1;
			y1 = y0 + (int) Math.rint(size * Math.sin(rotation));
		}
	}
	public void squareFractal(int x, int y, int size, double rotation) {
		grid.repaint();


		int x0 = x;
		int x1 = x + (int) Math.rint(size * Math.cos(rotation));
		int y0 = y;
		int y1 = y + (int) Math.rint(size * Math.sin(rotation));

		if(size > 10) {	//If the square is too small, that's the end of the loop
			size /= 2;	//Shrink the Square
			rotation += Math.PI/3;	//Rotate the square 120 degrees about one of its corners
			for(int i = 0; i < 4; i++) {
				x0 = x1;
				x1 = x0 + (int) Math.rint(size * Math.cos(rotation));
				y0 = y1;
				y1 = y0 + (int) Math.rint(size * Math.sin(rotation));

				addSquare(x, y, size, rotation);
				squareFractal(x0, y0, size, rotation);

				rotation -= Math.PI/2;
			}
		}
	}
	public void tree(int x, int y, double length, double rotation, double branchSpread) {
		int x0 = x;
		int x1 = x + (int) Math.rint(length * Math.cos(rotation));
		int y0 = y;
		int y1 = y + (int) Math.rint(length * Math.sin(rotation));

		addLine(x0, y0, x1, y1);

		if(length > 1) {
			tree(x1, y1, length/1.45, rotation - branchSpread, branchSpread); //36 degrees or Math.PI/5 is standard for the branchspread
			tree(x1, y1, length/1.45, rotation + branchSpread, branchSpread);
		}
	}
	/**This method draws you a Sierpinski Triangle, using the Chaos game
	 * @deprecated currently unused, Now you can just call the chaosPolygon() method instead
	 */
	@Deprecated
	public void chaosTriangle(int iterations) {
		Coordinates a = new Coordinates(250, 103, Color.BLUE);
		Coordinates b = new Coordinates(100, 333, Color.RED);
		Coordinates c = new Coordinates(400, 333, Color.GREEN);

		//current location
		Coordinates z = new Coordinates(250, 250);
		Coordinates vert = a; //to be initialized later

		//		addLine(a,b);
		//		addLine(b,c);
		//		addLine(c,a);

		//Selecting a random point within the triangle
		do{
			z.x = rand.nextInt(301) + 100;
			z.y = rand.nextInt(301) + 100;
		} while (onRight(a,b,z) && onRight(b,c,z) && onRight(c,a,z));

		if(iterations <= 0) iterations = 100000;
		for(int i = 0; i < iterations; i++) {

			//Selecting a random vertex
			if(rand.nextInt(3) == 0) vert = a;
			else if(rand.nextInt(3) == 1) vert = b;
			else if(rand.nextInt(3) == 2) vert = c;
			else vert = c;

			//moving halfway to that vertex
			z.x = (vert.x + z.x)/2;
			z.y = (vert.y + z.y)/2;
			
			//Placing a point at current location
			addPoint(z);
			grid.repaint();
		}
	}	
	/** Formerly ChaosPentagon(), now ChaosPolygon, I figured out how to generalize the chaos game and vertex choice restrictions.
	 * @param iterations Number of dots to draw in the chaos game
	 * @param numSides Number n of sides for the n-gon to draw. ex. 3 is a triangle, 4 is a square, etc.
	 * @param restrictions
	 */
	public void chaosPolygon(Options options) {
		int numSides = options.args[0];
		int iterations = options.args[1];
		Color cold = options.colors[0];
		Color warm = options.colors[1];;
		Color hot = options.colors[2];;
		VertexRestrictions[] restrictions = options.restrictions;
		Coordinates[] vertex = new Coordinates[numSides];
		
		
		//		*************** Math for a regular pentagon ******************
		//Adjusting the rotational offset of the polygon so it's symmetrical along the vertical axis
		double i;
		if (numSides % 2 != 0) {
			i = -Math.PI/(2*numSides);
		}//Even sided polygons are already symmetrical, so there's no need to rotate them.
		else {
			i = 0;
		}
		for(int k = 0; k < vertex.length; k++) {
			vertex[k] = new Coordinates((int)Math.rint(((2f * numSides / 5)*grid.getHorizontalLEDs()/numSides)*Math.cos(i))+grid.getHorizontalLEDs()/(2), 
					(int)Math.rint(((2f * numSides / 5)*grid.getVerticalLEDs()/numSides)*Math.sin(i))+grid.getVerticalLEDs()/(2));
			i += 2*Math.PI/numSides;
		}
<<<<<<< HEAD
		
//		//drawing the polygon TODO Make this a Toggle-able option
//		for (int k = 0; k <= (numSides-1); ++k) {
//			addLine(vertex[k], vertex[Math.floorMod(k+1, numSides)]);
//		}
		
		Coordinates pencil = new Coordinates(grid.getHorizontalLEDs()/2, grid.getHorizontalLEDs()/2);
		Coordinates chosenVert; //once a vertex has been chosen, it's set here.
		int vertexBuffer = 0; //Buffer for Chaos restrictions
		int vertexBuffer2 = 0;

		//Selecting a random point
			pencil.x = rand.nextInt((3*grid.getHorizontalLEDs()/numSides)+1) + (1*grid.getHorizontalLEDs()/numSides);
			pencil.y = rand.nextInt((3*grid.getVerticalLEDs()/numSides)+1) + (1*grid.getVerticalLEDs()/numSides);
			int mostPicked = 0;
			for(int j = 0; j <= iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				if (options.equal) 
					do {									//Selecting a random vertex, loops until we get a vertex that passes the restrictions
						vertIndex = rand.nextInt(numSides);
					} while (!vertexValidation(vertIndex, vertexBuffer, numSides, restrictions[0]) && !vertexValidation(vertIndex, vertexBuffer2, numSides, restrictions[1])); //The magic that is Vertex restrictions
				else 
					do {									//Selecting a random vertex, loops until we get a vertex that passes the restrictions
						vertIndex = rand.nextInt(numSides);
					} while (!vertexValidation(vertIndex, vertexBuffer, numSides, restrictions[0]) || !vertexValidation(vertIndex, vertexBuffer2, numSides, restrictions[1])); //Magic

				chosenVert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffers for next iteration

				//moving halfway to that vertex
				pencil.x = (chosenVert.x + pencil.x)/2; //TODO add argument to change distance to next vertex
				pencil.y = (chosenVert.y + pencil.y)/2;
				
				int timesPicked = at(pencil).getTimesPicked();
		
				//The Equation for getting the new color
				//For new red value R, percentage p, starting color c2, ending color c1: R = (c1.R * p) + (c2 * (1-p))
				double rate = (timesPicked % 100)/100d;
				int threshold = 100;

				try {
					 //A percentage that goes from 0% to 100% 3 times between 0 and 'number of iterations'
					if (timesPicked < threshold ) {
						pencil.mark = new Mark(
								(int)Math.rint((cold.getRed() * rate) + (Color.BLACK.getRed())  * (1-rate)),
								(int)Math.rint((cold.getGreen() * rate) + (Color.BLACK.getGreen())* (1-rate)),
								(int)Math.rint((cold.getBlue() * rate) + (Color.BLACK.getBlue()) * (1-rate)),
								pencil.mark.getAlpha(),
								at(pencil).getTimesPicked() + 1);
					}
					else if (timesPicked >= threshold && timesPicked < threshold*2) {
						pencil.mark = new Mark(
								(int)Math.rint((warm.getRed() * rate) + (cold.getRed())  * (1-rate)),
								(int)Math.rint((warm.getGreen() * rate) + (cold.getGreen())* (1-rate)),
								(int)Math.rint((warm.getBlue() * rate) + (cold.getBlue()) * (1-rate)),
								pencil.mark.getAlpha(),
								at(pencil).getTimesPicked() + 1);
					}
					else if (timesPicked >= threshold*2 && timesPicked < threshold*3) {//&& timesPicked < threshold*3
						pencil.mark = new Mark(
								(int)Math.rint((hot.getRed() * rate) + (warm.getRed())  * (1-rate)),
								(int)Math.rint((hot.getGreen() * rate) + (warm.getGreen())* (1-rate)),
								(int)Math.rint((hot.getBlue() * rate) + (warm.getBlue()) * (1-rate)),
								pencil.mark.getAlpha(),
								at(pencil).getTimesPicked() + 1);
					}
					else pencil.mark = new Mark(hot,
							at(pencil).getTimesPicked() + 1);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				//Placing a point at that location
				addPoint(pencil);
				grid.repaint(); //Refreshing the drawing, to make kind of an 'animation' move it to the other side of the bracket to only see the complete drawing.
=======

		//		//drawing the polygon TODO Make this a Toggle-able option
		//		for (int k = 0; k <= (numSides-1); ++k) {
		//			addLine(vertex[k], vertex[Math.floorMod(k+1, numSides)]);
		//		}


		int numberOfTasks = 10;
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		try { 
			for(int k = 0 ; k <= numberOfTasks; k++) {
				executor.execute(new Runnable() {
					@Override
					public void run() {
						int vertexBuffer = 0; //Buffer for Chaos restrictions
						int vertexBuffer2 = 0;
						Coordinates pencil = new Coordinates(grid.getHorizontalLEDs()/2, grid.getHorizontalLEDs()/2);
						Coordinates chosenVert; //once a vertex has been chosen, it's set here.


						//Selecting a random point
						pencil.x = rand.nextInt((3*grid.getHorizontalLEDs()/numSides)+1) + (1*grid.getHorizontalLEDs()/numSides);
						pencil.y = rand.nextInt((3*grid.getVerticalLEDs()/numSides)+1) + (1*grid.getVerticalLEDs()/numSides);

						for(int j = 0; j <= iterations/numberOfTasks; j++) { //Number of dots to draw, more dots for a clearer fractal

							int vertIndex;
							if (options.equal) 
								do {									//Selecting a random vertex, loops until we get a vertex that passes the restrictions
									vertIndex = rand.nextInt(numSides);
								} while (!vertexValidation(vertIndex, vertexBuffer, numSides, restrictions[0]) && !vertexValidation(vertIndex, vertexBuffer2, numSides, restrictions[1])); //The magic that is Vertex restrictions
							else 
								do {									//Selecting a random vertex, loops until we get a vertex that passes the restrictions
									vertIndex = rand.nextInt(numSides);
								} while (!vertexValidation(vertIndex, vertexBuffer, numSides, restrictions[0]) || !vertexValidation(vertIndex, vertexBuffer2, numSides, restrictions[1])); //Magic

							chosenVert = vertex[vertIndex];

							vertexBuffer2 = vertexBuffer;
							vertexBuffer = vertIndex; //Set vertex buffers for next iteration

							//moving halfway to that vertex
							pencil.x = (chosenVert.x + pencil.x)/2; //TODO add argument to change distance to next vertex
							pencil.y = (chosenVert.y + pencil.y)/2;

							int timesPicked = at(pencil).getTimesPicked();

							//The Equation for getting the new color
							//For new red value R, percentage p, starting color c2, ending color c1: R = (c1.R * p) + (c2 * (1-p))
							double rate = 1-((timesPicked % 100)/100d);
							int threshold = 100;

							try {
								//A percentage that goes from 0% to 100% 3 times between 0 and 'number of iterations'
								if (timesPicked < threshold ) {
									pencil.mark = new Mark(
											(int)Math.rint((Color.BLACK.getRed() * rate) + (cold.getRed())  * (1-rate)),
											(int)Math.rint((Color.BLACK.getGreen() * rate) + (cold.getGreen())* (1-rate)),
											(int)Math.rint((Color.BLACK.getBlue() * rate) + (cold.getBlue()) * (1-rate)),
											pencil.mark.getAlpha(),
											at(pencil).getTimesPicked() + 1);
								}
								else if (timesPicked >= threshold && timesPicked < threshold*2) {
									pencil.mark = new Mark(
											(int)Math.rint((cold.getRed() * rate) + (warm.getRed())  * (1-rate)),
											(int)Math.rint((cold.getGreen() * rate) + (warm.getGreen())* (1-rate)),
											(int)Math.rint((cold.getBlue() * rate) + (warm.getBlue()) * (1-rate)),
											pencil.mark.getAlpha(),
											at(pencil).getTimesPicked() + 1);
								}
								else if (timesPicked >= threshold*2 && timesPicked < threshold*3) {//&& timesPicked < threshold*3
									pencil.mark = new Mark(
											(int)Math.rint((warm.getRed() * rate) + (hot.getRed())  * (1-rate)),
											(int)Math.rint((warm.getGreen() * rate) + (hot.getGreen())* (1-rate)),
											(int)Math.rint((warm.getBlue() * rate) + (hot.getBlue()) * (1-rate)),
											pencil.mark.getAlpha(),
											at(pencil).getTimesPicked() + 1);
								}
								else pencil.mark = new Mark(at(pencil).brighter(),
										at(pencil).getTimesPicked() + 1);
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							}
							//Placing a point at that location
							addPoint(pencil);
							grid.repaint(); //Refreshing the drawing, to make kind of an 'animation' move it to the other side of the bracket to only see the complete drawing.
							
						}
					}
				});
>>>>>>> parent of cf0cf98... Revert "Made the plotting function work in parrallel"
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.shutdown();

	}
	/** Returns true if the supplied vertex passes all tests supplied by the supplied VertexRestrictions, returns false otherwise.
	 * @param vertex0 The Current Vertex (index) that must be checked against the chosen vertex restrictions
	 * @param vertex1 The Previous Vertex (index) or the vertex to check against vertex0 (The Vertex Buffer)
	 * @param numSides number of Sides of the current polygon, for use in modulus functions for adjacency and offset
	 * @param restrictions A collection of restrictions for determining the rules for selecting a new vertex.
	 */
	public boolean vertexValidation(int vertex0, int vertex1, int numSides, VertexRestrictions restrictions) {
		if (restrictions.isEquivalencePreference()) { //
			if (restrictions.isEquivalenceTrue()) {
				if(vertex0 != vertex1) return false; 	//Current vertex (vertex0) Must be equivalent to previous vertex (vertex1)
			}
			if (!restrictions.isEquivalenceTrue()) {
				if(vertex0 == vertex1) return false; 	//Must be not equivalent
			}
		}
		if (restrictions.isAdjacentPreference()) {
			if (restrictions.isAdjacentTrue()) {
				if(((vertex1 + 1)%numSides != vertex0) && ((vertex1 + (numSides- 1))%numSides != vertex0)) return false; //Must be Adjacent
			}
			if (!restrictions.isAdjacentTrue()) {
				if(((vertex1 + 1)%numSides == vertex0) || ((vertex1 + (numSides- 1))%numSides == vertex0)) return false; //Must be not adjacent. Yes it's different than !adjacent, as we need to be able express no preference.
			}
		}
		if (restrictions.isOffset1Preference() && restrictions.isOffset2Preference()) {//Both offsets are selected, this is to make sure there isn't any conflict in the 'must be' rules
			
			if (restrictions.isOffset1True() && restrictions.isOffset2True()) {
				if(((vertex1 + restrictions.getOffset1Integer())%numSides != vertex0) && ((vertex1 + restrictions.getOffset2Integer())%numSides != vertex0)) return false;//
			}
			else if (restrictions.isOffset1True() && !restrictions.isOffset2True()) {
				if(((vertex1 + restrictions.getOffset1Integer())%numSides != vertex0) && ((vertex1 + restrictions.getOffset2Integer())%numSides == vertex0)) return false;
			}
			else if (!restrictions.isOffset1True() && restrictions.isOffset2True()) {
				if(((vertex1 + restrictions.getOffset1Integer())%numSides == vertex0) && ((vertex1 + restrictions.getOffset2Integer())%numSides != vertex0)) return false;
			}
			else if (!restrictions.isOffset1True() && !restrictions.isOffset2True()) {
				if(((vertex1 + restrictions.getOffset1Integer())%numSides == vertex0) || ((vertex1 + restrictions.getOffset2Integer())%numSides == vertex0)) return false;
			}
			
		}
		else if (restrictions.isOffset1Preference() && !(restrictions.isOffset2Preference())) {//Only Offset1
			if (restrictions.isOffset1True()) {
				if((vertex1 + restrictions.getOffset1Integer())%numSides != vertex0) return false; //Must be offset         --The offsets 1 and 2 can be used together to create a rule identical to adjacency
			}
			else if(!restrictions.isOffset1True()) {
				if((vertex1 + restrictions.getOffset1Integer())%numSides == vertex0) return false; //Must be not offset
			}
		}
		else if (restrictions.isOffset2Preference() && !restrictions.isOffset1Preference()) {//Only Offset2
			if (restrictions.isOffset2True()) {
				if((vertex1 + restrictions.getOffset2Integer())%numSides != vertex0) return false; //Must be offset 2
			}
			else if (!restrictions.isOffset2True()) {
				if((vertex1 + restrictions.getOffset2Integer())%numSides == vertex0) return false; //Must be not offset 2
			}
		}
		return true; //if vertex0 passes the gauntlet of restriction checks, return true, otherwise it got sent home where it failed. There's not really a need to go through the rest of the tests if it fails once.
	}
	/** Method for determining which side of a line a point is. Useful for finding a point within a shape.
	 * @param a First coordinate of the line
	 * @param b Second Coordinate of the line
	 * @param pencil The point in question
	 * @return True if the point is on the right side of the line, point a being on the top. So if the point is on the left of the line, but a is below b, the answer will still be true.
	 */
	public boolean onRight(Coordinates a, Coordinates b, Coordinates pencil) {
		return ((b.x - a.x)*(pencil.y - a.y)-(pencil.x - a.x)*(b.y - a.y) < 0);
	}
}


