import java.util.Scanner;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){data = x;}
}

// Tree class for the tree related operations
class Tree{
	public TreeNode insert(TreeNode root, int data){
		if (root == null){
			root = new TreeNode(data);
			return root;
		}
		else if (data <= root.data){
			root.left = insert(root.left, data);
		}
		else{
			root.right = insert(root.right, data);
		}
		return root;
	}

	// method to check if the given BST is valid
	public boolean isValidBST(TreeNode root, int minValue, int maxValue){
		if(root == null)
			return true;
		if(root.data > minValue && root.data < maxValue 
		&& isValidBST(root.left, minValue, root.data)
		&& isValidBST(root.right, root.data, maxValue))
			return true;
		return false;
	}

	// method to check if all the elements in the binary tree are less than val
	public boolean isSubtreeLesser(TreeNode root, int data){
		if(root == null)
			return true;
		// for a binary tree to be lesser than a given value,
		// the following conditions must be satisfied
		// 1. The value of the root must be lesser than data
		// 2. The value of all elements in the left Binary tree must be lesser than data
		// 3. The value of all elements in the right Binary tree must be greater
		if(root.data <= data && isSubtreeLesser(root.left, data) &&
			isSubtreeLesser(root.right, data))
			return true;
		return false;
	}

	// method to check if all the elements in the right tree are greater than val
	public boolean isSubtreeGreater(TreeNode root, int data){
		if(root == null)
			return true;
		// three conditions must be satisfied
		// 1. The value in the root must be greater
		// 2. The value of the left subtree must be greater
		// 3. The value of the right subtree must be greater
		if(root.data > data && isSubtreeGreater(root.left, data) &&
			isSubtreeGreater(root.right, data))
			return true;
		return false;
	}

	// method to check whether a given Binary tree is bst or not
	public boolean checkBST(TreeNode root){
		// a binary tree is BST if it satisfies the following properties:
		// 1. All the elements in the left subtree are lesser than the root
		// 2. All the elements in the right subtree are greater than the root
		// 3. Left binary tree is also a BST
		// 4. Right binary tree is also a BST
		if(root == null)
			return true;
		if(isSubtreeLesser(root.left, root.data) &&
			isSubtreeGreater(root.right, root.data) &&
			checkBST(root.left) &&
			checkBST(root.right))
			return true;
		return false;
	}
}
public class ValidateBST{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TreeNode root = null;
		Tree tree = new Tree();
		root = tree.insert(root, 12);
		root = tree.insert(root, 10);
		root = tree.insert(root, 15);
		// check if the given binary tree is bst
		if(tree.isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("The given binary tree is BST");
		else 
			System.out.println("The given binary tree is not BST");
	}
}