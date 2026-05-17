# Graph Traversal and Representation System

 Overview 

This project implements graph traversal algorithms using adjacency list representation in Java.

Implemented algorithms:
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

Graphs with 10, 30, and 100 vertices were tested.

---

# Classes

## Vertex
Represents graph vertex.

## Edge
Represents connection between vertices.

## Graph
Stores adjacency list and implements:
- addVertex()
- addEdge()
- bfs()
- dfs()
- printGraph()

## Experiment
Runs traversal tests and measures execution time.

---

# Graph Representation

The graph is stored using adjacency lists.

Example:

```text
0 -> [1, 2]
1 -> [0, 3]
2 -> [0]
3 -> [1]
BFS

BFS visits vertices level by level using Queue.

Time Complexity:

O(V + E)

Use cases:

shortest path
social networks
DFS

DFS explores deeply before backtracking using recursion.

Time Complexity:

O(V + E)

Use cases:

maze solving
cycle detection
Experimental Results

Graphs tested:

10 vertices
30 vertices
100 vertices

Execution time was measured using:

System.nanoTime()

Observations:

larger graphs require more traversal time
BFS and DFS both follow O(V + E)
Reflection

This assignment helped me understand graph traversal and adjacency lists better.

I learned the difference between BFS and DFS and how recursion works in DFS