package math;

/**
 * An exception thrown when a triangle inequality rule is broken, which states:
 * the length of a side of a triangle is less than the sum of the lengths of the
 * other two sides and greater than the difference of the lengths of the other
 * two sides.
 * 
 * @author bink81@gmail.com
 */
class TriangleUnequalException extends Exception {
	public TriangleUnequalException(String message) {
		super(message);
	}
}
