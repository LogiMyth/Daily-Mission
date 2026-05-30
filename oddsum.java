import java.util.*;
// import java.util.Scanner;

public class oddsum{
public static void avg(int a){
    int i = 0;
    int b = 1;
    int sum = 0;
    while (i < a){
        if(b % 2 != 0){
            sum  = sum + b;
            b = b+2;
            i++;
        }
        else b= b + 2;
    }
    System.out.println(sum);
    return;
}
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter : ");
        int a = sc.nextInt();
        avg(a);
    }
}
