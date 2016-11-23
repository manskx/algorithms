/**
 * 
 */
package interviewbit.arrays;

import java.util.*;

/**
 * @author mansk
 *
 */
public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void nextPermutation(ArrayList<Integer> a) {
	    int least   =   a.get(a.size()-1);
	    for(int i= a.size()-2; i>=0; i++){
	        if(a.get(i) < least){
	        	int greater	=	getGreaterThan(a, a.get(i), i, a.size()-1);
	            swap(a, i, a.size()-1);
	            insertionSort(a, i+1, a.size()-2);
	            return ;
	        }
	        
	    }
	     insertionSort(a, 0, a.size()-1);
	            return ;
	    
	}
	
	public int getGreaterThan(ArrayList<Integer> arr, int num, int k, int x){
		// retun index
		for(int i= k; i<=x; i++){
			if(arr.get(i)>num)
				return i;
		}
		return k;
		
	}
	    public void insertionSort( ArrayList<Integer> arr, int k, int x){
	        int temp	=	0;
	        for(int i=k; i<=x; i++){
    			temp	=	i;
    			for(int j=i-1; j>=k  &&(arr.get(temp)<arr.get(j)); j--){
    				if(arr.get(temp)<arr.get(j)){
    					swap(arr, temp,j);
    					temp	=	j;
    				}
    			}
	    	}
	    }
	    
	    public void swap( ArrayList<Integer> arr, int i, int j){
	        int temp   =    arr.get(i);
	        arr.set(i, arr.get(j));
	        arr.set(j, temp);
	    }

}
