package lessons.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(7);
        queue.add(3);
//        queue.add(null);

//        LinkedList

        System.out.println(queue);
    }
}
