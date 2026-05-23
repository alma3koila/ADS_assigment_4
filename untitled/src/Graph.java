import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // add edge
    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    // print graph
    public void printGraph() {

        System.out.println("Adjacency List:");

        for (Integer vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            System.out.println(adjacencyList.get(vertex));
        }
    }

    // BFS Traversal
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);

        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsHelper(start, visited);

        System.out.println();
    }

    // recursive DFS
    private void dfsHelper(int vertex, Set<Integer> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {

            if (!visited.contains(neighbor)) {

                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra Algorithm
    public void dijkstra(int start) {

        int vertices = adjacencyList.size();

        int[] distance = new int[vertices];

        boolean[] visited = new boolean[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {

            int minVertex = -1;

            for (int j = 0; j < vertices; j++) {

                if (!visited[j] &&
                        (minVertex == -1 ||
                                distance[j] < distance[minVertex])) {

                    minVertex = j;
                }
            }

            visited[minVertex] = true;

            for (int neighbor : adjacencyList.get(minVertex)) {

                int weight = 1;

                if (!visited[neighbor] &&
                        distance[minVertex] + weight < distance[neighbor]) {

                    distance[neighbor] =
                            distance[minVertex] + weight;
                }
            }
        }

        System.out.println("\nDijkstra Shortest Paths:");

        for (int i = 0; i < vertices; i++) {

            System.out.println(
                    "0 -> " + i +
                            " = " + distance[i]
            );
        }
    }
}