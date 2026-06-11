import java.util.HashMap;
import java.util.*;

public class Unionof2ArraybyHashMap {

    public static  int UnionArray(int n [], int m []){

        HashSet<Integer> map = new HashSet<>();
        int l = n.length;
        int o = m.length;

        for(int i = 0; i < l; i++){
                map.add(n[i]);
        }
        for(int i = 0; i < o; i++){
                map.add(m[i]);
        }


        return map.size();

    }
    public static void main(String[] args) {
        int n [] = {7,3,9};
        int m [] = {6,3,9,2,9,4};
        System.out.println(UnionArray(n , m));
    }
}
