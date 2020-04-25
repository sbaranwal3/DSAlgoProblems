package challenge.leetcode.days.thirty;

import java.util.LinkedHashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */

//Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


class LRUCache {

    private int capaCity;
    //Using LinkedHashMap to design the LRU to make sure order is maintained & Time Complexity is O(1)
    private LinkedHashMap<Integer, Integer> map;

    //constructor
    public LRUCache(int capacity) {
        capaCity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            //After fetching the value, remove and put back so that the key becomes most recently used
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;

    }

    public void put(int key, int value) {
        //While putting, remove the k,v pair if it exists and then put the new k,v pair
        if(map.containsKey(key))
            map.remove(key);
        //If the map is already full with the given capacity, remove the LRU key and then put the new k,v pair
        else if(map.size() == capaCity)
            map.remove(map.keySet().iterator().next());
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        System.out.println("Value with key 1 inseted is: "+obj.get(1));
        obj.put(2,2);
        System.out.println("Value with key 2 inseted is: "+obj.get(2));
        System.out.println("Value fetched with key 1 is: "+obj.get(1));
        obj.put(3,3);
        System.out.println("Value with key 3 inseted is: "+obj.get(3));
        System.out.println("Value fetched with key 2 is: "+obj.get(2));
        obj.put(4,4);
        System.out.println("Value with key 4 inseted is: "+obj.get(4));
        System.out.println("Value fetched with key 1 is: "+obj.get(1));
        System.out.println("Value fetched with key 3 is: "+obj.get(3));
        System.out.println("Value fetched with key 4 is: "+obj.get(4));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
