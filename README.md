# Ice Game
## Ice Game made using Java for a research about Big O Notation

This project consists of a game where the player is sliding on ice from the starting position and bouncing off obstacles until they 
finish the maze by reaching the finish point. The player cannot change directions unless they hit an obstacle. The maze is found in 
a text file format where "." represents ice, "0" represents obstacles, "S" represents the starting point and "F" represents the finish
point. 

The Breadth First Search algorithm is applied on an Adjacency List Graph which represents the maze in the selected text file to ultimately find 
the shortest path from the starting point to the finish point. The program starts at the starting point and traverses all possible paths by bouncing
off obstacles until they reach the finish point. The analysis for Big O Notation is done by using different mazes where the size of the maze doubles 
each time to finally compare how the time complexity of the program changes.

## Program Example #1

Input:

![image](https://github.com/inuksperera/iceGameJava/assets/110172780/a47efb70-8017-420b-a6e6-631b746f4249)

Output:
![image](https://github.com/inuksperera/iceGameJava/assets/110172780/c09e9a67-86a3-4744-92f9-8b2e13c4f50d)


## Program Example #2

Input:
![image](https://github.com/inuksperera/iceGameJava/assets/110172780/9e8b0c5c-2c57-456b-a780-8c08b2ed61b5)
Output:
![image](https://github.com/inuksperera/iceGameJava/assets/110172780/fafa7412-5c50-4c24-8e8e-f799550355ee)




