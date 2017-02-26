package interviewbit.heapsandmaps;

import java.math.BigInteger;
import java.util.*;

public class MagicianChocolates {

	public static void main(String[] args) {
		int A = 10;

		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(2147483647);
		B.add(2000000014);
		B.add(2147483647);

		System.out.println(nchoc(A, B));
	}

	public static int nchoc(int A, ArrayList<Integer> B) {
		BigInteger max = BigInteger.ZERO;

		TreeMap<Integer, Integer> bags = new TreeMap<Integer, Integer>();

		for (int i = 0; i < B.size(); i++) {
			int num 	=	0;
			if(bags.containsKey(B.get(i)))
				num	=	bags.get(B.get(i));
			bags.put(B.get(i), ++num);

		}

		for (int i = 0; i < A; i++) {
			int nchoc = bags.lastKey();

			max = max.add(BigInteger.valueOf(nchoc)) ;
			
			int num 	=	bags.get(nchoc);
			if(num ==1)
				bags.remove(nchoc);
			else{
				bags.put(nchoc, --num);

			}
			nchoc 	=	nchoc /2;
			num 	= 0;
			if(bags.containsKey(nchoc))
				num 	=	bags.get(nchoc);
			bags.put(nchoc , ++num);
		}
		BigInteger result 	=	max.mod(BigInteger.valueOf(1000000007));
		
		return result.intValue();

	}

}
