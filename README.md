https://en.wikipedia.org/wiki/Chaos_game

# Rules

1. Take a given shape (Just regular polygons in this case).
2. Plot a Random point
3. Pick a random vertex (with restrictions)
4. Go halfway to that vertex and plot a point
5. Repeat steps 3-4 1000000 times
6. Get pretty fractal

# Vertex Restrictions
No Prefence - Pure random
Equivalence - must be or must not be equal to the last chosen vertex (v-1) and/or the vertex before last (v-2)
Adjacency - must be or must not be adjacent to (v-1) and/or (v-2)
Offset - Similar to Adjacency but a custom number of 'hops' over instead of just 1

# Results
![Serpinski Triangle](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Serpinksi%20Triangle.png?raw=true)
![Pentagon current vertex cannot equal previous vertex](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Pentagon%202.png?raw=true)
![Example-Picture2](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Hexagon%20Star.png?raw=true)
![Example-Picture3](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Pentagon.png?raw=true)
![Example-Picture4](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Octogon%20Star.png?raw=true)
![Example-Picture4](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Hexagon.png?raw=true)
... and many more
