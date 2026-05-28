import java.util.*;

public class StockGraphTraversal {

    private int vertices;
    private LinkedList<Integer> adj[];

    // Constructor
    StockGraphTraversal(int v) {

        vertices = v;

        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add Edge
    void addEdge(int v, int w) {

        adj[v].add(w);
    }

    // BFS Traversal
    void BFS(int s) {

        boolean visited[] = new boolean[vertices];

        LinkedList<Integer> queue =
                new LinkedList<Integer>();

        visited[s] = true;

        queue.add(s);

        while (queue.size() != 0) {

            s = queue.poll();

            System.out.print(s + " ");

            Iterator<Integer> i =
                    adj[s].listIterator();

            while (i.hasNext()) {

                int n = i.next();

                if (!visited[n]) {

                    visited[n] = true;

                    queue.add(n);
                }
            }
        }
    }

    // DFS Traversal
    void DFSUtil(int v,
                 boolean visited[]) {

        visited[v] = true;

        System.out.print(v + " ");

        Iterator<Integer> i =
                adj[v].listIterator();

        while (i.hasNext()) {

            int n = i.next();

            if (!visited[n])

                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {

        boolean visited[] =
                new boolean[vertices];

        DFSUtil(v, visited);
    }

    // Main Method
    public static void main(String args[]) {

        StockGraphTraversal g =
                new StockGraphTraversal(6);

        // Stock Connections
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        System.out.println(
                "BFS Traversal:"
        );

        g.BFS(0);

        System.out.println(
                "\n\nDFS Traversal:"
        );

        g.DFS(0);
    }
}