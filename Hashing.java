import java.util.HashSet;
import java.util.Iterator;
public class Hashing {
    public static void main(String[] args) {
        // Creating

        HashSet<Integer> set = new HashSet<>();
        // bilkul like ArrayList ki tarah-----------

        // insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // list.add(el)

        // Search - Contains

        if(set.contains(1)){
            System.out.println("It Contains.");
        }
        if(!set.contains(6)){
            System.out.println("It doesn't Contains.");
        }
        
        //Delete---
        
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("It doesn't Contains.");
        }


        // Size calculate ------ 
        System.out.println(set.size());


        // Print all elements ------ 
        System.out.println(set);


        // Iterator -----
        Iterator It = set.iterator();
        //hasnext; and next function hota hai isme 
        while (It.hasNext()) {
            System.out.println(It.next());            
        }
    }
}
