/**
 * 
 */
package common;

import java.util.*;

/**
 * @author mansk This class contains static variables for inputs and outputs
 */
public class SampleInputOutput {

	public static Integer[] arrayOfIntegers = { 5, 9, 10, 7, 28, 6, 20, 3, 11 };
	public static Integer[] arrayOfSortedIntegers = { 3, 5, 6, 7, 9, 10, 11, 20, 28 };
	public static Integer[] arrayOfReversedSortedIntegers = { 28, 20, 11, 10, 9, 7, 6, 5, 3 };
	
	
	public static List<Integer> listOfIntegers = Arrays.asList(arrayOfIntegers);
	public static List<Integer> listOfSortedIntegers = Arrays.asList(arrayOfSortedIntegers);
	public static List<Integer> listOfReversedSortedIntegers = Arrays.asList(arrayOfReversedSortedIntegers);

	public static Integer[][] 	twoDimensionalArrayOfIntegers =	
		{
		    { 1, 2, 3 },
		    { 4, 5, 6 },
		    { 10, 11, 12 },
			{ 7, 8, 9 }
		};

	public static List<List<Integer>> twoDimensionalListOfIntegers(){
		List<List<Integer>> twoDimensionalListOfIntegers = new ArrayList<>();
		for(Integer[] rowArray: twoDimensionalArrayOfIntegers)
			twoDimensionalListOfIntegers.add(Arrays.asList(rowArray));
		return twoDimensionalListOfIntegers;
	}
	
	public static Integer[][] 	twoDimensionalOneRowArrayOfIntegers = 
		{
			{ 313, 157, 290, 113, 119, 118, 187, 360, 104, 365, 197, 103, 355, 240, 337, 174, 138, 252}
		};

	public static List<List<Integer>> twoDimensionalOneRowArrayOfIntegers(){
		List<List<Integer>> twoDimensionalListOfIntegers = new ArrayList<>();
		for(Integer[] rowArray: twoDimensionalOneRowArrayOfIntegers)
			twoDimensionalListOfIntegers.add(Arrays.asList(rowArray));
		return twoDimensionalListOfIntegers;
	}
	
	
	public static Integer[][] 	twoDimensionalOneColumnArrayOfIntegers = 
		{
			{ 1},
		    { 2 },
		    { 3 }
		};

	public static List<List<Integer>> twoDimensionalOneColumnArrayOfIntegers(){
		List<List<Integer>> twoDimensionalListOfIntegers = new ArrayList<>();
		for(Integer[] rowArray: twoDimensionalOneColumnArrayOfIntegers)
			twoDimensionalListOfIntegers.add(Arrays.asList(rowArray));
		return twoDimensionalListOfIntegers;
	}


}
