import services.CacheManager;

import javax.sound.midi.Soundbank;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager("LRU",3);
        cacheManager.put(1,'A');
        cacheManager.put(2,'B');
        System.out.println("----------"+cacheManager.get(2));
        cacheManager.put(3,'D');
        cacheManager.put(4,'E');
        try {
            System.out.println(cacheManager.get(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("----------"+cacheManager.get(2));

        cacheManager.changePolicyTo("LFU");

        System.out.println("---"+cacheManager.get(2));
        System.out.println("----"+cacheManager.get(2));
        System.out.println(cacheManager.get(3));
        cacheManager.put(5,'U');

        try {
            cacheManager.get(4);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}