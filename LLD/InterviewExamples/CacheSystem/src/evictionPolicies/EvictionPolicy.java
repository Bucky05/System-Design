package evictionPolicies;

import dto.Node;
import enums.PolicyType;

public interface EvictionPolicy {

    char get(int key);
    void put(int key, char val);
    PolicyType getPolicyType();
    int getSize();
    int getCapacity();
    Node remove();
}
