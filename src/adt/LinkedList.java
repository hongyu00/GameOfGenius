package adt;

/**
 *
 * @author Tan Siaw Ching
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    private Node head;
    private int length;

    @Override
    public void insert(T newItem) {

        Node node = new Node(newItem);

        if (head == null) {

            head = node;
        } else {
            Node n = head;
            while (n.next != null) {

                n = n.next;
            }
            n.next = node;
        }
        length++;

    }

    @Override
    public void removeAt(int index) {
        T result = null;
        if ((index >= 1) && (index <= length)) {
            if (index == 1) {
                result = head.newItem;
                head = head.next;
            } else {
                Node nodeBefore = head;
                for (int i = 1; i < index - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.newItem;
                nodeBefore.next = nodeBefore.next.next;
            }
            length--;
        }
    }

    @Override
    public T getEntry(int givenPosition) {

        if ((givenPosition <= 0) && (givenPosition >= length)) {
            throw new IllegalArgumentException("Item not exist");
        }
        Node currentNode = head;
        for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;
        }
        T result = currentNode.newItem;
        return result;
    }

    @Override
    public int getLength() {
        return length;
    }

    private class Node {

        private T newItem;
        private Node next;

        private Node(T newItem) {
            this.newItem = newItem;
            this.next = null;
        }

        private Node(T newItem, Node next) {
            this.newItem = newItem;
            this.next = next;
        }
    }

}
