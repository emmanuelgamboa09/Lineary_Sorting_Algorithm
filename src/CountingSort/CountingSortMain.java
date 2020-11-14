package CountingSort;

/**
 * Main used to run counting sort
 * @author Emmanuel Gamboa
 *
 */
public class CountingSortMain {
	
	
	public final static int LARGEST_INT = 9;
	/**
	 * Our main to test the counting sort
	 * @param args
	 */
	public static void main(String[] args) {
		// all the elements to put in our array
		Element a = new Element(8,1);
		Element b = new Element(8,2);
		Element c = new Element(2,1);
		Element d = new Element(9,1);
		Element e = new Element(4,1);
		Element f = new Element(2,2);
		Element g = new Element(3,1);
		Element h = new Element(5,1);
		Element i = new Element(4,2);
		Element j = new Element(9,2);
		Element k = new Element(3,2);
		Element l = new Element(7,1);
		Element m = new Element(4,3);
		Element n = new Element(7,2);
		Element o = new Element(2,3);


		//creating both arrays for our counting sort, sorting both arrays
		Element[] arr = new Element[] {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};
		Element[] arrb = new Element[15];
		CountingSort temp = new CountingSort();
		temp.sort(arr, arrb, LARGEST_INT);
	}
}
