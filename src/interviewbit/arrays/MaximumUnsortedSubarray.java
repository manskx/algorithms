/**
 * 
 */
package interviewbit.arrays;
import java.util.*;

import common.IO;
import common.SampleInputOutput;
/**
 * @author Ahmed
 *
 */
public class MaximumUnsortedSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listOfIntegers =  SampleInputOutput.listOfIntegers;

		ArrayList<Integer> result 	=	subUnsort(listOfIntegers);
		IO.PrintArrayList(result);
		
	}

	   public static  ArrayList<Integer> subUnsort(List<Integer> A) {
			boolean rightFound	=	 false;
			int rightMin		=	 Integer.MAX_VALUE;
			int rightMinIndex	=	0;
			boolean leftFound	=	false;
			int leftMax			=	0;
			int leftMaxIndex	=	0;
			int i 	=	0;
			int j	=	A.size()-1;
			while((!rightFound || !leftFound) && i<=j){
				if(!leftFound)
					if(A.get(i)<leftMax){
						leftFound	=	true;
					} else if(A.get(i)>leftMax){
						leftMaxIndex	=	i;
						leftMax 	=	A.get(i);
						i++;
					}else{
					    i++;
					}
				if(!rightFound)
					if(A.get(j)>rightMin){
						rightFound=	true;
			        }else if(A.get(j)<rightMin){
						rightMinIndex	=	j;
						rightMin 	=	A.get(j);
						j--;
					}
					else{
					    j--;
					}

			}

			ArrayList<Integer> result 	=	 new ArrayList<Integer>();

		 		if(!rightFound && !leftFound){
		 		result.add(-1);
		 		return result;
		 		}

		    int rightMax    =   0;
		    int lefetMin    =   Integer.MAX_VALUE;
		    
		    int resultRight     =   A.size()-1;
		    int resultLeft      =   0;
		    
		    int resultMin   =   A.get(leftMaxIndex);
		    int resultMax   =   A.get(leftMaxIndex);
		    System.out.println(i +" "+ j);
		    for(int k = leftMaxIndex; k<=rightMinIndex;k++){
		        if(A.get(k)>resultMax)
		            resultMax=A.get(k);
		        if(A.get(k)<resultMin)
		            resultMin=A.get(k);
		    }
		   
		   for( int k=0; k<=leftMaxIndex; k++){
		       if(A.get(k)> resultMin){
		        resultLeft  =   k;
		        break;
		       }
		   }
		    
		   for( int k=A.size()-1; k>=rightMinIndex; k--){
		       if(A.get(k)<resultMax){
		        resultRight =   k;
		        break;
		       }
		   }
		    
		 
		 		result.add(resultLeft);
		 		result.add(resultRight);
		 		return result;

		    }
		    
}
