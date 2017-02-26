/**
 * 
 */
package common;

import java.util.*;

/**
 * @author mansk
 * this is I/O test
 */
public class IO {

	public static void PrintArrayList(List<Integer> list){
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public static void PrintArrayListStrings(List<String> list){
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public static void PrintTwoDimensionalArray(ArrayList<ArrayList<Integer>> arr){
		for(int i=0; i<arr.size(); i++){
			String x	=	"";
			for(int j=0; j<arr.get(i).size(); j++){
				x	+=	" "+arr.get(i).get(j);
			}
			System.out.println(x);
		}
	}
}
