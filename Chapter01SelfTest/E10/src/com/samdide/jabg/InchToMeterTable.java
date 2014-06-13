package com.samdide.jabg;

import java.text.DecimalFormat;

/**
 * Builds and prints a inches to meters table.
 * 
 * @author Henrik Samuelsson
 */

public class InchToMeterTable {
	private static final int ENTRIES_PER_LINE = 12;
	private static final int INCHES_PER_FEET = 12;
	private static final int FEET_MAX = 12;
	private static final double CONVERSION_FACTOR = 39.37;
	
	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("0.0000");
		for(int i = 0; i < FEET_MAX; i++) {
			for(int j = 0; j < ENTRIES_PER_LINE; j++) {
				int inches = i * INCHES_PER_FEET + j;
				double meters = inches / CONVERSION_FACTOR;
				System.out.print(inches + "\"=" + numberFormat.format(meters) + "m\t" );
			}
			System.out.println();
		}
	}

}
