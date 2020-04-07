package challenge.leetcode.days.thirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
//    Given an array of strings, group anagrams together.
//
//            Example:
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Output:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
//    Note:
//
//    All inputs will be in lowercase.
//    The order of your output does not matter.


//Time complexity(O(nm)), Space complexity (O(n+m))
        public static List<List<String>> groupAnagrams(String[] strs) {
            //Create HashMap of Hashmap to store the count of characters of each letter in the innerMap and set of unique words in the outer map
            HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
            //Iterate over the Array of strings
            for(int i=0; i<strs.length; i++){
                //Create the inner map
                HashMap<Character, Integer> tempMap = new HashMap<>();
                //Iterate over the letters of each word and maintain the count of each letter in the tempMap
                for(int j=0; j<strs[i].length(); j++){
                    if(tempMap.containsKey(strs[i].charAt(j))){
                        int x = tempMap.get(strs[i].charAt(j));
                        tempMap.put(strs[i].charAt(j), ++x);
                    }
                    else{
                        tempMap.put((strs[i].charAt(j)), 1);
                    }
                }
                //Check if same key exists in the next word iterated, if yes, add it in the list of strings for the tempMap key, else create a new List and add there
                if(map.containsKey(tempMap))
                    map.get(tempMap).add(strs[i]);
                else{
                    List<String> tempList = new ArrayList<>();
                    tempList.add(strs[i]);
                    map.put(tempMap, tempList);
                }

            }
            //finally, convert map to list<list<string>> and return the value
            List<List<String>> result = new ArrayList<>();
            for(HashMap<Character, Integer> temp: map.keySet())
                result.add(map.get(temp));

            return result;

        }

    public static void main(String[] args) {
        String[] values = {"tea", "eat", "ate", "tan", "nat", "bat"};
        System.out.println("After grouping the anagrams together, the words are: "+groupAnagrams(values).toString());
    }
}
