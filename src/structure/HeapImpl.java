/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

class Node {

    private int iData; // data item (key)
// -------------------------------------------------------------

    public Node(int key) { // constructor
        iData = key;
    }

    public void setKey(int key) { // constructor
        iData = key;
    }
    public int getKey() {
        return iData;
    }
}

/**
 * A heap is a binary tree with these characteristics:
 *
 * • It’s complete. This means it’s completely filled in, reading from left to
 * right across each row, although the last row need not be full.
 *
 * • It’s (usually) implemented as an array.
 *
 * • Each node in a heap satisfies the heap condition, which states that every
 * node’s key is larger than (or equal to) the keys of its children.
 *
 * A heap is weakly ordered compared with a binary search tree, in which all a
 * node’s left descendants have keys less than all its right descendants. This
 * implies, as we saw, that in a binary search tree you can traverse the nodes
 * in order by following a simple algorithm.
 *
 * In a heap, traversing the nodes in order is difficult because the organizing
 * principle (the heap condition) is not as strong as the organizing principle
 * in a tree. All you can say about a heap is that, along every path from the
 * root to a leaf, the nodes are arranged in descending order.
 *
 * Because heaps are weakly ordered, some operations are difficult or
 * impossible. Besides its failure to support traversal, a heap also does not
 * allow convenient searching for a specified key.
 *
 * This is because there’s not enough information to decide which of a node’s
 * two children to pick in trying to descend to a lower level during the search.
 * It follows that a node with a specified key can’t be deleted, at least in
 * O(logN) time, because there’s no way to find it. (These operations can be
 * carried out, by looking at every cell of the array in sequence, but this is
 * only possible in slow O(N) time.)
 *
 * Thus, the organization of a heap may seem dangerously close to randomness.
 * Nevertheless, the ordering is just sufficient to allow fast removal of the
 * maximum node and fast insertion of new nodes. These operations are all that’s
 * needed to use a heap as a priority queue
 *
 * To Represent a Tree in a Array we follow this convention:
 *
 * Its parent is (x-1) / 2. • Its left child is 2*x + 1. • Its right child is
 * 2*x + 2.
 *
 * @author valgood
 */
public class HeapImpl {

    private final Node[] heapArray;
    private final int maxSize; // size of array
    private int currentSize; // number of nodes in array

    // -------------------------------------------------------------
    public HeapImpl(int mx) // constructor
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // create array
    }
// -------------------------------------------------------------

    public boolean isEmpty() {
        return currentSize == 0;
    }
// -------------------------------------------------------------
    public boolean insert(int key) {
        if (currentSize == maxSize) // if array is full,
        {
            return false; // failure
        }
        Node newNode = new Node(key); // make a new node
        heapArray[currentSize] = newNode; // put it at the end
        trickleUp(currentSize++); // trickle it up
        return true; // success
    } // end insert()

    /**
     * In trickleUp() (shown below) the argument is the index of the newly
     * inserted item.
     *
     * We find the parent of this position and then save the node in a variable
     * called bottom. Inside the while loop, the variable index will trickle up
     * the path toward the root, pointing to each node in turn. The while loop
     * runs as long as we haven’t reached the root (index>0), and the key
     * (iData) of index’s parent is less than the new node.
     *
     * The body of the while loop executes one step of the trickle-up process.
     * It first copies the parent node into index, moving the node down. (This
     * has the effect of moving the “hole” upward.) Then it moves index upward
     * by giving it its parent’s index, and giving its parent its parent’s
     * index.
     *
     * @param index
     */
    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0
                && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent]; // move node down
            index = parent; // move index up
            parent = (parent - 1) / 2; // parent <- its parent
        } // end while
        heapArray[index] = bottom;
    } // end trickleUp()

    public Node remove() // delete item with max key
    { // (assumes non-empty list)
        Node root = heapArray[0]; // save the root
        heapArray[0] = heapArray[--currentSize]; // root <- last
        trickleDown(0); // trickle down the root
        return root; // return removed node
    } // end remove()

    /**
     * The trickleDown() routine is more complicated than trickleUp() because 
     * we must determine which of the two children is larger. 
     * First, we save the node at index in a variable called top. 
     * If trickleDown() has been called from remove(), index is the root, 
     * but, as we’ll see, it can be called from other routines as well.
     * 
     * The while loop will run as long as index is not on the bottom row—
     * that is, as long as it has at least one child. Within the loop we check 
     * if there is a right child (there maybe only a left), and if so, compare 
     * the children’s keys, setting largerChild appropriately. 
     * 
     * Then we check if the key of the original node (now in top) is greater 
     * than that of largerChild; if so, the trickle-down process is complete 
     * and we exit the loop.
     * 
     * @param index 
     */
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index]; // save root
        while (index < currentSize / 2) // while node has at
        {   // least one child,
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            // find larger child
            if (rightChild < currentSize
                    && // (rightChild exists?)
                    heapArray[leftChild].getKey()
                    < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            // top >= largerChild?
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        } // end while
        heapArray[index] = top; // root to index
    }
    
    /**
     * After we’ve created the trickleDown() and trickleUp() methods, we can 
     * easily implement an algorithm to change the priority (the key) of a node 
     * and then trickle it up or down to its proper position. 
     * The change() method accomplishes this
     * 
     * @param index
     * @param newValue
     * @return 
     */
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey(); // remember old
        heapArray[index].setKey(newValue); // change to new
        if (oldValue < newValue) // if raised,
        {
            trickleUp(index); // trickle it up
        } else // if lowered,
        {
            trickleDown(index); // trickle it down
        }
        return true;
    } // end change()
    
    public void displayHeap() {
        System.out.print("heapArray: "); // array format
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            }else {
                System.out.print("-- ");
            }
        }
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // current item
        String dots = "...............................";
        System.out.println(dots + dots); // dotted top line
        while (currentSize > 0) // for each heap item
        {
            if (column == 0) // first item in row?
            {
                for (int k = 0; k < nBlanks; k++) // preceding blanks
                {
                    System.out.print(" ");
                }
            }            
            // display item
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) // done?
            {
                break;
            }
            if (++column == itemsPerRow) // end of row?
            {
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            } else // next item on row
            {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }             
        }
        System.out.println("\n" +dots + dots); // dotted bottom line
    } // end displayHeap()
}
