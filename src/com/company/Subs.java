package com.company;

import java.util.ArrayList;

public class Subs {

    //method that determines all subsequences given a string "s", puts all subsequences into ArrayList "sArray"
    public static void subsequence(String s, ArrayList<String> sArray) {

        //begin the substring at the first letter
        for (int i = 0; i < s.length(); i++) {
            //end the substring starting with the last letter, then working way in
            for (int j = s.length(); j > i; j--) {
                String sub = s.substring(i, j);

                //if this substring is new, put it into the ArrayList
                if (!sArray.contains(sub)) {
                    sArray.add(sub);
                }

                //delete one character of the given substring to create another substring and repeat the entire process for that substring...recursion
                for (int k = 1; k < sub.length() - 1; k++) {
                    String subPart = sub.substring(0, k) + sub.substring(k + 1, sub.length());
                    subsequence(subPart, sArray);
                }
            }
        }
    }

    //method that returns the longest common subsequences between both Strings, must be given both ArrayLists that have contain all subsequences of each String
    public static ArrayList<String> longestSubsequence(ArrayList<String> s1Array, ArrayList<String> s2Array) {
        //by default, the longest subsequence must be at least 1 character
        int longestInt = 1;
        //creation of new ArrayList that will hold the longest common subsequences between both Strings
        ArrayList<String> longestStrings = new ArrayList();

        //nested loops that compare values in each given ArrayList and add a value to "longestStrings" if it is common to both given ArrayLists, clear "longestStrings" if a longer common subsequence is found and then add that new subsequence to "longestStrings"
        for(int i = 0; i < s1Array.size(); i++) {
            for(int j = 0; j < s2Array.size(); j++) {
                //if a value is found that is common to both ArrayLists AND this value has not already been found, then add it to "longestStrings"
                if(s1Array.get(i).equals(s2Array.get(j)) && !longestStrings.contains(s1Array.get(i))) {
                    //if this new value is longer than any other value currently in "longestStrings", clear "longestStrings" and add this new value to it
                    if(s1Array.get(i).length() > longestInt) {
                        longestStrings.clear();
                        longestStrings.add(s1Array.get(i));
                        longestInt = s1Array.get(i).length();
                    }
                    //otherwise, if this new value is of equal length to the values currently in "longestStrings", add this new value to it
                    else if(s1Array.get(i).length() == longestInt)
                        longestStrings.add(s1Array.get(i));
                }
            }
        }
        return longestStrings;
    }
}
