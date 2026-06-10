import java.util.*;

public class hashingall {
    public static void main(String[] args) {
        
        // Country <String> , Populatauion <values>

        HashMap <String , Integer> map = new HashMap<>();

        // INSERTION ---------
        map.put("India", 120);
        map.put("China", 150);
        map.put("US", 30);
        map.put("US", 60);
        
        System.out.println(map);

        if(map.containsKey("India")){
            System.out.println(" It contains.");
        }

        System.out.println(map.get("China")); // key exist
        System.out.println(map.get("Pakistan")); // key doesn't exist


        // NEW TYPE OF WRITING FOR LOOP ------
        int arr[] = {12,54,98};
        for(int val : arr){
            System.out.print(val + " ");
        }

        for(Map.Entry<String, Integer> e :map.entrySet()){
            System.out.print(e.getKey() + " ");
            System.out.println(e.getValue());
        }


        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        }


        map.remove("US");
        System.out.println(map);


        // HASHMAP INTERNALLY ARRAY OF MY LINKED LIST KE FORM ME SAVE HOTA HAI 
    }
}
