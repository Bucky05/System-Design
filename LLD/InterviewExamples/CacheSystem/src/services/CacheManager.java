package services;

import dto.Node;
import enums.PolicyType;
import evictionPolicies.EvictionPolicy;
import factories.PolicyFactory;

public class CacheManager {

    EvictionPolicy policy;

    public CacheManager(String policyType,int capacity) {
        policy = PolicyFactory.createPolicy(policyType,capacity);
    }

    public char get(int key) {

       return policy.get(key);

    }

    public void put(int key, char val) {
        policy.put(key,val);
    }

    public void changePolicyTo(String newPolicyType) {
        if(PolicyType.valueOf(newPolicyType) == policy.getPolicyType()) return;
        EvictionPolicy newPolicy = PolicyFactory.createPolicy(newPolicyType,policy.getCapacity());

        while(policy.getSize() > 0) {
            Node node = policy.remove();
            newPolicy.put(node.getKey(), node.getVal());

        }

        policy = newPolicy;

    }

}
