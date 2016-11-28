/**
 * 
 */
package hackerrank;

import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * @author Ahmed
 *
 */
public class RichieRich {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String Number = in.nextLine();
		Number = in.nextLine();
		int i = 0;
		int j = n - 1;
		char[] line = Number.toCharArray();
		int swaps = 0;
		Map<Integer, Integer> swapsMap = new HashMap<Integer, Integer>();
		while (i < j) {
			Integer num1 = line[i] - '0';
			Integer num2 = line[j] - '0';
			if (!num1.equals(num2)) {
				if (num1 > num2) {
					line[j] = (char) (num1 + '0');
					;
					swapsMap.put(j, 1);
				} else {
					line[i] = (char) (num2 + '0');
					;
					swapsMap.put(j, 1);
				}
				swaps++;
				if (swaps > k) {
					System.out.println("-1");
					return;
				}
			}
			i++;
			j--;
		}

		if (swaps == k) {
			System.out.println(String.valueOf(line));
			return;
		}
		if (swaps < k) {
			System.out.println(MaximizeString(swapsMap, line, k, swaps));
			return;
		}

		in.close();
	}

	public static String MaximizeString(Map<Integer, Integer> swapsMap, char[] line, int maxSteps, int count) {
		int i = 0;
		int j = line.length - 1;
		
		while (i < j && count < maxSteps) {
			if (swapsMap.containsKey(i) || swapsMap.containsKey(j)) {
				line[i] = '9';
				line[j] = '9';
				count++;
			} else if ((maxSteps - count) > 1) {
				line[i] = '9';
				line[j] = '9';
				count += 2;
			}

			i++;
			j--;

		}
		if(maxSteps>count){
			line[line.length/2] = '9';
		}
		return String.valueOf(line);
	}

}
