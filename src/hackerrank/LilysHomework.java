/**
 * 
 */
package hackerrank;
import java.util.*;
import java.io.*;
/**
 * @author mansk
 *
 */
public class LilysHomework {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in 	=	new Scanner(System.in);
		String S 		=	in.nextLine();
		ArrayList<Integer> arr 	=	 new ArrayList<Integer>();
		int count 	=	 0;
		while(count<Integer.parseInt(S)&&in.hasNextInt()){
			count++;
			int number 	=	in.nextInt();
			arr.add(number);
			
		}
		int result	=	nOfSwaps(arr);
		System.out.println(result);
		in.close();
	}	

	public static int nOfSwaps(ArrayList<Integer> arr){
		ArrayList<Integer> arr2	=	 new ArrayList<Integer>(arr);
		Collections.sort(arr2);
		int num	=	0;
		for(int i=0; i<arr.size(); i++){
			if(!arr.get(i).equals(arr2.get(i))){
				num++;
			}
		}
		
		int firstTry	=	num/2 + num%2;
		
		num	=	0;
		for(int i=0; i<arr.size(); i++){
			if(!arr.get(i).equals(arr2.get(arr2.size()-i-1))){
				num++;
			}
		}
		
		return Math.min(firstTry, num/2 + num%2);
	}
}
