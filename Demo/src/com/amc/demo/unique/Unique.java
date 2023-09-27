package com.amc.demo.unique;

import java.util.HashSet;

public class Unique {
	// Defines max capacity: determines how big will be the number.
	// With this value the number can atmost be 999.
	private static int MAXSIZE = 3;

	// Defines the range, default 0-1000.
	private static int fromNumber = 0;

	private static int toNumber = 1000;

	/**
	 * The experiment will be carried out between 0 and toNumber
	 * 
	 */
	public Unique(int toNumber) {
		if (toNumber > 0) {
			this.toNumber = toNumber;
		}
		operate();
	}

	/**
	 * The experiment will be carried out between a supplied fromNumber and a
	 * supplied toNumber.
	 */
	public Unique(int fromNumber, int toNumber) {
		if (toNumber > 0) {
			this.toNumber = toNumber;
		}
		if (fromNumber > 0 && fromNumber < toNumber) {
			this.fromNumber = fromNumber;
		}
		operate();
	}

	private void operate() {

		System.out.println("From Number: "+fromNumber+" To Number: "+toNumber);
		int number = this.fromNumber;

		// Determine max size
		MAXSIZE = String.valueOf(this.toNumber).length();

		// Calculate the number of numbers to iterate through
		long totalNumbers = this.toNumber - this.fromNumber;

		// Defining & Initializing few variables
		HashSet setSums = new HashSet();
		long duplicates = 0L;

		// for each of the 'totalNumbers' numbers
		for (; number <= this.toNumber; number++) {
			int weightedSum = calculateWeightedSum(number);
			// The Set is used to store the sums which have not appeared more
			// than once.
			// If this 'sum' do not exist in the Set, add it.
			boolean fRet = setSums.add(weightedSum);
			if (!fRet) {
				duplicates++;
			}
		}

		// Gives a figure how many times an identical weighted sum appears
		// within the selected number range.
		// Will be less if the experiment is done within a smaller range.
		double percent = ((double) duplicates / (double) totalNumbers) * 100.0;
		System.out.println(percent + " % duplicates");
		System.out.println("Total no of elements in the Set : "+setSums.size());
	}

	/**
	 * Calculation of the weighted sum of the digits of the number. Strategy
	 * weightedSum = (digit*position)+... The first digit will be multiplied by
	 * 1, 2nd digit by 2 and so on, the results will be added to create the
	 * weighted sum. Hence weightedSum for the number 989 will be
	 * (9*1+8*2+9*3)=52.
	 * 
	 * @return
	 */
	private int calculateWeightedSum(int number) {
		int sum = 0;
		// Define as array with max capacity
		int[] array = new int[MAXSIZE];
		String temp = padNumber(number);
		// Initialize number array with 0s
		for (int j = 0; j < array.length; j++) {
			array[j] = 0;
		}
		for (int j = 0; j < array.length; j++) {
			String temp1 = String.valueOf(temp.charAt(j));
			array[j] = Integer.valueOf(temp1).intValue();
			sum = sum + (array[j] * (j + 1));
		}
		System.out.println(sum + "  " + temp);
		return sum;
	}

	private String padNumber(int number) {
		String paddedNumber = String.valueOf(number);
		int length = paddedNumber.length();
		// pre-padding the number with 0 if it is less than MAXSIZE digits.
		// 5->005 and 23->023 but 178 will stay the same.
		for (int i = length; i < MAXSIZE; i++) {
			paddedNumber = "0" + paddedNumber;
		}

		return paddedNumber;
	}

	public static void main(String[] args) {
		// Instantiate unique
		Unique unique = new Unique(100000);
	}

}
