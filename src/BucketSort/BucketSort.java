package BucketSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class which contains our bucket sort algorithm
 * @author Emmanuel Gamboa
 *
 */
public class BucketSort {

	public final static int VALUE_ADJUSTMENT = 10;
	public final static int BUCKET_SIZE = 10;
	
	/**
	 * Sorts an array using the bucket sort method
	 * @param arr array of elements passed into the function
	 * in which we are going to perform bucket sort on
	 */
	public void sort(Element[] arr) {
		int n = BUCKET_SIZE;
		@SuppressWarnings("unchecked")
		ArrayList<Element>[] B = new ArrayList[n];
		
		// fills the B array with empty list
		for(int i = 0; i < n; i++) {
			B[i] = new ArrayList<Element>();
		}
		System.out.println(Arrays.toString(arr));
		
		// Adjust the data of our original array inorder to make it a decimal value
		for(int i = 0; i < arr.length; i++) {
			arr[i].setData(arr[i].getData()/VALUE_ADJUSTMENT);
		}
		System.out.println("\nValues adjusted" + Arrays.toString(arr) + "\n");
		// Adds the elements into their designated arraylist. 
		for(int i = 0; i < arr.length; i++) {
			B[(int) Math.floor((arr[i].getData() * VALUE_ADJUSTMENT))].add(arr[i]);
			System.out.println("Elements added to Arraylist B: " + Arrays.toString(B));
		}
		System.out.println();
		
		// performs an insertion sort on the arraylist.
		for(int i = 0; i < n-1; i++) {
			insertionSort(B[i]);
			System.out.println("InsertionSort B: " + Arrays.toString(B));
		}
		System.out.println();
		int index = 0;
		
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i].size(); j++) {
				arr[index] = B[i].get(j);
				index++;
			}				
			System.out.println("Putting back into arr: " + Arrays.toString(arr));
		}
		System.out.println();
		
		//converts data back to the original form
		for(int i = 0; i < arr.length; i++) {
			arr[i].setData(arr[i].getData()*VALUE_ADJUSTMENT);
			System.out.println("Multiplying values by n: " + Arrays.toString(arr));
		}
	}

	/**
	 * Insertion sort used within our Bucket Sort sort(Element[] arr) function
	 * @param arr arraylist in which we perform an insertion sort on
	 */
	private void insertionSort(ArrayList<Element> arr) {
		for(int i = 1; i < arr.size(); i++) {
			Element key = arr.get(i);
			int j = i-1;

			while(j >= 0 && arr.get(i).getData() > key.getData()) {
				arr.set(j+1, arr.get(j));
				j=j-1;
			}
			arr.set(j+1, key);
		}
	}
}
