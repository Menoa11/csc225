/* PairSum225.java
   CSC 225 - SUMMER 2024

   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java PairSum input_file
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class PairSum {
	/* PairSum225()
		The input array A will contain non-negative integers. The function
		will search the input array A for two elements which sum to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.

	*/
	public static boolean sortingMerge(int[] A) {
		mergeSort(A, 0, A.length - 1);
		int left = 0;
		int right = A.length - 1;

		while (left < right) {
			int sum = A[left] + A[right];
			if (sum == 225) {
				return true;
			} else if (sum < 225) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void mergeSort(int[] A, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			//Breaks down into smaller arrays
			mergeSort(A, left, mid);
			mergeSort(A, mid + 1, right);

			//Starts the merge once recursively broken down
			merge(A, left, mid, right);
		}
	}

	public static void merge(int[] A, int left, int mid, int right) {
		//Looks at both seperate arrays and finds whats greater basically sorting them
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = A[left + i];
		for (int j = 0; j < n2; j++)
			R[j] = A[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			A[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			A[k] = R[j];
			j++;
			k++;
		}
	}


	/* main()
	   Contains code to test the PairSum225 function.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		boolean pairExists = sortingMerge(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		System.out.printf("Array %s a pair of values which add to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
