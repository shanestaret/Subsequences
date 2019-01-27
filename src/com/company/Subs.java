package com.company;

import java.util.ArrayList;

public class Subs {

    public static void subsequence(String s, ArrayList<String> sArray) {

        //begin the substring at the first letter
        for (int i = 0; i < s.length(); i++) {
            //end the string starting with the last letter, then work way in
            for (int j = s.length(); j > i; j--) {
                String sub = s.substring(i, j);

                if (!sArray.contains(sub)) {
                    sArray.add(sub);
                }

                // delete one character of the given substring to create another substring and repeat the entire process for that substring...recursion
                for (int k = 1; k < sub.length() - 1; k++) {
                    String subPart = sub.substring(0, k) + sub.substring(k + 1, sub.length());
                    subsequence(subPart, sArray);
                }
            }
        }
    }

    public static ArrayList<String> longestSubsequence(ArrayList<String> s1Array, ArrayList<String> s2Array) {
        int longestInt = 1;
        ArrayList<String> longestStrings = new ArrayList();

        for(int i = 0; i < s1Array.size(); i++) {
            for(int j = 0; j < s2Array.size(); j++) {
                if(s1Array.get(i).equals(s2Array.get(j)) && !longestStrings.contains(s1Array.get(i))) {
                    if(s1Array.get(i).length() > longestInt) {
                        longestStrings.clear();
                        longestStrings.add(s1Array.get(i));
                        longestInt = s1Array.get(i).length();
                    }
                    else if(s1Array.get(i).length() == longestInt)
                        longestStrings.add(s1Array.get(i));
                }
            }
        }
        return longestStrings;
    }
}
