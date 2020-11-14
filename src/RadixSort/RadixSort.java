package RadixSort;
import java.util.Arrays;

/**
 * Class which contains our radix sort algorithm
 * @author Emmanuel Gamboa
 *
 */
public class RadixSort {

	//adjust the value for the index which we want to look at.
	public final static int POSITION_CORRECTOR = 1;
	
	/**
	 * Sorts an array using radix sort algorithm with counting sort
	 * @param arr the array we are performing the sort on
	 * @param d the longest length index within the array
	 */
	public void radixSort(String[] arr, int d) {
		for(int i = 0; i < d; i++) {
			String[] arrb = new String[30];
			countingSort(arr, arrb, i);
			for(int j = 0; j < arrb.length; j++) {
				arr[j] = arrb[j];
			}
			System.out.println(Arrays.toString(arr) + "\n");
		}
		convertHexaDecimalToInteger(arr);
	}

	/**
	 * Counting sort function that our radix sort uses to 
	 * perform the sorting algorithm
	 * @param arr arr which we are sorting
	 * @param arrb the array we use to put the sorted
	 * values into
	 * @param d the index in which we are looking at within the length of the word
	 */
	private void countingSort(String[] arr, String[] arrb, int d) {
		int k = getLargestHexaDecimal(arr, d);
		int[] C = new int[k + 1];
		
		for(int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		
		for(int j = 0; j < arr.length; j++) {
			String temp = String.valueOf(arr[j].charAt(arr[j].length() - POSITION_CORRECTOR - d));
			int value = Integer.parseInt(temp, 16);
			C[value] = C[value] + 1;
		}
		
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
			System.out.println(Arrays.toString(C));
		}
		
		for(int j = arr.length-1; j >= 0; j--) {
			String temp = String.valueOf(arr[j].charAt(arr[j].length() - POSITION_CORRECTOR - d));
			int value = Integer.parseInt(temp, 16);
			arrb[C[value]-1] = arr[j];
			C[value]--;
		}
	}
	
	/**
	 * Returns the largest hexadecimal value within the array
	 * looking only at the given specific index
	 * @param arr array to search for largest hexadecimal value
	 * @param index which character we are looking at within the array.
	 * 0 means beginning and anything higher moves to the left of the word
	 * @return largest hexadecimal
	 */
	private int getLargestHexaDecimal(String[] arr, int index) {
		String temp = String.valueOf(arr[0].charAt(arr[0].length() - POSITION_CORRECTOR - index));
		int largest = (Integer.parseInt(temp, 16));
		for(int i = 1; i < arr.length; i++) {
			temp = String.valueOf(arr[i].charAt(arr[i].length() - POSITION_CORRECTOR - index));
			int tempValue = Integer.parseInt(temp, 16);
			if(tempValue > largest) {
				largest = tempValue;
			}
		}
		return largest;
	}
	
	/**
	 * Converts our hexadecimal into an integer
	 * used to make sure our values are sorted correctly
	 * @param arr array of hexadecimal values
	 * @return array of integers inorder to make
	 * sure the values are sorted correctly
	 */
	public static void convertHexaDecimalToInteger(String[] arr) {
		int[] intArray = new int[30];
		for(int i = 0; i < arr.length; i++) {
			int largest = Integer.parseInt(arr[i], 16);
			intArray[i] = largest;
		}
		System.out.println(Arrays.toString(intArray));
	}
}
