package dto;

public class DLL {

    Node front;
    Node back;

    public DLL(Node front, Node back) {
        this.front = front;
        this.back = back;
        front.setNext(back);
        back.setPrev(front);
    }

    public Node getFront() {
        return front;
    }

    public Node getBack() {
        return back;
    }
}
