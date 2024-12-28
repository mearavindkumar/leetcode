package lab.daily;

import java.util.ArrayList;
import java.util.List;

import lab.base.TreeNode;

public class Dec25 {

//	-- Write your PostgreSQL query statement below
//	select case when id % 2 = 0 then (id - 1) else (id + 1) end id, student from Seat order by 1

	TreeNode current;
	TreeNode result1;

	public int minDiffInBST(TreeNode root) {
		minDiffInBSTDFS(root);
		return ans;

	}

	private int ans = Integer.MAX_VALUE;
	private Integer pred = null;

	public void minDiffInBSTDFS(TreeNode root) {
		if (root == null) {
			return;
		}
		minDiffInBSTDFS(root.left);
		if (pred != null) {
			ans = Math.min(ans, root.val - pred);
		}

		pred = root.val;
		minDiffInBSTDFS(root.right);

	}

//	 private void inorder(TreeNode root) 
//	  {
//	    if (root == null)
//	      return;
//
//	    inorder(root.left);
//	    if (pred != null)
//	      ans = Math.min(ans, root.val - pred);
//	    pred = root.val;
//	    inorder(root.right);
//	  }

	public boolean isUnivalTree(TreeNode root) {


		return isUnivalTree(root, root.val);

	}

	public boolean isUnivalTree(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		return root.val == val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
	}


	public TreeNode increasingBST(TreeNode root) {
		increasingBSTDFS(root);
		return result1;
	}

	public void increasingBSTDFS(TreeNode root) {
		if (root == null) {
			return;
		}
		increasingBSTDFS(root.left);
		if (current == null) {
			current = result1 = new TreeNode(root.val);
		} else {
			current.right = new TreeNode(root.val);
			current = current.right;
		}


		increasingBSTDFS(root.right);

	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null) {
			return null;
		}
		if (original.val == target.val) {
			return cloned;
		}
		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		if (left != null) {
			return left;
		}
		return getTargetCopy(original.right, cloned.right, target);
	}

//	 if (original == null) return null;
//
//     if (original == target) return cloned;
//
//     TreeNode leftNode = dfs(original.left, cloned.left, target);
//     if (leftNode != null) return leftNode;
//
//     TreeNode rightNode = dfs(original.right, cloned.right, target);
//     return rightNode;

	public boolean evaluateTree(TreeNode root) {
		if (root.left == null) {
			return root.val == 1;
		}

		if (root.val == 2) {
			return evaluateTree(root.left) || evaluateTree(root.right);
		}
		return evaluateTree(root.left) && evaluateTree(root.right);
		
//		if (root == null) {
//			return false;
//		}
//
//		if (root.val == 1) {
//			return true;
//		}
//
//		if (root.val == 0) {
//			return false;
//		}
//
//		boolean left = evaluateTree(root.left);
//		if (root.val == 2 && left) {
//			return true;
//		}
//		if (root.val == 3 && !left) {
//			return false;
//		}
//		boolean right = evaluateTree(root.right);
//		return root.val == 2 ? left || right : left && right;


	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		int left = 0;
		int right = 0;
		if (root.val < low) {
			left = rangeSumBST(root.right, low, high);
		}

		if (root.val > high) {
			right = rangeSumBST(root.left, low, high);
		}

		return root.val + left + right;

	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		root1.val = root1.val + root2.val;
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);
		return root1;

	}

	public char kthCharacter(int k) {
		String s = kthCharacter(k, k, "a");
		System.out.println(s);
		int position = Integer.bitCount(k - 1);
		System.out.println(position);
		return s.charAt(k - 1);
	}

	public String kthCharacter(int k, int target, String result) {
		if (k == 0 || result.length() > target) {
			return result;
		}
		StringBuilder temp = new StringBuilder();
		for (char c : result.toCharArray()) {
			char next = (char) (c + 1);
			if (c == 'z') {
				next = 'a';
			}
			temp.append(next);
		}
		return kthCharacter(--k, target, result + temp);
	}


	public static void main(String[] args) {
		Dec25 instance = new Dec25();
//		1,0,1,0,1,0,1
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);
		instance.increasingBST(root1);

