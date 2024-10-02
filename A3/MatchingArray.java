/* 
 * CSC 225 - Assignment 3
 * Name: Menoa Brennan
 * Student number: V01000267
 */
 
 
import java.io.*;
import java.util.*;

public class MatchingArray {


    static boolean areSame(int[] array1, int[] array2, int index) {
        if (index == array1.length){
            return true;
        }
        if (array1[index] != array2[index]){
            return false;
        }
        else {
            return areSame(array1, array2, index + 1);
        }
    }


    //Dont change the method signature and it must return a boolean value
    static boolean match(int[] a, int[] b){

        if (a.length != b.length){
            return false;
        }

        if (areSame(a, b, 0)){
            return true;
        }

        int n = a.length;

        if (n % 2 != 0 || a.length == 0 || b.length == 0){
            return false;
        }

        int middle = n / 2;
        int[] a1 = Arrays.copyOfRange(a, 0, middle);
        int[] a2 = Arrays.copyOfRange(a, middle, n);
        int[] b1 = Arrays.copyOfRange(b, 0, middle);
        int[] b2 = Arrays.copyOfRange(b, middle, n);

        if ((areSame(a1, b1, 0) && areSame(a2, b2, 0)) || (areSame(a1, b1, 0) && areSame(a1, b2, 0)) || (areSame(a2, b1, 0) && areSame(a2, b2, 0))){
            return true;
        }else{
            return match(a1, b1) && match(a2, b2);
        }


    }
    
    public static void main(String[] args) {
    /* Read input from STDIN. Print output to STDOUT. Your class should be named MatchingArray. 

	You should be able to compile your program with the command:
   
		javac MatchingArray.java
	
   	To conveniently test your algorithm, you can run your solution with any of the tester input files using:
   
		java MatchingArray inputXX.txt
	
	where XX is 00, 01, ..., 13.
	*/

   	Scanner s;
	// READING input from a file -------------------------------------------------------
	if (args.length > 0){
		try{
			s = new Scanner(new File(args[0]));
		} catch(java.io.FileNotFoundException e){
			System.out.printf("Unable to open %s\n",args[0]);
			return;
		}
		System.out.printf("Reading input values from %s.\n",args[0]);
	}
	else 
	{
	// READING input from Stdin / Command line -------------------------------------------------------
		s = new Scanner(System.in);
		System.out.printf("Reading input values from stdin.\n");
	}     
  
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int j = 0; j < n; j++){
            a[j] = s.nextInt();
        }
        
        for(int j = 0; j < n; j++){
            b[j] = s.nextInt();
        }
        
        System.out.println((match(a, b) ? "YES" : "NO"));
    }
}
