package com.samdide.jabg;

import java.text.DecimalFormat;

/**
 * Converts a weight on earth to the corresponding weight on the moon.
 * 
 * @author Henrik Samuelsson
 */
public class Moon {
	public static void main(String[] args) {
		double weightOnEarth = 86.2;
		double conversionFactor = 0.17;
		double weightOnMoon;

		weightOnMoon = weightOnEarth * conversionFactor;
		DecimalFormat numberFormat = new DecimalFormat("#.0");
		System.out.println(numberFormat.format(weightOnEarth)
				+ " kg on the earth corresponds to "
				+ numberFormat.format(weightOnMoon) + " kg on the moon.");
	}
}
