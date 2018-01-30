/**
 * @author Stephen Meckstroth
 * Assignment 03
 * Course IT2045 Section 001
 * Due DAte: Jan 30, 2018
 * Description: Create an ecipse java project that determines if a number is prime or not
 * Citations: N/A
 */

package primeNumbers;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		//Instantiate the Main class
		Main m = new Main();
		
		//BigInteger bi = new bigInteger("110384710234871028347103741027412390471");
		BigInteger bi = new BigInteger("7");
		
		//Print the result of the prime test
		System.out.println(bi.toString());
		if (m.isPrime(bi) == false) {
			System.out.println(bi.toString() + " is NOT Prime!");
		} else {
			System.out.println(bi.toString() + " is Prime!");
		}
	}
	/**
	 * Check to see if the number stored in a BigInteger object is prime
	 * @param number the object to examine
	 * @return True if number is prime, false otherwise
	 */
	public Boolean isPrime(BigInteger number){
		Boolean result = false;
		BigInteger compareTo = new BigInteger("1");
		
		//Zero is assumed to be even, because number will be validated to be > 2
		//number must end in an odd number
		int[] oddNumbers = {1,3,5,7,9};
		for(int i=0; i< oddNumbers.length-1; i++){
			if(Integer.valueOf(number.toString().substring(number.toString().length()-1)) == oddNumbers[i]){
				
			}
		}
		return result;
	}

}
