import java.util.*;
// import java.util.Scanner;

public class factorial{
public static void factorial(int a){
    int fact = 1;
    for(int i = a; i >= 1; i--){
        fact = fact * i;
    }
    System.out.println(fact);
    return;
}
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter : ");
        int a = sc.nextInt();
        factorial(a);
    }
}
