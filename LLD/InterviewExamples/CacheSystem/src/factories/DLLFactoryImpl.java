package factories;

import dto.DLL;
import dto.Node;
import enums.PolicyType;

public class DLLFactoryImpl {

    public static DLL createDLL(PolicyType policyType) {

        Node front = NodeFactoryImpl.createNode(policyType,-1,'*');
        Node back = NodeFactoryImpl.createNode(policyType,-1,'*');
        return new DLL(front,back);

    }
}
