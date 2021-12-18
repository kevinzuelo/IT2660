import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {
    private Listing vertex[];
    private int edge[][];
    private final int max;
    private int numberOfVertices;
    private Deque<Integer> adjList[];

    public Graph(int n) {
        vertex = new Listing[n];
        edge = new int[n][n];
        max = n;
        numberOfVertices = 0;
        adjList = new Deque[n];
        
        for(int i =0; i< n; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getMax() {
        return max;
    }

    public boolean insertVertex(int vertexNumber, Listing newListing) {
        if(vertexNumber >= max)
            return false;
        vertex[vertexNumber] = newListing.deepCopy();
        numberOfVertices++;
        return true;
    }

    public boolean insertEdge(int fromVertex, int toVertex) {
        if(vertex[fromVertex] == null || vertex[toVertex] == null) 
            return false;
        edge[fromVertex][toVertex] = 1;
        adjList[fromVertex].add(toVertex);
        return true;
    }

    public void showVertex(int vertexNumber) {
        System.out.println(vertex[vertexNumber]);
    }
    
    public void showEdges(int vertexNumber) {
        for(int column =0; column < numberOfVertices; column++) {
            if(edge[vertexNumber][column] == 1)
                System.out.println(vertexNumber + "," + column);
        }
    }

    public void depthFirst(int firstVertex, int userSearch) {
        int v;
        int examinedNodeCounter = 0;
        boolean found = false;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < numberOfVertices; i++) {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
        }

        stack.push(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!stack.isEmpty()) {
            v = stack.pop();
            examinedNodeCounter++;

            if(vertex[v].getValue() == userSearch) {
                found = true;
                System.out.println(userSearch + " was found.");
                System.out.println("The amount of Nodes examined using DFS were " + examinedNodeCounter);
            }           
            
            for(int column = 0; column < numberOfVertices; column++) {
                if(edge[v][column] == 1 && !vertex[column].getPushed()) {
                    stack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
        if(!found) {
            System.out.println(userSearch + " was not found.");
        }
    }

    public void breadthFirst(int firstVertex, int userSearch) {
        Deque<Integer> queue = new ArrayDeque<>();
        int examinedNodeCounter = 0;
        boolean visited[] = new boolean[numberOfVertices];
        boolean found = false;
        Listing[] prev = new Listing[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++) {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
        }

        visited[firstVertex] = (true);
        queue.add(firstVertex);
        
        while(queue.size() != 0 ) {
            firstVertex = queue.pollFirst();
            examinedNodeCounter++;

            if(vertex[firstVertex].getValue() == userSearch) {
                found = true;
                System.out.println(userSearch + " was found.");
                System.out.println("The amount of Nodes examined using BFS were " + examinedNodeCounter);
            }     

            for(int n: adjList[firstVertex])
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }           
        }
        if(!found) {
            System.out.println(userSearch + " was not found.");
        }
    }

    public static void main(String[] args) {   
        Graph newGraph = new Graph(1000);

        for(int i = 0; i < newGraph.getMax(); i++) { // filling the graph nodes with random values
            newGraph.insertVertex(i, new Listing(ThreadLocalRandom.current().nextInt(100000)));
        }

        for(int i = 0; i < newGraph.getMax(); i++) {
            for(int j = 0; j < ThreadLocalRandom.current().nextInt(1,6);j++) { // giving each node up to 5 edges
                newGraph.insertEdge(i,ThreadLocalRandom.current().nextInt(1000));
                j++;
            }
        }

        try(Scanner sc = new Scanner(System.in)) {              
            int userInput;

            System.out.println("Enter a number between 0 and 100000 you would like to search for");
            userInput = sc.nextInt();

            System.out.println("Depth First Search: ");
            newGraph.depthFirst(0, userInput);

            System.out.println("Breadth First Search: ");
            newGraph.breadthFirst(0, userInput);

        }
    }
}