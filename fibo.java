import java.util.*;
// import java.util.Scanner;

public class fibo{
public static void fibo(int n){
    int a = 0;
    int b = 1;
    int sum = 0;
    int i = 0;
    while (i < n) {
        System.out.print(sum + " ");
        a = b;
        b = sum;
        sum = a + b;
        i++;
    }
    return;
}
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter : ");
        int n = sc.nextInt();
        fibo(n);
    }
}
