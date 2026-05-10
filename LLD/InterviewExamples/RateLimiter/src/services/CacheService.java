package services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CacheService {

    Map<String, List<Long>> requestCount ;

    public CacheService() {
        requestCount = new HashMap<>();
    }

    public void set(String id) {
        if(!requestCount.containsKey(id)) {
            requestCount.put(id, new ArrayList<Long>());
        }
        requestCount.get(id).add(System.currentTimeMillis());
    }

    public int getCount(String id) {
        List<Long> list = requestCount.getOrDefault(id,new ArrayList<Long>()) ;
        List<Long> clone = new ArrayList<>(list);
        Long curr = System.currentTimeMillis();
        for(Long time : clone) {
            if(curr - time > 30000) {
                list.remove(time);
            }
        }

        return list.size();
    }
}
