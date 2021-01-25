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
## Sierpinski Triangle
![Sierpinski Triangle](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Serpinksi%20Triangle.png?raw=true)  
Red -> Orange -> Yellow, 10000000 iterations   
## Pentagon Faces
![Pentagon Faces](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Pentagon%202.png?raw=true)  
Red -> Orange -> Yellow, 10000000 iterations   
## Heptagonal Star
![Heptagonal Star](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Heptagon%20Star.png?raw=true)  
Red -> Orange -> Yellow, 10000000 iterations  
## 9-gon Biohazard
![9-gon Biohazard](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Biohazard.png?raw=true)  
Green -> Cyan -> White, 10000000 iterations  
## Snowflake
![Snowflake](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Snow%20Flake.png?raw=true)  
White -> Cyan -> Blue, 10000000 iterations  
## Unnamed Chaos Square
![Chaos Square](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Chaos%20Square.png?raw=true)  
Red -> Orange -> Yellow, ~15000000 iterations  
## Hexagonal Twisted Star
![Hexagonal Twisted Star](https://github.com/BLARGoMATIC/MathGraphics/blob/master/Pictures/Red%20and%20White%20hexagonal%20star.png?raw=true)  
Red -> Orange -> Yellow, 15000000 iterations    

and many more...  
another tip: in dealing with lots of false values, 'and' works like 'or' and vice-versa.

Future plans include arbitrary attractors
