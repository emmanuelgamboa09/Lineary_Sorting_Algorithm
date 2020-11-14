package BucketSort;

/**
 * Element object used in our arrays
 * to store data and relative position
 * @author Emmanuel gamboa
 *
 */
public class Element {

	private double data;
	private int orderPosition;
	
	/**
	 * Constructor
	 * @param data double value we want to save
	 * @param orderPosition order in which the elements are inserted into the array
	 * when compared to another element with the same given data
	 */
	public Element(double data, int orderPosition) {
		this.data = data;
		this.orderPosition = orderPosition;
	}
	
	/**
	 * Retrieve the data
	 * @return data
	 */
	public double getData() {
		return data;
	}
	
	/**
	 * Setter for data
	 * @param data new data value
	 */
	public void setData(double data) {
		this.data = data;
	}
	
	/**
	 * When element is called to be printed, prints the data 
	 * and positions out in the set format.
	 */
	public String toString() {
		return "(" + this.data + "," + this.orderPosition + ")";
	}
}

