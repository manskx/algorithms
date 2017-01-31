/**
 * 
 */
package sorting;

import java.util.*;

import common.IO;
import common.SampleInputOutput;

/**
 * @author mansk
 * Time Complexity O(nlogn)
 * Space Complexity O(n)
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> arr =	new ArrayList<Integer>(SampleInputOutput.listOfIntegers);
		ArrayList<Integer> result	=	mergeSort(arr, 0, arr.size()-1);
		IO.PrintArrayList(result);
		
	}
	
	public static ArrayList<Integer> mergeSort(List<Integer> arr, int start, int end){
		if(start>=end){
			ArrayList<Integer> result 	=	 new ArrayList<Integer>();
			result.add(arr.get(start));
			return result;
		}
		int mid 	=	(end- start)/2 + start;

		ArrayList<Integer> arr1 	=	mergeSort(arr, start,mid);
		ArrayList<Integer> arr2		=	mergeSort(arr, mid+1, end);
		ArrayList<Integer> result	=	Merge(arr1, arr2);
		return result;

	}	
	public static ArrayList<Integer> Merge( ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		int i=0;
		int j=0;
		ArrayList<Integer> result 	=	 new ArrayList<Integer>();

		while(i<arr1.size()||j<arr2.size()){
			if(i==arr1.size()){
				result.add(arr2.get(j));
				j++;
				continue;
			}
			if(j==arr2.size()){
				result.add(arr1.get(i));
				i++;
				continue;
			}
			if(arr1.get(i)<arr2.get(j)){
				result.add(arr1.get(i));
				i++;
			}else{
				result.add(arr2.get(j));
				j++;
			}
		}
		
		return result;

	}

}
