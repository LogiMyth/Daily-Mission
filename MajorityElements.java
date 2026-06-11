import java.util.*;
import java.util.HashMap;
public class MajorityElements {

    public static void majorityemements(int nums[]){
        HashMap <Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){       // yaha pe hm value ko uske frequency ke
            if(map.containsKey(nums[i])){ //true                  // hisab se baat ke hashmap ke andar daal rhe hai
                map.put(nums[i], map.get(nums[i]) + 1); // if check kr rha hai ki phle key exist to nhi rha hai
            }                                      // agr exist kr rha hai to freq update ya else me naya key bana dena
            else {
                map.put(nums[i], 1);
            }
        }

        for(int k : map.keySet()){
            if(map.get(k) > n/3){
                System.out.println(k);
            }
        }

    }
    public static void main(String[] args) {
        int nums[] = {1,2};
        majorityemements(nums);
    }
}
