package com.datastructures;

public class StringUtils {
    public static int countVowels(String str){
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aieuo";

        for (var ch : str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;

        return  count;
    }

    public static String reverse(String str){
        if (str == null)
            return "";

        // String reversed = "";
        // StringBuilder doesn't recreate a new string each time we append a char.
        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) // O(n)
            //reversed += str.charAt(i); // O(n)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    public static String reverseWords(String sentence){
        //split the sentece in individual words
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (var i = words.length - 1; i >= 0; i--)
            reversed.append(words[i] + " ");

        return reversed.toString().trim();

    }

}
