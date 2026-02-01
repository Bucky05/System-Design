package dto;

public class NodeLFU implements Node{

    Node prev;
    Node next;
    final int key;
    char val;
    int freq;

    public NodeLFU( int key, char val) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
        this.freq = 1;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getKey() {
        return key;
    }

    public char getVal() {
        return val;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public void setVal(char val) {
        this.val = val;
    }


    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
}
