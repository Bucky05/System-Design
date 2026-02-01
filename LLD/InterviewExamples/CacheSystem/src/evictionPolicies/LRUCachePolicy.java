package evictionPolicies;

import dto.DLL;
import dto.Node;
import enums.PolicyType;
import factories.DLLFactoryImpl;
import factories.NodeFactoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LRUCachePolicy implements EvictionPolicy{

    DLL dll;
    HashMap<Integer, Node> keyMap;
    int capacity;
    int size;
    public LRUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        keyMap = new HashMap<>();
        dll = DLLFactoryImpl.createDLL(
            PolicyType.LRU
        );

    }


    @Override
    public char get(int key) {
        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            remove(node);
            add(node);
         return node.getVal();
        }
        throw new IllegalArgumentException("No such key exists please seek db");
    }

    @Override
    public void put(int key, char val) {
        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            remove(node);
            node.setVal(val);
            add(node);
        } else {
            Node node = NodeFactoryImpl.createNode(PolicyType.LRU,key,val);
            if(size < capacity) {
                add(node);

            } else {
                remove();
                add(node);
            }
            size++;
            keyMap.put(key,node);
        }
    }


    public Node remove() {

        Node node = dll.getFront().getNext();
        remove(node);
        size--;
        return node;
    }

    public void remove(Node node) {
        node.getPrev()
                .setNext(
                        node.getNext()
                );

        node.getNext().setPrev( node.getPrev() );
        node.setNext(null);
        node.setPrev(null);
    }

    private void add(Node node) {
        Node back = dll.getBack();
        back.getPrev().setNext(node);
        node.setPrev(back.getPrev());
        node.setNext(back);
        back.setPrev(node);


    }

    @Override
    public PolicyType getPolicyType() {
        return PolicyType.LRU;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
