/**
 * 
 */
package interviewbit.arrays;

import java.util.*;

import common.IO;
import common.SampleInputOutput;

/**
 * @author mansk
 *
 */
public class SpiralOrderMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> arr 	=	SampleInputOutput.twoDimensionalOneColumnArrayOfIntegers();
		ArrayList<Integer> result 	=	spiralOrder(arr);
		IO.PrintArrayList(result);
	}
	public static ArrayList<Integer> spiralOrder(List<List<Integer>> arr){
		ArrayList<Integer> 	result =	 new ArrayList<Integer>();
		int i_min	=	0;
		int j_min	=	0;
		int i_max	=	arr.get(0).size();
		int j_max	=	arr.size();

		while(i_min<i_max && j_min<j_max){
			// right
			for(int k= i_min; k<i_max; k++){
				result.add(arr.get(j_min).get(k));
			}
			j_min++;
			// down
			for(int k= j_min; k< j_max; k++){
				result.add(arr.get(k).get(i_max-1));
			}
			i_max--;

			// left
			if(j_min<j_max)
			for(int k= i_max-1; k>=i_min; k--){
				result.add(arr.get(j_max-1).get(k));
			}
			j_max--;
			//up
			if(i_min<i_max)
			for(int k= j_max-1; k>=j_min; k--){
				result.add(arr.get(k).get(i_min));
			}
			i_min++;

		}
		return result;
	}

}
