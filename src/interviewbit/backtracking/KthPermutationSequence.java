package interviewbit.backtracking;

import java.util.*;



//Kth Permutation Sequence
//
//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3 ) :
//
//1. "123"
//2. "132"
//3. "213"
//4. "231"
//5. "312"
//6. "321"
//
//Given n and k, return the kth permutation sequence.
//
//For example, given n = 3, k = 4, ans = "231"
//
//Good questions to ask the interviewer :
//
//   What if n is greater than 10. How should multiple digit numbers be represented in string?
//   > In this case, just concatenate the number to the answer.
//   > so if n = 11, k = 1, ans = "1234567891011"
//
//   Whats the maximum value of n and k?
//   > In this case, k will be a positive integer thats less than INT_MAX.
//   > n is reasonable enough to make sure the answer does not bloat up a lot.
//


public class KthPermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 7));
	}

	public static String getPermutation(int n, int k) {
		List<Integer> NumList = new ArrayList<Integer>();

		int firstChangingDigit = n;
		int tempFact = 1;
		for (int i = 1; i <= n; i++) {
			tempFact *= i;

			if (tempFact >= k) {
				firstChangingDigit = i;
				break;
			}
		}
		String Num = "";

		for (int i = 1; i <= n; i++) {
			if ((n - i + 1) > firstChangingDigit)
				Num += i;
			else
				NumList.add(i);
		}

		int fact = tempFact;
		if (NumList.size() < 1)
			return Num;
		int n2 = NumList.size();

		for (int i = 0; i < n2 - 1; i++) {
			fact = fact / (n2 - i);
			int Pos = (k - 1) / fact;
			Num = Num + NumList.get(Pos);
			NumList.remove(Pos);
			k -= Pos * fact;
		}
		if (NumList.size() > 0)
			Num += NumList.get(0);

		return Num;
	}

}
