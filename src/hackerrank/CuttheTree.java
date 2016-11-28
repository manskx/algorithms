/**
 * 
 */
package hackerrank;

import java.util.*;
import java.io.*;

/**
 * @author Ahmed
 *
 */
public class CuttheTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int count = 0;
		String S = in.nextLine();

		int Number = Integer.parseInt(S);

		Map<Integer, Node> treeMap = new HashMap<Integer, Node>();

		int sum = 0;
		while (count < Number) {
			int treeData = in.nextInt();
			sum += treeData;
			Node TreeNode = new Node();
			TreeNode.data = treeData;
			TreeNode.childs = new ArrayList<Integer>();
			treeMap.put(count + 1, TreeNode);
			count++;
		}
		int minSum = sum;
		String Line	;
		while (in.hasNext()) {

			int first = in.nextInt();
			int second = in.nextInt();
			Node TreeNode = treeMap.get(first);
			TreeNode.childs.add(second);
			treeMap.put(first, TreeNode);

		}
		
		System.out.println("finish");
		
		in.close();
	}

}
