package factories;

import enums.PolicyType;
import evictionPolicies.EvictionPolicy;
import evictionPolicies.LFUCachePolicy;
import evictionPolicies.LRUCachePolicy;

public class PolicyFactory {

    public static EvictionPolicy createPolicy(String policy, int capacity) {
        PolicyType policyType = PolicyType.valueOf(policy);

        if(policyType == PolicyType.LFU) {
            return new LFUCachePolicy(capacity);
        } else if(policyType == PolicyType.LRU) {
            return new LRUCachePolicy(capacity);
        } else {
            throw new IllegalArgumentException("No such Policy exists");
        }

    }
}
