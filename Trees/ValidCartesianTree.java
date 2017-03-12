import java.util.Scanner;
import java.util.ArrayList;

class TreeNode{
	TreeNode left;
	TreeNode right;
	int data;
	public TreeNode(int data){this.data = data;}
}

public class ValidCartesianTree{

	// method to print the inorder traversal of the tree
	static void inorder(TreeNode root){
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// method to create the cartesian tree from inorder traversal
	static TreeNode cartesianTree(ArrayList<Integer> list){
		if(list.size() == 0)
			return null;
		int maxIndex = findMax(list);
		TreeNode root = new TreeNode(list.get(maxIndex));
		ArrayList<Integer> left = new ArrayList<Integer>();
		for(int i=0; i<maxIndex; i++)
			left.add(list.get(i));
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int j=maxIndex+1; j<list.size(); j++)
			right.add(list.get(j));
		root.left = cartesianTree(left);
		root.right = cartesianTree(right);
		return root;
	}

	// method to find the max element in list
	static int findMax(ArrayList<Integer> list){
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i=0; i<list.size(); i++)
			if (max < list.get(i)){
				max = list.get(i);
				index = i;
			}
		return index;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		/**TreeNode root1 = new TreeNode(62);
		TreeNode root2 = new TreeNode(45);
		TreeNode root3 = new TreeNode(19);
		root1.left = root2; root1.right = root3;
		TreeNode root4 = new TreeNode(34);
		TreeNode root5 = new TreeNode(18);
		root2.left = root4; root2.right = root5;
		inorder(root1);*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(34); list.add(45); list.add(18); list.add(62); list.add(19);
		TreeNode root = cartesianTree(list);
		inorder(root);
	}
}