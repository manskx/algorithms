package codility.arrays;

import java.util.*;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0,0 };
		//System.out.println(countPairs2(-2147483648, A));
		System.out.println(pawnLocation(A));
	}

	public static int pawnLocation(int[] A) {

		if (A.length == 0)
			return -1;
		if (A.length == 1)
			return 0;

		Map<Integer, Integer> pawnMap = new HashMap<Integer, Integer>();
		int i = 0;
		pawnMap.put(i, 1);
		while (true) {
			int pawn = A[i] + i;
			if (pawnMap.containsKey(pawn)) {
				return -1;
			}
			if (pawn < 0 || pawn >= A.length) {
				return i;
			}
			pawnMap.put(pawn, 1);
			i = pawn;
		}
	}

	// count pairs givin sum

	public static int countPairs(int k, int[] arr) {
		int count = 0;
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {

			int comp = k - arr[i];
			if (numMap.containsKey(comp)) {
				int compCount = numMap.get(comp);
				count += compCount;

			}
			int iCount = 0;
			if (numMap.containsKey(arr[i])) {
				iCount = numMap.get(iCount);
			}
			numMap.put(arr[i], ++iCount);
		}
		return count;
	}

	public static int countPairs2(int k, int[] arr) {

		// write your code in Java SE 8
		int min;
		int max;
		if (k < 0) {
			min = Integer.MIN_VALUE;
			max = Integer.MAX_VALUE;
		} else if (k > 0) {
			min = k - Integer.MAX_VALUE;
			max = Integer.MAX_VALUE;
		} else {
			max = Integer.MAX_VALUE;
			min = Integer.MIN_VALUE + 1;
		}

		int count = 0;
		Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max || arr[i] < min) {
				continue;
			}
			int num = 0;

			if (pairMap.containsKey(arr[i])) {
				num = pairMap.get(arr[i]);
			}
			pairMap.put(arr[i], ++num);
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max || arr[i] < min) {
				continue;
			}
			int comp = k - arr[i];
			if (pairMap.containsKey(comp)) {
				int countN = pairMap.get(comp);
				count += countN;
			}

		}
		return count;
	}

	static int fib(int n) {
		int mod = 1000000;
		int first = 0;
		int second = 1;
		int next;
		if (n == 0)
			return first;
		for (int i = 2; i <= n; i++) {
			next = (first + second) % mod;
			first = second % mod;
			second = next % mod;
		}
		return second;
	}

}