//		BSTIterator.inOrderTraversal(root);
//		System.out.println();
//		BSTIterator.inOrderTraversal(root1);
//
//		TreeNode root2 = instance.mergeTrees(root1, root);
//		System.out.println();
//
//		BSTIterator.inOrderTraversal(root2);

//		System.out.println(instance.kthCharacter(10));
	}

	static List<List<Integer>> result = new ArrayList<>();


	public int kthSmallest(TreeNode root, int k) {
		int[] result = new int[1]; // To store the k-th smallest element
		int[] count = new int[1]; // To keep track of the count of visited nodes
		kthSmallest(root, k, count, result);
		return result[0];
	}

	public void kthSmallest(TreeNode root, int k, int[] count, int[] result) {

		if (root == null) {
			return;
		}
		kthSmallest(root.left, k, count, result);
		count[0]++;
		if (count[0] == k) {
			result[0] = root.val;
			return;
		}
		kthSmallest(root.right, k, count, result);

	}

	public void dfsSum(TreeNode root, int targetSum, List<Integer> currentList) {
		if(root == null) {
			return;
		}
		targetSum = targetSum - root.val;
		currentList.add(root.val);
		if (root.left == null && root.right == null && targetSum == 0) {
			result.add(new ArrayList<>(currentList));
			return;
		}


		dfsSum(root.left, targetSum, new ArrayList(currentList));
		dfsSum(root.right, targetSum, new ArrayList(currentList));

//		dfsSum(root.left, targetSum, currentList);
//		currentList.remove(currentList.size() - 1);
//		dfsSum(root.right, targetSum, currentList);
//		currentList.remove(currentList.size() - 1);

//		currentList.remove(currentList.size() - 1);

	}

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}
		if (root.val > high) {
			return trimBST(root.left, low, high);
		}

		if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}


	private TreeNode prev;
	private TreeNode first;
	private TreeNode second;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = diameterOfBinaryTree(root.left);
		int rightHeight = diameterOfBinaryTree(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public void recoverTreeDFS(TreeNode root) {
		if (root == null) {
			return;
		}

		recoverTreeDFS(root.left);

		if (prev != null && prev.val > root.val) {
			if (first == null) {
				first = root;
			} else {
				second = prev;
			}
		}
		prev = root;
		recoverTreeDFS(root.right);

	}

//	 private void dfs(TreeNode root) {
//	        if (root == null) {
//	            return;
//	        }
//	        dfs(root.left);
//	        if (prev != null && prev.val > root.val) {
//	            if (first == null) {
//	                first = prev;
//	            }
//	            second = root;
//	        }
//	        prev = root;
//	        dfs(root.right);
//	    }

	public int sumRootToLeaf(TreeNode root) {
		return 1;
	}

	public int dfs(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		val = val * 2 + root.val;
		if (root.left == null && root.right == null) {
			return val;
		}
		return dfs(root.left, val) + dfs(root.right, val);
	}

	public static int inOrderTraversal(TreeNode root, String no) {
		if (root == null) {
			return Integer.parseInt(no, 2);
		}
		no = no + "" + root.val;
		return inOrderTraversal(root.left, no)  +
		inOrderTraversal(root.right, no);

	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null);
	}

	TreeNode prevNode;

	public boolean isValidBST(TreeNode root, TreeNode prevNode1) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left, prevNode)) {
			return false;
		}
		if (prevNode != null && prevNode.val >= root.val) {
			return false;
		}
		prevNode = root;
		return isValidBST(root.right, prevNode);

	}

//	
//	if (root == null) {
//        return true;
//    }
//    if (!dfs(root.left)) {
//        return false;
//    }
//    if (prev != null && prev.val >= root.val) {
//        return false;
//    }
//    prev = root;
//    return dfs(root.right);
}
