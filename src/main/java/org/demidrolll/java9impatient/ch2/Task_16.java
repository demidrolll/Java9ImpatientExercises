package org.demidrolll.java9impatient.ch2;

import sun.swing.DefaultLayoutStyle;

public class Task_16 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        for (Queue.Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        queue.remove();
        for (Queue.Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        queue.remove();
        for (Queue.Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        queue.add("6");
        queue.add("7");
        queue.remove();
        for (Queue.Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}

class Queue {

    private Node head;
    private Node tail;

    private static class Node {
        private String value;
        private Node next;
        private Node prev;
    }

    public class Iterator {

        private Node currentNode = Queue.this.head;

        Iterator(Node head) {
            //currentNode = head;
        }

        public String next() {
            if (currentNode != null) {
                String value = currentNode.value;
                currentNode = currentNode.prev;
                return value;
            }
            return null;
        }

        public boolean hasNext() {
            return (currentNode != null);
        }
    }

    public void add(String value) {
        Node node = new Node();
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = tail;
            tail.prev = node;
            tail = node;
        }
        tail.value = value;
    }

    public String remove() {
        if (head != null) {
            Node node = head;
            head = head.prev;
            if (head == null) {
                tail = null;
            } else {
                head.next = null;
            }
            return node.value;
        } else {
            return null;
        }
    }

    public Iterator iterator() {
        return new Iterator(head);
    }
}
