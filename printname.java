import java.util.*;
// import java.util.Scanner;

public class printname{
public static void printMyName(String Name){
    System.out.println(Name);
    return;
}
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter : ");
        String Name = sc.next();
        printMyName(Name);
    }
}
