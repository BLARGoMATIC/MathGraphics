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

# Some Results
![Serpinski Triangle](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Serpinksi%20Triangle.png?raw=true)
![Pentagon current vertex cannot equal previous vertex](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Pentagon%202.png?raw=true)
![Example-Picture1](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Heptagon%20Star.png?raw=true)
![Example-Picture2](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Biohazard.png?raw=true)  
Green -> Cyan -> White, 10000000 iterations  
v1 Equal = N, Adjacent = NP, offset 1 (N) = 1, offset 2 (N) = 7  
or  
v2 Equal = NP, Adjacent = NP, offset 1 (N) = 4, offset 2 (N) = 2  
![Example-Picture3](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Snow%20Flake.png?raw=true)  
White -> Cyan -> Blue, 10000000 iterations  
v1 Equal = NP, Adjacent = NP, offset 1 (N) = 4, offset 1 (N) = 2  
or  
v2 Equal = NP, Adjacent = N, offset 1 (N) = 0, offset 2 (N) = 0  
![Example-Picture4](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Square.png?raw=true)
![Example-Picture4](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Red%20and%20White%20hexagonal%20star.png?raw=true)

... and many more
