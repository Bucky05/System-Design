package factories;

import dto.Node;
import dto.NodeLFU;
import enums.PolicyType;
import dto.NodeLRU;
public class NodeFactoryImpl {


    public static Node createNode(PolicyType type , int key, char val) {
        if(type == PolicyType.LFU) {
            return new NodeLFU(key,val);
        } else if(type == PolicyType.LRU) {
            return new NodeLRU(key,val);
        } else {
            throw new IllegalArgumentException("No such policy exists");
        }
    }
}
