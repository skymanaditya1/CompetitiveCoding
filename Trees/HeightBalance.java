// Checks whether a given Binary Tree is a Binary Search Tree
import java.util.Scanner;

class TreeNode{
	int data;
	TreeNode left; 
	TreeNode right;
	public TreeNode(int x){data = x;}
}

class Tree{
	public TreeNode insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode(data);
			return root;
		}
		if(data <= root.data){
			root.left = insert(root.left, data);
		}
		else if (data > root.data){
			root.right = insert(root.right, data);
		}
		return root;
	}

	// method to find the depth of a tree
	public int height(TreeNode root){
		if(root == null)
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// method to check if the binary tree is height balanced
	public boolean checkHeightBalance(TreeNode root){
		if (root == null)
			return true;
		if (Math.abs(height(root.left)-height(root.right))<=1 &&
			checkHeightBalance(root.left) && checkHeightBalance(root.right))
			return true;
		return false;
	}
}

public class HeightBalance{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Tree tree = new Tree();
		TreeNode root = null;
		root = tree.insert(root, 8);
		root = tree.insert(root, 10);
		root = tree.insert(root, 5);
		root = tree.insert(root, 1);
		root = tree.insert(root, 7);
		
		if(tree.checkHeightBalance(root))
			System.out.println("The tree is height balanced");
		else
			System.out.println("The tree is not height balanced");
	}
}