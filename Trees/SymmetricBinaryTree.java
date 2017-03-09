import java.util.Scanner;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){data = x;}
}

class Tree{
	public TreeNode insert(TreeNode root, int data){
		if (root == null){
			root = new TreeNode(data);
			return root;
		}
		if (data <= root.data) {
			root.left = insert(root.left, data);
		}
		else if (data > root.data){
			root.right = insert(root.right, data);
		}
		return root;
	}

	// method to check whether the tree is symmetric,
	// the tree should be centered about itself
	public boolean isSymmetric(TreeNode root1, TreeNode root2){
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null) || 
			(root1 != null && root2 == null))
			return false;
		if (root1.data == root2.data && isSymmetric(root1.left, root2.right)
			&& isSymmetric(root1.right, root2.left))
			return true;
		return false;
	}
}

public class SymmetricBinaryTree{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Tree tree = new Tree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		// root.right.right = new TreeNode(3);
		if(tree.isSymmetric(root.left, root.right))
			System.out.println("The binary tree is symmetric");
		else
			System.out.println("The binary tree is not symmetric");
	}
}