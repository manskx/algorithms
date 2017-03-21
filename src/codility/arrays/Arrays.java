package codility.arrays;

import java.math.BigInteger;
import java.util.*;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2147483647, -2147483648 };
		System.out.println(countPairs3(0, A));
		// System.out.println(pawnLocation2(A));
		// System.out.println(equilibriumIndex(A));
		// System.out.println(fib(36));

	}

	public static int equilibriumIndex(int[] A) {

		BigInteger sum = BigInteger.ZERO;

		for (int i = 1; i < A.length; i++) {
			sum = sum.add(BigInteger.valueOf(A[i]));
		}

		BigInteger firstSum = BigInteger.ZERO;
		if (sum.equals(firstSum))
			return 0;

		for (int i = 1; i < A.length; i++) {
			firstSum = firstSum.add(BigInteger.valueOf(A[i - 1]));
			sum = sum.subtract(BigInteger.valueOf(A[i]));
			if (sum.equals(firstSum))
				return i;
		}
		return -1;
	}

	public static int pawnLocation2(int[] A) {

		if (A.length == 0)
			return -1;
		int i = 0;
		Map<Integer, Integer> locationMap = new HashMap<Integer, Integer>();

		int number = 0;
		while (true) {
			int location = A[i] + i;
			if (locationMap.containsKey(location)) { // looop
				return -1;
			}
			if (location < 0 || location >= A.length) { // number out of array
				return number + 1;
			}
			locationMap.put(location, 1);
			i = location;
			number++;
		}
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

	public static int countPairs3(int K, int[] A) {
		
		//int[] A = { 2147483647, -2147483648 };
		
		int minRange = 0;
		int maxRange = 0;
		int count = 0;

		if (K > 0) { // positive sum
			minRange = K - Integer.MAX_VALUE;
			maxRange = Integer.MAX_VALUE;
		} else if (K < 0) { // negative sum
			minRange = Integer.MIN_VALUE;
			maxRange = Integer.MAX_VALUE;

		} else { // zero sum
			maxRange = Integer.MAX_VALUE;
			minRange = Integer.MIN_VALUE + 1;
		}

		Map<Integer, Integer> compMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > maxRange || A[i] < minRange) {
				continue;
			}
			int compNum = 0;

			if (compMap.containsKey(A[i])) {
				compNum = compMap.get(A[i]);
			}
			compNum++;
			compMap.put(A[i], compNum);
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > maxRange || A[i] < minRange) {
				continue;
			}
			int comp = K - A[i];
			if (compMap.containsKey(comp)) {
				int countComp = compMap.get(comp);
				count += countComp;
			}

		}
		return count;

	}

	public static int countPairs2(int k, int[] arr) {

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
		int sixDigit = 1000000;
		int prevSum = 0;
		int sum = 1;
		int next;
		if (n == 0)
			return prevSum;
		if (n == 1)
			return prevSum + sum;
		for (int i = 2; i <= n; i++) {
			next = (prevSum + sum) % sixDigit;
			prevSum = sum % sixDigit;
			sum = next % sixDigit;
		}
		return sum;
	}

}
