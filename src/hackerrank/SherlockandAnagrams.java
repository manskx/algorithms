package hackerrank;

import java.util.*;

public class SherlockandAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String S = in.nextLine();

		int count = 0;
		while (count < Integer.parseInt(S) && in.hasNextLine()) {
			String currentString = in.nextLine();
			System.out.println(getAnagramsCount(currentString));
			count++;
		}
	}

	public static int getAnagramsCount(String s) {

		int count = 0;
		Map<String, Integer> AnagramMap = new HashMap<String, Integer>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String tempString = s.substring(i, j + 1);
				String sortedTempString = getSortedString(tempString);

				if (AnagramMap.containsKey(sortedTempString)) {
					int anagramCount = AnagramMap.get(sortedTempString);
					count += anagramCount;
					AnagramMap.put(sortedTempString, ++anagramCount);
				} else {
					AnagramMap.put(sortedTempString, 1);
				}

			}
		}
		return count;

	}

	public static String getSortedString(String S) {
		char[] charsOfS = S.toCharArray();
		Arrays.sort(charsOfS);

		String SortedS = new String(charsOfS);
		return SortedS;
	}
}
