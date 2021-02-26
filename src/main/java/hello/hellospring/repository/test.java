package hello.hellospring.repository;

import java.util.*;

public class test {
    public static void main(String args[]){
        Stack s = new Stack();
        s.add(5);
        s.add(7);
        s.add("hi");
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s.pop());
        Queue q = new LinkedList();
        q.add(5);
        q.add(7);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
