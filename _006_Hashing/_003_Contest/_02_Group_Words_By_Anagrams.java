package _006_Hashing._003_Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _02_Group_Words_By_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        // HashMap stores:
        // key   -> sorted version of the word
        // value -> list of words that match this sorted form
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse each word in the array
        for (String word : strs) {

            // Convert the word into character array
            char[] arr = word.toCharArray();

            // Sort the characters
            Arrays.sort(arr);

            // Convert sorted character array back to string
            // This sorted string will be the key
            String key = new String(arr);

            // If key is not present in the map,
            // create a new list for that key
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original word into the list
            // corresponding to the sorted key
            map.get(key).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        _02_Group_Words_By_Anagrams obj = new _02_Group_Words_By_Anagrams();

        String[] strs = {"race", "care", "acre", "bake", "beak", "keep"};

        List<List<String>> ans = obj.groupAnagrams(strs);

        System.out.println("Grouped Anagrams: " + ans);
    }
}