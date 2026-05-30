import java.util.*;

public class sum{

    public static void sum(int n, int m){
        int c = n + m;
        System.out.println(c);
        return;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        sum(n, m);
    }
}