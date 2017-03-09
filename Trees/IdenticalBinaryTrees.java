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

	public boolean checkIdentical(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		if (root1.data == root2.data && checkIdentical(root1.left, root2.left)
			&& checkIdentical(root1.right, root2.right))
			return true;
		return false;
	}
}

public class IdenticalBinaryTrees{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Tree tree = new Tree();
		TreeNode root1 = null;
		root1 = tree.insert(root1, 2);
		root1 = tree.insert(root1, 1);
		root1 = tree.insert(root1, 3);
		TreeNode root2 = null;
		root2 = tree.insert(root2, 2);
		root2 = tree.insert(root2, 1);
		root2 = tree.insert(root2, 3);
		root2 = tree.insert(root2, 5);
		if(tree.checkIdentical(root1, root2))
			System.out.println("The two trees are identical");
		else
			System.out.println("The two trees are not identical");
	}
}