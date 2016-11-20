/**
 * 
 */
package sortingAlgorithms;

import java.util.*;

import common.IO;
import common.SampleInputOutput;

/**
 * @author mansk
 * Time complexity
 * average case nlogn
 * worst case n^2
 * depending on selecting pivot
 * space complexity
 * logn ( recursion )
 */
public class QuickSort {

	public static int count 	=	0;
	public static void main(String[] args) {
		List<Integer> arr 	=	new ArrayList<Integer>(SampleInputOutput.listOfIntegers);
		
		quickSort(arr, 0, arr.size()-1);
		IO.PrintArrayList(arr);
		System.out.println("count: "+count);

	}
	public static void quickSort(List<Integer> arr, int start, int end){
		if(start>=end) return;
		int pIndex	=	 partition(arr,start, end);
		quickSort(arr,start,pIndex-1);
		quickSort(arr,pIndex+1, end);
	}


	public static int partition(List<Integer> arr, int i, int j){
		int pIndex	=	i;
		int Pivot	=	arr.get(j);
		for(int k=i; k<j; k++){
			count++;
			if(arr.get(k)<=Pivot){
				swap(arr,pIndex,k);
				pIndex++;
			}
		}

		swap(arr,j,pIndex);
		return pIndex;

	}

	public static void swap( List<Integer> arr, int i, int j){
		int temp	=	arr.get(i);
		arr.set(i,arr.get(j));
		arr.set(j,temp);
	}
}
