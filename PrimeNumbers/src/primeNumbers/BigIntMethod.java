/***********
 * Class contains method to test if BigInteger is prime
 * Bill Nicholson and Evan Batsch
 * batschew@mail.uc.edu
 */
package primeNumbers;

import java.math.BigInteger;

/**
 * @author Evan Batsch
 */
public class BigIntMethod {
	// Property
	BigInteger bigInt;

	// Constructor
	public BigIntMethod(BigInteger bigInt) {
		setBigInteger(bigInt);
	}

	// Getter
	public BigInteger getBigInteger() {
		return bigInt;
	}

	// Setter
	public void setBigInteger(BigInteger bigInt) {
		this.bigInt = bigInt;
	}

	/**
	 * Tests if a given BigInteger is prime
	 */
	// Method
	public boolean testIfPrime(BigInteger bigInt) {
		boolean isPrime = true;
		// flag
		if (bigInt.intValue() == 2) { // Return true if 2
			return isPrime;
		}
		BigInteger intMax = new BigInteger("2147483647");
		// Maximum size of int data type
		// If BigInteger is less than maximum size of int data type, use cheaper
		// "int" methods
		if (bigInt.compareTo(intMax) == -1 || bigInt.compareTo(intMax) == 0) {
			// Integer-based loop
			for (int i = 2; i < bigInt.intValue(); i++) {
				if (bigInt.intValue() % i == 0) {
					isPrime = false;
					return isPrime;
				}
			}
			return isPrime;
			// If BigInteger is larger than int maximum, use more expensive
			// methods
		} else {
			// Variables to be used in loop below
			BigInteger one = new BigInteger("1");
			BigInteger zero = new BigInteger("0");
			BigInteger i = new BigInteger("2");
			// BigInteger-based loop
			for (; i.compareTo(bigInt) == -1; i.add(one)) {
				if ((bigInt.mod(i)).compareTo(zero) == 0) { // if bigInt % i is
															// 0
					isPrime = false;
					return isPrime;
				}
			}
			return isPrime; // if bigInt is prime
		}
	}

	@Override
	// To string method
	public String toString() {
		return "BigIntMethod [bigInt=" + bigInt + "]";
	}
}