package CountingSort;

/**
 * Element object used in our arrays
 * to store data and relative position
 * @author Emmanuel Gamboa
 *
 */
public class Element {

	private int data;
	private int orderPosition;
	
	/**
	 * Constructer
	 * @param data integer value we want to save
	 * @param orderPosition order in which the elements are inserted into the array
	 * when compared to another element with the same given data
	 */
	public Element(int data, int orderPosition) {
		this.data = data;
		this.orderPosition = orderPosition;
	}
	
	/**
	 * Retrieve our data
	 * @return data
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * Prints Element out in the desired format
	 */
	public String toString() {
		return "(" + this.data + "," + this.orderPosition + ")";
	}
}
