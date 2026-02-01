package dto;

public class NodeLRU implements Node{


    Node prev;
    Node next;
    final int key;
    char val;

    public NodeLRU( int key, char val) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
    }

    @Override
    public Node getPrev() {
        return prev;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public char getVal() {
        return val;
    }

    @Override
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public void setVal(char val) {
        this.val = val;
    }
}
