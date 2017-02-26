package interviewbit.hashing;

import java.util.*;

public class SubstringConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		ArrayList<String> b 	=	 new ArrayList< String>();
		b.add("aaa");
		b.add("aaa");
		b.add("aaa");
		b.add("aaa");
		b.add("aaa");
		List<Integer> result 	=	 findSubstring(a, b);
		common.IO.PrintArrayList(result);
	}

	public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (a.isEmpty() || b.size() == 0)
			return result;

		int n = b.size();
		int l = b.get(0).length();
		if (a.length() < n * l)
			return result;

		// fil hashmap

		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			int num = 0;
			if (wordMap.containsKey(b.get(i)))
				num = wordMap.get(b.get(i));
			wordMap.put(b.get(i), ++num);
		}

		// loop over string chunks

		for (int i = 0; i < (a.length() - l*n+1); i++) {
			Map<String, Integer> tempMap = new HashMap<String, Integer>(wordMap);

			int size = 0;

			for (int j = 0; j < n; j++) {
				String str = a.substring(i + j * l, i + j * l + l);
				if (!tempMap.containsKey(str)) {
					break;
				} else {
					int num = tempMap.get(str);
					if (num < 1)
						break;
					size++;
					tempMap.put(str, --num);
				}

			}

			if (size == n) {
				result.add(i);
			}

		}

		return result;

	}
}
