package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s1 = "";
		String s2 = "";

		while(true) {
			System.out.print("Enter in first string (enter \"-1\" to exit): ");
			s1 = input.next();
			if(s1.equals("-1")) {
				System.out.println("You have exited.");
				System.exit(0);
			}

			System.out.print("Enter in second string (enter \"-1\" to exit): ");
			s2 = input.next();
			if(s2.equals("-1")) {
				System.out.println("You have exited.");
				System.exit(0);
			}

			ArrayList<String> s1Array = new ArrayList();
			ArrayList<String> s2Array = new ArrayList();

			Subs.subsequence(s1, s1Array);
			Subs.subsequence(s2, s2Array);

			System.out.println("\n----------------------------------------");

			System.out.println("All subsequences of first string: " + s1Array.toString());
			System.out.println("All subsequences of second string: " + s2Array.toString());

			System.out.println("List of the longest common subsequences between each string: " + Subs.longestSubsequence(s1Array, s2Array) + "\n----------------------------------------\n");
		}
	}
}
