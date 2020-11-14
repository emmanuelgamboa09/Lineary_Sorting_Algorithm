package RadixSort;
import java.util.Random;

/**
 * Main used to run counting sort
 * @author Emmanuel Gamboa
 *
 */
public class RadixSortMain {

	/**
	 * Our main to test radix sort
	 * @param args
	 */
	public static void main(String[] args) {
		String[] hex = new String[30];
		generateHexaDecimalArray(hex);
		RadixSort radix = new RadixSort();
		radix.radixSort(hex, 5);
	}

	/**
	 * Generates 30 hexadecimal values
	 * @param hexaDecimal array we are filling 
	 * with hexadecimal values
	 */
	public static void generateHexaDecimalArray(String[] hexadecimal) {
		for(int i = 0; i < 30; i++) {
			Random rnd = new Random();
			String zerosDigits = "00000";
			String temp = Integer.toString(rnd.nextInt(0X100000), 16);
			temp = zerosDigits.substring(temp.length()) + temp;
			hexadecimal[i] = temp;
		}
	}
}
