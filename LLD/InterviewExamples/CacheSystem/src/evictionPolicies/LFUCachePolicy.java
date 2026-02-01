package evictionPolicies;

import dto.DLL;
import java.util.List;
import java.util.ArrayList;
import dto.Node;
import dto.NodeLFU;
import enums.PolicyType;
import factories.DLLFactoryImpl;
import factories.NodeFactoryImpl;

import java.util.HashMap;
public class LFUCachePolicy implements EvictionPolicy{

    List<DLL> freqList;
    HashMap<Integer,Node> keyMap;
    int capacity;
    int size;
    int leastFreq;

    public LFUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.leastFreq = 0;
        freqList = new ArrayList<>();
        keyMap = new HashMap<>();
    }
    @Override
    public char get(int key) {
        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            reOrder(node);
            return node.getVal();

        }
        throw new IllegalArgumentException("No such key exists please seek db");
    }

    @Override
    public void put(int key, char val) {
        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.setVal(val);
            reOrder(node);
        } else {
            if(size < capacity) {
                if(leastFreq == 0) {
                    DLL dll = DLLFactoryImpl.createDLL(PolicyType.LFU);
                    leastFreq = 1;
                    freqList.add(dll);

                }

                Node node = NodeFactoryImpl.createNode(PolicyType.LFU,key,val);
                insertAtFreqList(freqList.get(0),node);
            } else {
                remove();
                insertAtFreqList(freqList.get(0),NodeFactoryImpl.createNode(PolicyType.LFU,key,val));
            }
            size++;
            leastFreq = 1;

        }
    }

    public void reOrder(Node node) {

        node.getPrev().setNext(node.getNext());

        node.getNext().setPrev(node.getPrev());
        int freq =  ((NodeLFU) node).getFreq();
        DLL dll = freqList.get(freq-1);

        if(dll.getFront().getNext() == dll.getBack() && leastFreq == freq) {
            leastFreq++;
        }
        freq++;

        ((NodeLFU) node).setFreq(freq);
        if(freqList.size() < freq){
            DLL dll1 = DLLFactoryImpl.createDLL(PolicyType.LFU);
            freqList.add(dll1);

        }
        insertAtFreqList(freqList.get(freq-1),node);

    }
    public Node remove() {
        DLL dll = freqList.get(leastFreq-1);
        Node front = dll.getFront();
        Node node = dll.getFront().getNext();
        front.setNext(node.getNext());

        node.getNext().setPrev( front );
        node.setNext(null);
        node.setPrev(null);


        keyMap.remove(node.getKey());
        size--;
        return node;



    }
    private void insertAtFreqList(DLL dll, Node node) {
        add(dll,node);
        keyMap.put(node.getKey(),node);
    }

    private void add(DLL dll,Node node) {
        Node back = dll.getBack();
        back.getPrev().setNext(node);
        node.setPrev(back.getPrev());
        node.setNext(back);
        back.setPrev(node);

    }

    public PolicyType getPolicyType() {
        return PolicyType.LFU;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return this.capacity;
    }


}
