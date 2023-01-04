package com.homeChallenge;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 3 };
		gamePlaying(arr);
	}

	public static int[] playerInput() {
		Scanner sc = new Scanner(System.in);
		int[] playerNum = new int[4];
		int count = 0;
		System.out.println("Enter your guess (1->6): ");
		while (count < 4) {
			playerNum[count] = sc.nextInt();
			count++;
		}
		return playerNum;
	}

	public static void printPlayerInput(int[] arr) {
		System.out.print("Player guesses: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print(", ");
	}

	public static boolean gameAlgorithm(int[] arr1, int[] arr2) {
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("The player had guess a correct number");
			return true;
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
			}
//				else {
//				int diff = map1.get(i) - map2.get(i);
//				if (diff != 0) {
//					countDiff = diff > 0 ? diff : -diff;
//				}
//			}
		}
		if (countDiff == 0) {
			countCorrectGuess = arr2.length - map1.size();
		} else {
			// System.out.println("countDiff = " + countDiff);
			countCorrectGuess = arr2.length - countDiff;
		}
		if (countCorrectGuess == 0 && countCorrectLocation == 0) {
			System.out.println("all incorrect");
		} else {
			System.out.println("game responds " + countCorrectGuess + " correct numbers and " + countCorrectLocation
					+ " correct location");
		}
		return false;
	}

	public static void gamePlaying(int[] arr1) {
		int[] input = new int[arr1.length];
		int remainingGuess = 3;
		boolean isGuessCorrect = false;
		while (remainingGuess > 0) {
			input = playerInput();
			printPlayerInput(input);
			isGuessCorrect = gameAlgorithm(arr1, input);
			if (isGuessCorrect) {
				System.out.println("The player had guess a correct number");
				break;
			}
			remainingGuess--;
			System.out.println("You have " + remainingGuess + " game(s) left.");
		}
		if (!isGuessCorrect) {
			System.out.println("The player’s guess was incorrect");
		}
	}
}
