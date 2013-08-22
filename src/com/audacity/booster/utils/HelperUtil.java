package com.audacity.booster.utils;

import java.util.Random;

public class HelperUtil {

	public static int createRandomWithRenge(int min, int max) {
		
		Random rand = new Random();
		int range = max - min + 1;
		
		return rand.nextInt(range) + min;
	}
}
