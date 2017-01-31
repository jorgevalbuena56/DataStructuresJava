/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.node;

/**
 *  Graph Implementation
 * 
 *  Two methods are commonly used for graphs: the adjacency matrix and the adjacency list
 *
 *  An adjacency matrix is a two-dimensional array in which the elements indicate
 *  whether an edge is present between two vertices. If a graph has N vertices, the adjacency
 *  matrix is an NxN array
 *  
 *  The list in adjacency list refers to a linked list. Actually,
 *  an adjacency list is an array of lists (or sometimes a list of lists). 
 *  Each individual list shows what vertices a given vertex is adjacent to. 
 *
 * @author George
 */
public class Graph {
    private final int MAX_VERTS = 20;      
    private Vertex vertexList[]; //list of vertices
    private int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices
    private StackImpl stack;

    public Graph() //constructor
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
        stack = new StackX();
    } // end constructor
    
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
}
