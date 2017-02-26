package interviewbit.hashing;

import java.util.*;

public class Fraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(2347, 5434234 ));
	}

	public static String fractionToDecimal(int numerator, int denominator) {

		String resultString = "";
		if (((numerator < 0) && (denominator > 0)) || ((numerator > 0) && (denominator < 0)))
			resultString = "-";
		long n = Math.abs((long) numerator);
		long d = Math.abs((long) denominator);
		long s = n / d;
		long r = n % d;

		long integerResult = 0;

		if (s >= 1) {
			integerResult = s;
			n = r;
		}

		if (r == 0)
			return resultString + s;

		ArrayList<Long> resultList = new ArrayList<Long>();
		Map<Long, Integer> remainderMap = new HashMap<Long, Integer>();

		int i = -1;
		boolean repeat = false;
		int repeatIndex = 0;

		while (r != 0) {
			n *= 10;
			s = n / d;
			r = n % d;

			if (r == 0) {
				resultList.add(s);
				break;
			}

			if (remainderMap.containsKey(r)) {
				repeat = true;
				repeatIndex = remainderMap.get(r);
				if(s!=resultList.get(repeatIndex+1))
					resultList.add(s);

				break;
			}

			remainderMap.put(n/10, i);
			resultList.add(s);
			i++;
			n = r;

		}

		resultString += integerResult + ".";
		StringBuilder repeatedPart = new StringBuilder();
		StringBuilder nonRepatedPart = new StringBuilder();
		for (int k = 0; k < resultList.size(); k++) {

			if (repeat && repeatIndex+1  <= k)
				repeatedPart.append(resultList.get(k));
			else
				nonRepatedPart.append(resultList.get(k));
		}

		if (repeat) {
			if (repeatedPart.equals(nonRepatedPart))
				resultString += "(" + repeatedPart.toString() + ")";
			else
				resultString += nonRepatedPart.toString() + "(" + repeatedPart.toString() + ")";
		}
		else
			resultString += nonRepatedPart.toString();

		return resultString;
		}
}
