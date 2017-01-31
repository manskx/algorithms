/**
 * 
 */
package sorting;

import java.util.*;

import common.IO;
import common.SampleInputOutput;

/**
 * @author mansk
 * Time complexity O(n^2)
 * Best Case: O(n) --- sorted array
 * Worst case: O(n^2) --- reversed sorted array
 * Space complexity O(1)
 * 
 */
public class InsertionSort {

	public static List<Integer> arr;
	
	public static void main(String[] args) {
		arr 	=	new ArrayList<Integer>(SampleInputOutput.listOfIntegers);
		int temp	=	0;
		int count	=	0;
		for(int i=0; i< arr.size(); i++){
			temp	=	i;
			for(int j=i-1; j>=0  &&(arr.get(temp)<arr.get(j)); j--){
				count++;
				if(arr.get(temp)<arr.get(j)){
					swap(temp,j);
					temp	=	j;
				}
			}
		}
		System.out.println("Count: "+count);
		IO.PrintArrayList(arr);
		
	}

	
	public static void swap(int i, int j){
		int temp 	=	arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
		
	}
}
