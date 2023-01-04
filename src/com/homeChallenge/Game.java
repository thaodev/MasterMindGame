package com.homeChallenge;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 3};
		
	}
	
	public static int[] playerInput() {
		Scanner sc = new Scanner(System.in);
		int[] playerNum = new int[4];
		int count = 0;
		System.out.println("Enter your guess: ");
		while(count < 4) {
			playerNum[count] = sc.nextInt();
			count++;
		}
		return playerNum;
	}
	
	public static void printPlayerInput(int[] arr) {
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void gameAlgorithm(int[] arr1, int[] arr2) {
		
	}

}
