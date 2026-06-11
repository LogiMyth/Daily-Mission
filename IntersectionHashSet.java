import java.util.HashMap;
import java.util.*;

public class IntersectionHashSet{

    public static  int Intersection(int n [], int m []){

        HashSet<Integer> map = new HashSet<>();
        int l = n.length;
        int o = m.length;
        int count = 0;

        for(int i = 0; i < l; i++){
                map.add(n[i]);
        }
        for(int i = 0; i < o; i++){
            if(map.contains(m[i])){
                map.add(m[i]);
                map.remove(m[i]);
                count++;
            }
        }


        return count;

    }
    public static void main(String[] args) {
        int n [] = {7,3,9};
        int m [] = {6,3,9,2,9,4};
        System.out.println(Intersection(n , m));
    }
}
