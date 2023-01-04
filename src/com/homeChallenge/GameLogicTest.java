package com.homeChallenge;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameLogicTest {

	public static void main(String[] args) {
		int[] arr1 = { 3, 4, 5, 3 };
		int[] arr2 = {2, 2, 1, 2};
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("The player had guess a correct number");
			
		}
		Map<Integer, Integer> map1 = new LinkedHashMap<>();
		Map<Integer, Integer> map2 = new LinkedHashMap<>();
		int countCorrectLocation = 0;
		int countCorrectGuess = 0;
		for (int i = 0; i < 4; i++) {
			map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
			map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);

			if (arr1[i] == arr2[i]) {
				countCorrectLocation++;
			}
		}
		int countDiff = 0;
		for (int i : map2.keySet()) {
			if (map1.containsKey(i)) {
				countDiff += Math.min(map1.get(i), map2.get(i));
			} else {
				countDiff += map2.get(i);
			}

		}
			countCorrectGuess = arr2.length - countDiff;
		if (countCorrectGuess == 0 && countCorrectLocation == 0) {
			System.out.println("all incorrect");
		} else {
			System.out.println("game responds " + countCorrectGuess + " correct numbers and " + countCorrectLocation
					+ " correct location");
		}
	}

}
