package LinkedList;

import Business.Business;

public class LinkedList {
    private int count;
    private Node head;

    public LinkedList() {
        this.count = 0;
        this.head = null;
    }

    public void push(Business objBusiness) {
        Node node = new Node(objBusiness);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        count++;
    }

    public Node getElementAt(int index) {
        if (index >= 0 && index < count) {
            Node node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return count;
    }

}