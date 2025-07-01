package org.library.CustomHashMap;

public class Main {
    public static void main(String[] args){
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apoorv", 99);
        map.put("harshita", 100);
        map.put("random", 500);
        map.put("random1", 654);
        map.put("random2", 654);
        map.put("random3", 654);
        map.put("random4", 654);
        map.put("random5", 654);
        map.put("random6", 654);
        map.put("random7", 654);

//        map.remove("random2");
//        map.remove("random3");
//        map.remove("random4");
//        map.remove("random5");

        System.out.println(map);
    }
}
