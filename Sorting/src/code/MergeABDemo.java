package code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeABDemo {

	public static void main(String[] args) throws IOException
	{
		// A: inputArrayLeft		B: inputArrayRight 
		ArrayList<Integer> inputArrayLeft = new ArrayList<Integer>();
		ArrayList<Integer> inputArrayRight = new ArrayList<Integer>();
		ArrayList<Integer> outputArray = new ArrayList<Integer>();
		MergeAB engine = new MergeAB();
		int i=0;
		
		if(args.length != 3 || args[0].equalsIgnoreCase("help"))
		{
			System.out.println("Argument is empty! Please provide the path of the inputL.txt and inputR.txt");
			System.out.println("MergeSort Path/to/inputL.txt Path/to/inputR.txt Path/to/output.txt");
			return;
		}
		
		// Get an array of number from input.txt
		/*
		 *  input.txt assumption:
		 *  1) all numbers are integer
		 *  2) one line only has one number
		 *  3) number should not out of the range of int data type
		 *  4) args[0] provide the path of inputL.txt
		 *  4) args[1] provide the path of inputR.txt
		 */
		Scanner scL = new Scanner(new File(args[0]));
		while (scL.hasNextInt())
		{
			inputArrayLeft.add(new Integer(scL.nextInt()));
		}
		scL.close();
		Scanner scR = new Scanner(new File(args[1]));
		while (scR.hasNextInt())
		{
			inputArrayRight.add(new Integer(scR.nextInt()));
		}
		scR.close();
		
		// Sort the numbers
		long startTime=0, endTime=0;
		System.out.println("Start to do the MergeAB, and the Current Time is " + (startTime=System.nanoTime()));
		outputArray = (ArrayList<Integer>) engine.Merge(inputArrayLeft, inputArrayRight);
		System.out.println("Finish the MergeAB, and the End time is " + (endTime=System.nanoTime()));
		System.out.println("Total Execution Time is " + (endTime-startTime) + " nanoseconds");
		
		// Output the result to output.txt
		FileOutputStream fos = new FileOutputStream(args[2]); 
		OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
		for(i=0; i<outputArray.size(); i++)
			out.write(outputArray.get(i).toString() + "\n");
		out.close();
	}
}
