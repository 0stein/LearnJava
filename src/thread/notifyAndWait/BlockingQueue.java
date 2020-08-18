package thread.notifyAndWait;

import java.util.NoSuchElementException;

public class BlockingQueue {
    private int size;
    private Node head, tail;
    private final int capacity;

    public BlockingQueue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    private static class Node{
        private String value;
        private Node next;
    }

    public synchronized boolean isFull(){
        return size == capacity;
    }
    public synchronized boolean isEmpty(){
        return head == null;
    }

    public synchronized void enque(String item){
        try{
            while (isFull()){
                wait();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Node oldTail = tail;
        tail = new Node();
        tail.value = item;
        tail.next = null;
        if(isEmpty()){
            head = tail;
        }else{
            oldTail.next = tail;
        }
        size++;
        notifyAll();
    }

    public String deque(){
        try{
            while (isEmpty()){
                wait();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        String value = head.value;
        head = head.next;
        size--;
        if(isEmpty()){
            tail = null;
        }
        notifyAll();
        return value;
    }
}
