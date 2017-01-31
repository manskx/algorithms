package trees;

import trees.*;
import java.util.*;

public class BST {

	public static void main(String[] args) {
		ConstructTreeFromInOrderPreOrder();
	}
	
	/**
	 * Minimum depth of a binary search tree
	 */
	public static void minDepthBinarySearchTree(){
		BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        root.right.left = new BSTNode(4);
        root.right.right = new BSTNode(5);
        root.left.left = new BSTNode(4);
 
        System.out.println("The minimum depth of "+
          "binary tree is : " + minDepth(root, 0));
	}	
	public static int minDepth(BSTNode root, int depth){
		if(root == null)
			return depth;
		int leftDepth	=	minDepth(root.left, depth+1);
		int rightDepth	=	minDepth(root.right, depth+1);
		return Math.min(rightDepth, leftDepth);
	}
	/**
	 * InOrder traversal for binary search tree
	 * @param root
	 */
	public static void inOrder(BSTNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
	
	/**
	 * PreOrder traversal for binary search tree
	 * @param root
	 */
	public static void preorder(BSTNode root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
	/**
	 * postOrder traversal for binary search tree
	 * @param root
	 */
	public static void postOrder(BSTNode root)
    {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
	/**
	 * Construct tree from its inorder and preorder traversal
	 */
	public static void ConstructTreeFromInOrderPreOrder(){
		ArrayList<Integer> inOrder	=	new ArrayList<Integer>(); //4 2 5 1 3
		ArrayList<Integer> preOrder	=	new ArrayList<Integer>(); //1 2 4 5 3
		
		inOrder.add(4);
		inOrder.add(2);
		inOrder.add(5);
		inOrder.add(1);
		inOrder.add(3);
		
		preOrder.add(1);
		preOrder.add(2);
		preOrder.add(4);
		preOrder.add(5);
		preOrder.add(3);
		
		
		Map<Integer, Integer> inOrderMap	=	new HashMap<Integer, Integer>();

		for(int i=0; i<inOrder.size(); i++){
			inOrderMap.put(inOrder.get(i), i);
		}
		
		BSTNode root	=	ConstructTree( 0, inOrder.size()-1, preOrder, inOrderMap);
		PrintTree(root);
	}
	public static int preIndex 	=	0;
	public static BSTNode ConstructTree( Integer i, Integer j, ArrayList<Integer> preOrder, Map<Integer, Integer> inOrderMap){
		if(j<i)
			return null;

		int data		=	preOrder.get(preIndex);
		preIndex++;
		BSTNode	root	=	new BSTNode(data);

		if(j.equals(i))
			return root;
		int inIndex	=	inOrderMap.get(data);
		root.left	=	ConstructTree( i, inIndex-1, preOrder, inOrderMap);
		root.right	= 	ConstructTree( inIndex+1, j, preOrder, inOrderMap);
		return root;

	}
	
	/**
	 * Print Tree inOrder and preOrder traversals
	 * @param root
	 */
	public static void PrintTree(BSTNode root){
		System.out.println("InOrder: ");
		inOrder(root);
		System.out.println(" ");

		System.out.println("PreOrder: ");
		preorder(root);
		
	}
	
}

