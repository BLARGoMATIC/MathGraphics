package mathGraphics;

import java.awt.Color;
import java.security.SecureRandom;

public class DrawPatterns {

	LEDGrid grid;
	SecureRandom rand = new SecureRandom();
	public DrawPatterns(LEDGrid grid) {
		this.grid = grid;
	}
	public void at(int x, int y, Color c) { //similar to addPoint() however this one uses a Modulus to create a window wrapping function.
		x = Math.floorMod(x, grid.numHorizontalLEDs);
		y = Math.floorMod(y, grid.numVerticalLEDs);
		grid.leds[x][y] = c;
	}
	public void addPoint(Coordinates a) {
		at(a.x, a.y, a.c);
	}

	public void addPoint(int x, int y) {
		at(x, y, Color.WHITE);
	}
	public void addPoint(int x, int y, Color c) {
		at(x, y, c);
	}

	public void addLine(int x0, int y0, int x1, int y1) {//start color, end color

		int maxDif = Math.max(Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0)), 1);
		int i;
		int j = 0;
		try {
			for(i = 0; i <= maxDif; i++) {
				at((x0 + (i * (x1 - x0) / maxDif)),(y0 + (i * (y1 - y0) / maxDif)), Color.WHITE);
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
			at(		(x0 + i * (x1 - x0) / maxDif),
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
				at((a.x + (i * (b.x - a.x) / maxDif)),(a.y + (i * (b.y - a.y) / maxDif)), new Color(
						a.c.getRed()		+ i * (b.c.getRed() 		- a.c.getRed()	)	/maxDif,
						a.c.getGreen() 	+ i * (b.c.getGreen() 	- a.c.getGreen()	)	/maxDif,
						a.c.getBlue() 	+ i * (b.c.getBlue() 	- a.c.getBlue()	)	/maxDif));
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
	public void addTriangle(int x0, int y0,        // Start
			int x1, int y1,        // Mid
			int x2, int y2,        // End
			Color c) {
		// draw side 1
		addLine( x0, y0, x1, y1, c, c);
		// ... draw the other two sides ...
		addLine( x1, y1, x2, y2, c, c);
		addLine( x2, y2, x0, y0, c, c);
	}

	public void addTriangle(int x0, int y0,        // Start
			int x1, int y1,        // Mid
			int x2, int y2,        // End
			Color c0, Color c1, Color c2) {  // Colors for vertices 0, 1, 2
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
		//		for(double i = 0; i <= (2*Math.PI); i += (2*Math.PI)/360) {//Java calculates sin and cos in radians, so I have to convert to degrees
		//			mathGraphics.leds
		//				[(int) Math.rint(x + radius * Math.cos(i))]
		//				[(int) Math.rint(y + radius * Math.sin(i))]
		//						= new Color(color.getRed(),color.getGreen(),color.getBlue());
		//		}
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
		theta = theta * Math.PI/180;
		for(double i = theta; i <= theta+(2*Math.PI); i += (2*Math.PI)/15000) {//Java calculates sine and cosine in radians, so I have to convert to degrees

			int ledX = (int) Math.rint(x + radius * Math.cos(i)); //Find x coordinate and round to nearest int.
			int ledY = (int) Math.rint(y + radius * Math.sin(i)); //Find y coordinate and round to nearest int.

			if(i <= (theta + Math.PI)) {//First half of the circle
				at(ledX, ledY, new Color(
						(int)Math.rint(c0.getRed()		+ (i-theta) * (c1.getRed() 		- c0.getRed()	)	/(Math.PI)),
						(int)Math.rint(c0.getGreen() 	+ (i-theta) * (c1.getGreen() 	- c0.getGreen()	)	/(Math.PI)),	//This half changes from color1 to color2
						(int)Math.rint(c0.getBlue() 	+ (i-theta) * (c1.getBlue() 	- c0.getBlue()	)	/(Math.PI))));
			}
			else {		//second half
				at(ledX,ledY, new Color(
						(int)Math.rint(c1.getRed()		+ ((i-theta)-Math.PI) * (c0.getRed() 	- c1.getRed()	)	/(Math.PI)),
						(int)Math.rint(c1.getGreen() 	+ ((i-theta)-Math.PI) * (c0.getGreen() 	- c1.getGreen()	)	/(Math.PI)),	//This half changes from color2 to color1
						(int)Math.rint(c1.getBlue() 	+ ((i-theta)-Math.PI) * (c0.getBlue() 	- c1.getBlue()	)	/(Math.PI))));	
				//The (i-Math.PI) in the middle is required to avoid an outOfBounds exception
				//(i-Math.PI) is 'i' subtract a half-circle in radians,
				//since I want the color gradient to reset halfway through the circle.
			}			
		}
		//		//Location for color filling
		//		int ledX = 0;
		//		int ledY = 0;
		//		if((ledX >= 0 & ledX <= 99) && (ledY >= 0 && ledY <= 99)) {
		//
		//		}
		//		if(ledY >= 0 && ledY <= 99) {
		//		}
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
			addCircle(0,k,grid.numHorizontalLEDs/2,grid.numVerticalLEDs/2, c1, c2); //Draw many circles in the center, gradually getting bigger
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
			//			addSquare(x, y, size, rotation);
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
	 * 
	 */
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
			//			z.c = new Color(rand.nextInt(255)+1,rand.nextInt(255)+1,rand.nextInt(255)+1);

			//Placing a point at current location
			addPoint(z);
			grid.repaint();
			//			try {
			//				Thread.sleep(1);
			//			} catch (InterruptedException e) {
			//				e.printStackTrace();

		}
	}

	
	public void chaosPolygon(int style, int iterations, int numSides) {
		Coordinates[] vertex = new Coordinates[numSides];
		
		//		*************** Math for a regular pentagon ******************
		double i = -Math.PI/(numSides);
		if (numSides % 2 != 0) {
			i = -Math.PI/(2*numSides);
			System.out.println("odd");
			System.out.println(Integer.toString(numSides));
		}
		else {
			i = 0;
			System.out.println("even");
			System.out.println(Integer.toString(numSides));
		}
		for(int k = 0; k < vertex.length; k++) {
			vertex[k] = new Coordinates((int)Math.rint((2*grid.numHorizontalLEDs/numSides)*Math.cos(i))+grid.numHorizontalLEDs/2, 
										(int)Math.rint((2*grid.numVerticalLEDs/numSides)*Math.sin(i))+grid.numVerticalLEDs/2);
			i += 2*Math.PI/numSides;
		}
		
		//drawing the pentagon
		for (int k = 0; k <= (numSides-1); ++k) {
			addLine(vertex[k], vertex[Math.floorMod(k+1, numSides)]);
		}
		
		Coordinates pencil = new Coordinates(grid.numHorizontalLEDs/2, grid.numHorizontalLEDs/2);
		Coordinates vert = vertex[0]; //to be initialized later
		int vertexBuffer = 0; //Buffer for Chaos restrictions
		int vertexBuffer2 = 0;

		//Selecting a random point
			pencil.x = rand.nextInt((3*grid.numHorizontalLEDs/numSides)+1) + (1*grid.numHorizontalLEDs/numSides);
			pencil.y = rand.nextInt((3*grid.numVerticalLEDs/numSides)+1) + (1*grid.numVerticalLEDs/numSides);

		// Selection of fractal style.
		if(iterations <= 0) iterations = 100000;
		switch(style) {
		case 1 :
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);
				} while (vertIndex == vertexBuffer); //Method 1, chosen vertex cannot be previous vertex.

				vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		case 2 :
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);

				} while (
			 //					 vertIndex == vertexBuffer || //include or exclude for differing behavior
								(vertIndex == ((vertexBuffer  + 1) % numSides) |
								 vertIndex == ((vertexBuffer  + 4) % numSides) )&(
								 vertIndex == ((vertexBuffer2 + 1) % numSides) |
								 vertIndex == ((vertexBuffer2 + 4) % numSides) )); //Method 2, chosen vertex cannot be adjacent to previous 2 vertices
								 vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		case 3:
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);

				} while (
								 vertIndex == vertexBuffer || //include or exclude for differing behavior
								(vertIndex == ((vertexBuffer  + 1) % numSides) |
								 vertIndex == ((vertexBuffer  + (numSides - 1)) % numSides) )&(
								 vertIndex == ((vertexBuffer2 + 1) % numSides) |
								 vertIndex == ((vertexBuffer2 + (numSides - 1)) % numSides) )); //Method 3, chosen vertex cannot be or adjacent to previous 2 vertices
								 vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		case 4:
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);

				} while (
							vertIndex == vertexBuffer ||
									(vertIndex == ((vertexBuffer  + 2) % numSides) |
									 vertIndex == ((vertexBuffer  + (numSides - 2)) % numSides) )&(
									 vertIndex == ((vertexBuffer2 + 2) % numSides) |
									 vertIndex == ((vertexBuffer2 + (numSides - 2)) % numSides) )); //Method 4, chosen vertex must be adjacent to previous 2 vertices
								 vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		case 5:
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);

				} while (
//							vertIndex == vertexBuffer ||
//									(vertIndex == ((vertexBuffer  + 1) % 5) |
									 vertIndex == ((vertexBuffer  + 4) % numSides) ); //Method 5, chosen vertex must be adjacent to previous vertex
								 	vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		default:
			for(int j = 0; j < iterations; j++) { //Number of dots to draw, more dots for a clearer fractal

				int vertIndex;
				do {	//Selecting a random vertex
					vertIndex = rand.nextInt(numSides);

				} while (vertIndex == vertexBuffer); //Method 1, chosen vertex cannot be previous vertex.

				vert = vertex[vertIndex];

				vertexBuffer2 = vertexBuffer;
				vertexBuffer = vertIndex; //Set vertex buffer for next iteration

				//moving halfway to that vertex
				pencil.x = (vert.x + pencil.x)/2;
				pencil.y = (vert.y + pencil.y)/2;

				pencil.c = grid.leds[pencil.x][pencil.y].brighter();

				//Placing a point at current location
				addPoint(pencil);
				grid.repaint();
			}
			break;
		}
	}
	// Currently unused, now using chaosPolygon(), previously chaosPentagon()
	@SuppressWarnings("unused")
	@Deprecated
	public void chaosHexagon(int style, int iterations) {
		
		int numSides = 6;
		Coordinates[] vertex = new Coordinates[6]; //array of vertices, 6 for a hexagon
		
		//Math for a regular hexagon, finding the coordinates of the vertices
		double i = Math.toRadians(0); //Offset of first vertex
		for(int k = 0; k < vertex.length; k++) {
			vertex[k] = new Coordinates((int)Math.rint((2*grid.numHorizontalLEDs/numSides)*Math.cos(i))+grid.numHorizontalLEDs/2,
										(int)Math.rint((2*grid.numVerticalLEDs/numSides)*Math.sin(i))+grid.numVerticalLEDs/2);
			i += 2*Math.PI/numSides;
		}
		//drawing the hexagon
		for (int k = 0; k < numSides; ++k) {
			addLine(vertex[k], vertex[Math.floorMod(k+1, numSides)]);
		}

		Coordinates pencil = new Coordinates(grid.numHorizontalLEDs/2, grid.numHorizontalLEDs/2);
		Coordinates vert = vertex[0]; //to be initialized later
		int vertexBuffer = 0; //Buffer for vertex choice restrictions in the chaos game
		int vertexBuffer2 = 0; //second buffer for vertex restrictions

		//Selecting a random point
		pencil.x = rand.nextInt((3*grid.numHorizontalLEDs/5)+1) + (1*grid.numHorizontalLEDs/5);
		pencil.y = rand.nextInt((3*grid.numVerticalLEDs/5)+1) + (1*grid.numVerticalLEDs/5);
	}

	/** Method for determining which side of a line a point is. Useful for finding a point within a shape.
	 * @param a First coordinate of the line
	 * @param b Second Coordinate of the line
	 * @param pencil The point in question
	 * @return True if the point is on the right side of the line, point a being on the top. So if the point is on the left of the line, but a is below b, the answer will still be true.
	 */
	public boolean onRight(Coordinates a, Coordinates b, Coordinates pencil) {
		boolean result = false;
		int res = (b.x - a.x)*(pencil.y - a.y)-(pencil.x - a.x)*(b.y - a.y);

		////	For testing purposes; a way for the program to 'show its work' in the debugger.
		//		int res1a = (b.x - a.x);
		//		int res1b = (z.y - a.y);
		//		int res1 = res1a*res1b;
		//		int res2a = (z.x - a.x);
		//		int res2b = (b.y - a.y);
		//		int res2 = res2a*res2b;
		//		int res = res1 - res2;

		if(res > 0) {//left side
			result = false;
			//			System.out.println("on the left");
		}
		else if(res == 0) {//on the line
			result = false;
			//			System.out.println("on the line");
		}
		else if(res < 0) {//right side
			result = true;
			//			System.out.println("on the right");
		}
		return result;
	}

}


