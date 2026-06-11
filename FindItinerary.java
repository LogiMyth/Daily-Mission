import java.util.*;
public class FindItinerary {

    public static String Start(HashMap<String, String> ticket){
        HashMap<String, String> revmap = new HashMap<>();

        for(String key : ticket.keySet()){
            revmap.put(ticket.get(key), key);
        }
        
        // Find starting city (not in values)
        for(String key : ticket.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Benaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi" , "Goa");

        String start = Start(map);
        while(map.containsKey(start)){
            System.out.print(start + "->");
            start = map.get(start);
        }
        System.out.print(start);
    }
}
