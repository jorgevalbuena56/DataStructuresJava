package structure.graph;

import structure.QueueImpl;
import structure.StackImpl;

/**
 *  Graph Implementation
 * 
 *  Two methods are commonly used for graphs: the adjacency matrix and the 
 *  adjacency list
 *
 *  An adjacency matrix is a two-dimensional array in which the elements indicate
 *  whether an edge is present between two vertices. If a graph has N vertices, 
 *  the adjacency matrix is an NxN array
 *  
 *  The list in adjacency list refers to a linked list. Actually,
 *  an adjacency list is an array of lists (or sometimes a list of lists). 
 *  Each individual list shows what vertices a given vertex is adjacent to. 
 *
 * @author George
 */
public class GraphImpl {
    private final int MAX_VERTS = 20;      
    private final Vertex vertexList[]; //list of vertices
    private final int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices
    private final StackImpl stack;

    public GraphImpl() //constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) { // set adjacency matrix to 0
            for(int k=0; k<MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new StackImpl(MAX_VERTS);
    }
    
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // -----------------------------------------------------------
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    // ------------------------------------------------------------
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    
   /**
     * The depth-first search uses a stack to remember where it should go when 
     * it reaches a dead end.
     * 
     * RULE 1
     * If possible, visit an adjacent unvisited vertex, mark it, and push it on 
     * the stack.
     * 
     * RULE 2
     * If you can’t follow Rule 1, then, if possible, pop a vertex off the stack.
     * 
     * RULE 3
     * If you can’t follow Rule 1 or Rule 2, you’re done.
     * 
     * You might say that the depth-first search algorithm likes to get as far 
     * away from the starting point as quickly as possible and returns only when
     * it reaches a dead end. If you use the term depth to mean the distance 
     * from the starting point, you can see where the name depth-first search
     * comes from. 
     * 
     * ANALOGY = MAZE
     * 
     * @author valgood
     */
    public void dfs() // depth-first search
    { // begin at vertex 0
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        stack.push(0); // push it
        while (!stack.isEmpty()) // until stack empty,
        {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex((int)stack.peek());
            if (v == -1) // if no such vertex,
            {
                stack.pop();
            } else // if it exists,
            {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                stack.push(v); // push it
            }
        } // end while
        // stack is empty, so we’re done
        for (int j = 0; j < nVerts; j++) // reset flags
        {
            vertexList[j].wasVisited = false;
        }
    } // end dfs

    /**
     * In the breadth-first search, the algorithm likes to stay as close as 
     * possible to the starting point. It visits all the vertices adjacent to 
     * the starting vertex, and only then goes further afield. 
     * 
     * This kind of search is implemented using a queue instead of a stack.
     * 
     * RULE 1
     * Visit the next unvisited vertex (if there is one) that’s adjacent to 
     * the current vertex, mark it, and insert it into the queue.
     * 
     * RULE 2
     * If you can’t carry out Rule 1 because there are no more unvisited 
     * vertices, remove a vertex from the queue (if possible) and make it 
     * the current vertex.
     * 
     * RULE 3
     * If you can’t carry out Rule 2 because the queue is empty, you’re done.
     * 
     * You can think of the breadth-first search as proceeding like ripples 
     * widening when you drop a stone in water—or, for those of you who enjoy 
     * epidemiology, as the influenza virus carried by air travelers from city 
     * to city. First, all the vertices one edge (plane flight) away from 
     * the starting point are visited, then all the vertices two edges away 
     * are visited, and so on.
     * 
     * The bfs() method of the Graph class is similar to the dfs() method, 
     * except that it uses a queue instead of a stack and features nested loops 
     * instead of a single loop. The outer loop waits for the queue to be empty,
     * whereas the inner one looks in turn at each unvisited neighbor 
     * of the current vertex
     * 
     * The breadth-first search has an interesting property: It first finds all 
     * the vertices that are one edge away from the starting point, 
     * then all the vertices that are two edges away, and so on. This is useful 
     * if you’re trying to find the shortest path from the starting vertex 
     * to a given vertex. You start a BFS, and when you find the specified 
     * vertex, you know the path you’ve traced so far is the shortest path 
     * to the node. If there were a shorter path, the BFS would have 
     * found it already.
     * 
     */
    public void bfs() {
        QueueImpl queue = new QueueImpl(MAX_VERTS);
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        queue.insert(0); // insert at tail
        int v2;
        while (!queue.isEmpty()) // until queue empty,
        {
            int v1 = queue.remove(); // remove vertex at head
            // until it has no unvisited neighbors
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
                vertexList[v2].wasVisited = true; // mark it
                displayVertex(v2); // display it
                queue.insert(v2); // insert it
            } // end while(unvisited neighbors)
        } // end while(queue not empty)
        // queue is empty, so we’re done
        for (int j = 0; j < nVerts; j++) // reset flags
        {
            vertexList[j].wasVisited = false;
        }
    }
    /**
     * MINIMUM SPANNING TREE
     * 
     * Computes a graph with the minimum number of edges necessary to connect 
     * the vertices.
     * 
     * The algorithm for creating the minimum spanning tree is almost identical 
     * to that used for searching. It can be based on either the depth-first 
     * search or the breadthfirst search. 
     * 
     * Here we’ll use the depth-first search.
     * 
     * Perhaps surprisingly, by executing the depth-first search and recording 
     * the edges you’ve traveled to make the search, you automatically create 
     * a minimum spanning tree. 
     * The only difference between the minimum spanning tree method mst()and 
     * the depth-first search method dfs() is that mst() must somehow record 
     * the edges traveled.
     * 
     */
    public void mst(){       
        vertexList[0].wasVisited = true; // start at 0 and mark it
        stack.push(0); // push it
        while( !stack.isEmpty() ) // until stack empty
        {   // get stack top
            int currentVertex = (int)stack.peek();
            // get next unvisited neighbor
            int v = getAdjUnvisitedVertex(currentVertex);
            if(v == -1) { // if no more neighbors
               stack.pop(); // pop it away
            } else // got a neighbor
            {
              vertexList[v].wasVisited = true; // mark it
              stack.push(v); // push it
              // display edge
              displayVertex(currentVertex); // from currentV
              displayVertex(v); // to v
              System.out.print(" ");
            }
        }
        // stack is empty, so we’re done
        for(int j=0; j<nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }
    /**
     * Returns an unvisited vertex adj to v
     * 
     * @param v
     * @return 
     */
    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    } // end getAdjUnvisitedVertex()
}
