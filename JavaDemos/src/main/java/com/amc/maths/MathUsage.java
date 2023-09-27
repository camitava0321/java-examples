/**
 * 
 */
package com.amc.maths;

/**
 * @author Amitava Chakraborty 2010
 *
 */
public class MathUsage {

	public static void main(String[] args) {
		double negativeValue = -4.123;
		double positiveValue = 3.121;

		//// Returns the absolute value of a double value.
		System.out.println(Math.abs(negativeValue));
		// Returns the closest long to the argument, with ties rounding to
		// positive infinity.
		System.out.println(Math.round(positiveValue));

		// Returns the arc cosine of a value; the returned angle is in the range
		// 0.0 through pi.
		System.out.println(Math.acos(0.234));
		// Returns the angle theta from the conversion of rectangular
		// coordinates (x, y)); to polar coordinates (r, theta));
		double x = 11.2, y = 35.4;
		System.out.println(Math.atan2(y, x));
		// Returns the trigonometric cosine of an angle.
		System.out.println(Math.cos(positiveValue));
		// Returns the hyperbolic cosine of a double value.
		System.out.println(Math.cosh(positiveValue));

		// Returns the sum of its arguments, throwing an exception if the result
		// overflows an int.
		int value1 = 11, value2 = 33;
		System.out.println(Math.addExact(value1, value2));
		// Returns the argument decremented by one, throwing an exception if the
		// result overflows an int.
		System.out.println(Math.decrementExact(value1));
		// Returns the argument incremented by one, throwing an exception if the
		// result overflows an int.
		System.out.println(Math.incrementExact(value1));
		// Returns the product of the arguments, throwing an exception if the
		// result overflows an int.
		System.out.println(Math.multiplyExact(value1, value2));
		// Returns the negation of the argument, throwing an exception if the
		// result overflows an int.
		System.out.println(Math.negateExact(value1));
		// Returns the floating-point number adjacent to the first argument in
		// the direction of the second argument.
		double start = 11.2, direction = 22.1;
		System.out.println(Math.nextAfter(start, direction));
		// Returns the floating-point value adjacent to d in the direction of
		// negative infinity.
		System.out.println(Math.nextDown(positiveValue));
		// Returns the floating-point value adjacent to d in the direction of
		// positive infinity.
		System.out.println(Math.nextUp(positiveValue));
		// Returns the difference of the arguments, throwing an exception if the
		// result overflows an int.
		System.out.println(Math.subtractExact(value1, value2));

		// Returns the cube root of a double value.
		System.out.println(Math.cbrt(positiveValue));

		// Returns the smallest (closest to negative infinity)); double value
		// that is greater than or equal to the argument and is equal to a
		// mathematical integer.
		System.out.println(Math.ceil(positiveValue));
		// Returns the largest (closest to positive infinity)); double value
		// that is less than or equal to the argument and is equal to a
		// mathematical integer.
		System.out.println(Math.floor(positiveValue));
		// Returns the largest (closest to positive infinity)); int value that
		// is less than or equal to the algebraic quotient.
		System.out.println(Math.floorDiv(value1, value2));
		// Returns the floor modulus of the value1rguments.
		System.out.println(Math.floorMod(value1, value2));

		// Returns the first floating-povalue1rgument with the sign of the
		// second floating-povalue1rgument.
		System.out.println(Math.copySign(positiveValue, negativeValue));

		// Returns Euler's number e raised to the power of a double value.
		System.out.println(Math.exp(positiveValue));
		// Returns ex -1.
		System.out.println(Math.expm1(positiveValue));

		// Returns the unbiased exponent used in the representation of a double.
		System.out.println(Math.getExponent(positiveValue));

		// Returns sqrt(x2 +y2) without intermediate overflow or underflow.
		System.out.println(Math.hypot(x, y));

		// Computes the remainder operation on two arguments as prescribed by
		// the IEEE 754 standard.
		System.out.println(Math.IEEEremainder(x, y));

		// Returns the natural logarithm (base e) of a double value.
		System.out.println(Math.log(positiveValue));
		// Returns the base 10 logarithm of a double value.
		System.out.println(Math.log10(positiveValue));
		// Returns the natural logarithm of the sum of the argument and 1.
		System.out.println(Math.log1p(positiveValue));
		// Returns the value of the first argument raised to the power of the
		// second argument.
		System.out.println(Math.pow(positiveValue, 5));
		// Returns the correctly rounded positive square root of a double value.
		System.out.println(Math.sqrt(positiveValue));

		// Returns the greater of two double values.
		System.out.println(Math.max(positiveValue, 119));
		// Returns the smaller of two double values.
		System.out.println(Math.min(positiveValue, 119));

		// Returns a double value with a positive sign, greater than or equal to
		// 0.0 and less than 1.0.
		System.out.println(Math.random());
		// Returns the double value that is closest in value to the argument and
		// is equal to a mathematical integer.
		System.out.println(Math.rint(positiveValue));

		// Returns d × 2scaleFactor rounded as if performed by a single
		// correctly rounded floating-point multiply to a member of the double
		// value set.
		System.out.println(Math.scalb(positiveValue, value1));
		// Returns the signum function of the argument; zero if the argument is
		// zero, 1.0 if the argument is greater than zero, -1.0 if the argument
		// is less than zero.
		System.out.println(Math.signum(positiveValue));

		// Converts an angle measured in radians to an approximately equivalent
		// angle measured in degrees.
		System.out.println(Math.toDegrees(positiveValue));
		// Returns the value of the long argument; throwing an exception if the
		// value overflows an int.
		long value = 345;
		System.out.println(Math.toIntExact(value));
		// Converts an angle measured in degrees to an approximately equivalent
		// angle measured in radians.
		System.out.println(Math.toRadians(positiveValue));
		// Returns the size of an ulp of the argument.
		System.out.println(Math.ulp(positiveValue));
	}
}
