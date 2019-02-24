import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<? super E>> {
	private Node root;

	public BinarySearchTree()
	{
		root = null;
	}
	
	public boolean visuallyIdentical(BinarySearchTree rhs){
		
		String thisTreeString = captureOutput(this),
				rhsTreeString = captureOutput(rhs);
		System.out.println("This tree: " + thisTreeString + "\nOther tree: " + rhsTreeString);
		if (thisTreeString.equals(rhsTreeString)){
			return true;
		}
		return false;
	}
	
	// Reuse printInLevelOrder instead of making another method to return the level-ordered string of the tree
	// Captures output stream and returns it.
	private String captureOutput(BinarySearchTree tree){
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// Backup old out stream
		PrintStream old = System.out;
		// Set out to special stream
		System.setOut(ps);
		// Print output to special stream
		tree.printInLevelOrder();
		// Put old stream back
		System.out.flush();
		System.setOut(old);
		// Return stream
		return baos.toString();
	}
	
    void printInLevelOrder() // 2N: Big-O() = N
    {
        int h = height(root); // Runs N
        for (int i = 1; i <= h; i++) // For loop runs for N, which is the height of the tree (h)
            printLevel(root, i);
    }
  
    // Recursively calls itself N times until we reach the base case of level 1 or special case root is null.
    void printLevel (Node n, int l)
    {
        if (n == null)
            return;
        if (l == 1)
            System.out.print(n.data + " ");
        else if (l > 1) // Recursive call
        {
            printLevel(n.left, l - 1);
            printLevel(n.right, l - 1);
        }
    }
    
    // Runs O(N) to find height of tree
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

	public void printTree()
	{
		printTree(root);
	}
	private void printTree(Node current)
	{
		if(current != null)
		{
			String content = "Current:"+current.data.toString();
			if(current.left != null)
			{
				content += "; Left side:"+current.left.data.toString();
			}
			if(current.right != null)
			{
				content += "; Right side:"+current.right.data.toString();
			}
			System.out.println(content);
			printTree(current.left);
			printTree(current.right);

		}
	}
	public void printInOrder()
	{
		System.out.print("In order:");
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(Node current)
	{
		if(current != null)
		{
			printInOrder(current.left);
			System.out.print(current.data.toString()+",");
			printInOrder(current.right);
		}
	}
	public boolean contains(E val)
	{
		Node result = findNode(val, root);

		if(result != null)
			return true;
		else
			return false;
	}
	private Node findNode(E val, Node current)
	{
		//base cases
		if(current == null)
			return null;
		if(current.data.equals(val))
			return current;

		//recursive cases
		int result = current.data.compareTo(val);
		if(result < 0)
			return findNode(val, current.right);
		else
			return findNode(val, current.left);
	}
	public E findMin()
	{
		Node result = findMin(root);
		if(result == null)
			return null;
		else
			return result.data;
	}
	private Node findMin(Node current)
	{
		while(current.left != null)
		{
			current = current.left;
		}
		return current;
	}
	public E findMax()
	{
		Node current = root;
		while(current.right != null)
		{
			current = current.right;
		}
		return current.data;
	}
	public void insert(E val)
	{
		root = insertHelper(val, root);
	}
	public Node insertHelper(E val, Node current)
	{
		/* for showing steps to insert a given value
		if(val.equals(9) && current != null)
		{
			System.out.println(current.data);
		}
		*/

		if(current == null)
		{
			return new Node(val);
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = insertHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = insertHelper(val, current.left);
		}
		else//update
		{
			current.data = val;
		}
		return current;
	}
	public void remove(E val)
	{
		root = removeHelper(val, root);
	}
	private Node removeHelper(E val, Node current)
	{
		if(current.data.equals(val))
		{
			if(current.left == null && current.right == null)//no children
			{
				return null;
			}
			else if(current.left != null && current.right != null)//two children
			{
				Node result = findMin(current.right);
				result.right = removeHelper(result.data, current.right);
				result.left = current.left;
				return result;
			}
			else//one child
			{
				return (current.left != null)? current.left : current.right;
			}
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = removeHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = removeHelper(val, current.left);
		}
		return current;
	}


	private class Node
	{
		E data;
		Node left, right;
		public Node(E d)
		{
			data = d;
			left = null;
			right = null;
		}
	}

}
