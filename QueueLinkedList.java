import java.util.*;

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); // Use this for Linked List 
                                                                        // add
        Queue<Integer> q = new ArrayDeque<>(); // Use this for double ended queue 
        
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(q.isEmpty()){
          System.out.println(q.peek());
          q.remove();
    }
}
