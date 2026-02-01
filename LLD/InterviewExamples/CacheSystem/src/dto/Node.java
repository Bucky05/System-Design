package dto;

public interface  Node {



    public Node getPrev() ;

    public Node getNext();

    public int getKey();

    public char getVal();

    public void setPrev(Node prev);
    public void setNext(Node next) ;

    public void setVal(char val);
}
