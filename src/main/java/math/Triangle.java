package math;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

/**
 * This class represent a concept of a geometric triangle. It contains three
 * variables to store the length of each side and methods to determine it's
 * properties.
 * 
 * @author bink81@gmail.com
 */
public final class Triangle {
	// Lengths of triangle's sides are BigDecimals to support huge numbers and
	// prevent inaccuracies.
	private final BigDecimal sideA, sideB, sideC;

	protected enum Type {
		/**
		 * An equilateral triangle is a triangle in which all three sides are
		 * equal.
		 */
		EQUILATERAL,

		/**
		 * An isosceles triangle is a triangle in which two and only two sides
		 * are equal.
		 */
		ISOSCELES,

		/**
		 * An scalene triangle is a triangle in which all three sides are
		 * different.
		 */
		SCALENE
	}

	/**
	 * The constructor ensures only valid triangles are instantiated.
	 * 
	 * @param sideA
	 *            - positive, decimal value of side A
	 * @param sideB
	 *            - positive, decimal value of side B
	 * @param sideC
	 *            - positive, decimal value of side C
	 * @throws TriangleUnequalException
	 *             when a triangle is unequal (@see TriangleUnequalException)
	 */
	public Triangle(final BigDecimal sideA, final BigDecimal sideB, final BigDecimal sideC)
			throws TriangleUnequalException {
		Preconditions.checkNotNull(sideA, "sideA must not be null");
		Preconditions.checkNotNull(sideB, "sideB must not be null");
		Preconditions.checkNotNull(sideC, "sideC must not be null");
		Preconditions.checkArgument(sideA.compareTo(BigDecimal.ZERO) > 0, "sideA must be positive");
		Preconditions.checkArgument(sideB.compareTo(BigDecimal.ZERO) > 0, "sideB must be positive");
		Preconditions.checkArgument(sideC.compareTo(BigDecimal.ZERO) > 0, "sideC must be positive");
		checkValidity(sideA, sideB, sideC);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	/**
	 * Check if a triangle is unequal (a side is bigger or equals than the sum
	 * of the remaining two).
	 */
	private void checkValidity(final BigDecimal side1, final BigDecimal side2, final BigDecimal side3)
			throws TriangleUnequalException {
		if (side1.compareTo(side3.add(side2)) >= 0) {
			throw new TriangleUnequalException(side1 + " is too big");
		}
		if (side2.compareTo(side3.add(side1)) >= 0) {
			throw new TriangleUnequalException(side2 + " is too big");
		}
		if (side3.compareTo(side1.add(side2)) >= 0) {
			throw new TriangleUnequalException(side3 + " is too big");
		}
	}

	/**
	 * Determine a type of the triangle.
	 * 
	 * @return type of a triangle (either {@link Type#EQUILATERAL},
	 *         {@link Type#ISOSCELES} or {@link Type#SCALENE})
	 */
	public Type determineType() {
		boolean areSidesABEqual = areEqual(sideA, sideB);
		boolean areSidesBCEqual = areEqual(sideB, sideC);
		if (areSidesABEqual && areSidesBCEqual) {
			return Type.EQUILATERAL;
		} else if (areSidesABEqual || areSidesBCEqual || areEqual(sideA, sideC)) {
			return Type.ISOSCELES;
		}
		return Type.SCALENE;
	}

	private boolean areEqual(final BigDecimal x, final BigDecimal y) {
		return x.compareTo(y) == 0;
	}

	/**
	 * Returns a length of a side A as defined in the constructor.
	 * 
	 * @return length of side A
	 */
	public BigDecimal getSideA() {
		return sideA;
	}

	/**
	 * Returns a length of a side B as defined in the constructor.
	 * 
	 * @return length of side B
	 */
	public BigDecimal getSideB() {
		return sideB;
	}

	/**
	 * Returns a length of a side C as defined in the constructor.
	 * 
	 * @return length of side C
	 */
	public BigDecimal getSideC() {
		return sideC;
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" +
				sideC + "]";
	}
}
