package CountingSort;
import java.util.Arrays;

/**
 * Class which contains our counting sort algorithm
 * @author Emmanuel Gamboa
 *
 */
public class CountingSort {

	/**
	 * Sorts an array using the Couting sort method
	 * @param arr given array of Elements
	 * @param arrb given second array for our sorting algorithm
	 * @param k biggest value within our array
	 */
	public void sort(Element[] arr, Element[] arrb, int k) {
		int[] C = new int[k+1];
		System.out.println("Original Array: " + Arrays.toString(arr));
		
		//assigns all the indexes within C to 0
		for(int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		System.out.println("Everything assigned to 0 in the C array: " + Arrays.toString(C) + "\n");
		 
		//Counts to see how often a specific element appears in the array
		for(int j = 0; j < arr.length; j++) {
			C[arr[j].getData()] = C[arr[j].getData()] + 1;
			System.out.println("Incrementing the given index " + arr[j].getData() 
					+ " in the C array: " + Arrays.toString(C));
		}
		
		//adds all the indexes in the c array by the value in the previous index
		System.out.println("\nAdding all the previous indexes to the given index in the C array");
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
			System.out.println(Arrays.toString(C));
		}
		System.out.println();
		
		// places the elements in the a array into the b array sorted using the data
		// saved from the c array
		for(int j = arr.length-1; j >= 0; j--) {
			System.out.println("\nPutting "+arr[j] + " into arrb using the indexes " + (C[arr[j].getData()]-1)
					+ " given by array C \n"+Arrays.toString(C));
			System.out.println(Arrays.toString(arrb));
			arrb[C[arr[j].getData()]-1] = arr[j];
			C[arr[j].getData()]--;
		}
		
		System.out.println("\nArr sorted into arrb: " + Arrays.toString(arrb));
	}
	

}
