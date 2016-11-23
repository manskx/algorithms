/**
 * 
 */
package hackerrank;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

/**
 * @author mansk
 *
 */
public class Gemstones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String S = in.nextLine();
		int Number = Integer.parseInt(S);

		//
		Map<Character, Integer> generalMap = new HashMap<Character, Integer>();
		//
		int count = 0;
		while (count < Number && in.hasNextLine()) {
			String Line = in.nextLine();
			Map<Character, Integer> localMap = new HashMap<Character, Integer>();
			for (int i = 0; i < Line.length(); i++) {
				if (!localMap.containsKey(Line.charAt(i))) {
					if (generalMap.containsKey(Line.charAt(i))) {
						int Num = generalMap.get(Line.charAt(i));
						generalMap.put(Line.charAt(i), ++Num);
					} else {
						generalMap.put(Line.charAt(i), 1);
					}
					localMap.put(Line.charAt(i), 1);
				}
			}
			count++;
		}
		in.close();
		int result = 0;

		for (Entry<Character, Integer> entry : generalMap.entrySet()) {
			if (entry.getValue() >= Number) {
				result++;
			}
		}

		System.out.println(result);
	}

}
