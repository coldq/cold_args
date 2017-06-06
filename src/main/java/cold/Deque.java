package cold;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by cold on 2017/5/31.
 * 双向链表实现左右都可以进出的队列
 */
public class Deque <Item> implements Iterable<Item>{

    private Node<Item> first,last;
    private int size = 0;

    private static class Node<Item> {
        private Item item ;
        private Node<Item> pre;
        private Node<Item> next;
    }

    public Deque(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public void pushLeft(Item item){
        Node oldfirst = first;

        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;


        if(isEmpty()){
            last = first;
        }else {
            oldfirst.pre = first;
        }
        size++;
    }

    public void pushRight(Item item){
        Node oldlast = last;

        last = new Node<Item>();
        last.item = item;
        last.pre = oldlast;

        if(isEmpty()) first = last;
        else  oldlast.next = last;

        size++;
    }


    public Item popLeft(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item item = first.item;
        first = first.next;

        size--;
        if(isEmpty()){
            last = null;
        }else {
            first.pre = null;
        }
        return item;
    }
    public Item popRight(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item item = last.item;
        last = last.pre;

        size--;
        if(isEmpty()){
            first = null;
        }else {
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(first);
    }

    private class DequeIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public DequeIterator(Node<Item> first){
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item i : this){
            s.append(i);
            s.append(" ");
        }
        return s.toString();
    }

    public static void main(String args[]){
        Deque<Integer> deque = new Deque<Integer>();
        deque.pushLeft(3);
        deque.pushLeft(2);
        deque.pushLeft(1);
        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushRight(6);

        StdOut.println(deque);

        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popRight();
        deque.popRight();

        StdOut.println(deque);
    }
}
