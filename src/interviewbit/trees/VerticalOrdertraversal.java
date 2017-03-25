package interviewbit.trees;

import java.util.*;

import common.IO;


public class VerticalOrdertraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		// root.right.left = new BSTNode(3);
		IO.PrintTwoDimensionalArray(verticalOrderTraversal(root));
	}

	static Map<Integer, TreeMap<Integer, ArrayList<Integer>>> nodesMap;

	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		nodesMap = new TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>>();

		putVerticalOrder(A, 0, 0);

		ArrayList<ArrayList<Integer>> nodesVerticleOrderList = new ArrayList<ArrayList<Integer>>();

		for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : nodesMap.entrySet()) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			for (Map.Entry<Integer, ArrayList<Integer>> subTreeEntry : entry.getValue().entrySet()) {
				subList.addAll(subTreeEntry.getValue());
			}
			nodesVerticleOrderList.add(subList);
		}

		return nodesVerticleOrderList;
	}

	public static void putVerticalOrder(TreeNode A, int k, int l) {
		if (A == null)
			return;
		TreeMap<Integer, ArrayList<Integer>> nodesListMap;
		if (nodesMap.containsKey(k)) {
			nodesListMap = nodesMap.get(k);
		} else {
			nodesListMap = new TreeMap<Integer, ArrayList<Integer>>();
		}
		ArrayList<Integer> nodesList;
		if (nodesListMap.containsKey(l)) {
			nodesList = nodesListMap.get(l);
		} else {
			nodesList = new ArrayList<Integer>();
		}
		nodesList.add(A.val);

		nodesListMap.put(l, nodesList);
		nodesMap.put(k, nodesListMap);
		putVerticalOrder(A.left, k - 1, l + 1);
		putVerticalOrder(A.right, k + 1, l + 1);

	}
}
