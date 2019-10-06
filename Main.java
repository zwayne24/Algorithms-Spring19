package cmsc351s19;

import java.util.Scanner;

import cmsc351s19.ModifiedQuicksorter;
import cmsc351s19.PermutationGenerator;
import java.util.Random;
/**
 * Sample Main for you to test your class(es)
 * You don't need to submit this file
 */
public class Main {

	public static void main(String[] args) {
		// Create a scanner from stdin
		Scanner scanner = new Scanner(System.in);
		// First value is the total number of elements in the array
		int totalmoves = 0;
		int totalcomps = 0;
		Random rand = new Random(); 
		PermutationGenerator gen = new PermutationGenerator(rand);
		ModifiedQuicksorter sorter = new ModifiedQuicksorter(1);
		int[] array1 = gen.nextPermutation(100);
		sorter.sort(array1);
		for(int i=0;i<100;i++) {
			System.out.print(array1[i]+" ");
		}
		
//		for (int j = 1;j<=499;j++) {
//			for(int i = 1; i <= 1000; i++) {
//			ModifiedQuicksorter sorter = new ModifiedQuicksorter(j);
//			int[] array1 = gen.nextPermutation(1000);
//			sorter.sort(array1);
//			totalcomps+=sorter.getComparisons();
//			totalmoves+=sorter.getMoves();
//			}
//			System.out.print(totalcomps/1000 +"\t");
//			System.out.print(totalmoves/1000);
//			System.out.println();
//			totalcomps = 0;
//			totalmoves = 0;
//		}
		scanner.close();
		// Sort the array

		System.out.println();
		
	}

}
