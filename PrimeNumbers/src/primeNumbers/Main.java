package primeNumbers;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		//TODO: test cases should be bigger than :
		System.out.println(Long.MAX_VALUE);
		
		BigInteger bi = new BigInteger("123456789012345678901234567890");
		// Print it
		System.out.println(bi.toString());
		// How do you add to a BigInteger?
		bi = bi.add(new BigInteger("1"));
		System.out.println(bi.toString());

	}
	/**
	 * Check to see if the number stored in a BigInteger object is prime
	 * @param number the object to examine
	 * @return True if number is prime, false otherwise
	 */
	public Boolean isPrime(BigInteger number){
		Boolean result = true;
		// Your code
		
		return result;
	}

}
