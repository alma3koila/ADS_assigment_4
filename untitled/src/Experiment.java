public class Experiment {

    // run traversals and measure time
    public void runTraversals(Graph g) {

        long startBFS = System.nanoTime();

        g.bfs(0);

        long endBFS = System.nanoTime();

        long startDFS = System.nanoTime();

        g.dfs(0);

        long endDFS = System.nanoTime();

        g.dijkstra(0);

        System.out.println(
                "BFS Time: " +
                        (endBFS - startBFS) +
                        " ns"
        );

        System.out.println(
                "DFS Time: " +
                        (endDFS - startDFS) +
                        " ns"
        );
    }

    // create graphs with different sizes
    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n==============================");

            System.out.println("Graph Size: " + size);

            System.out.println("==============================");

            Graph g = new Graph();

            // add vertices
            for (int i = 0; i < size; i++) {

                g.addVertex(new Vertex(i));
            }

            // add edges
            for (int i = 0; i < size - 1; i++) {

                g.addEdge(i, i + 1);
            }

            // additional edges
            for (int i = 0; i < size - 2; i += 2) {

                g.addEdge(i, i + 2);
            }

            // print only small graph
            if (size == 10) {

                g.printGraph();
            }

            runTraversals(g);
        }
    }

    public void printResults() {

        System.out.println(
                "\nExperiment completed successfully."
        );
    }
}