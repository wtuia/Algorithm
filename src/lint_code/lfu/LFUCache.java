package lint_code.lfu;

import java.util.HashMap;
import java.util.Map;

/** todo 数据量过大时，数据不准确
 * 对于容量为k的缓存，如果缓存已满，并且需要逐出其中的密钥，则最少使用的密钥将被踢出。
 *
 */
class LFUCache {

   // 缓存长度
    private static Map<Integer, Integer> modCount;
    private static Map<Integer, Integer> caches;
    private static int maxSize;
    /*
     * @param capacity: An integer
     */public LFUCache(int capacity) {
        caches = new HashMap<>(capacity);
        modCount = new HashMap<>(capacity);
        maxSize = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public static void set(int key, int value) {
        if (caches.containsKey(key)) {
            caches.put(key, value);
            modCount.remove(key);
            modCount.put(key, 1);
            return;
        }
        if (caches.size() == maxSize) {
            Integer leastKey = removeLeast();
            caches.remove(leastKey);
            modCount.remove(leastKey);
            caches.put(key, value);
            modCount.put(key, 1);
        } else  {
            caches.put(key, value);
            modCount.put(key ,1);

        }
    }

    public static Integer removeLeast() {
        int least = Integer.MAX_VALUE;
        Integer removeKey = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : modCount.entrySet()) {
            if (entry.getValue() < least) {
                least = entry.getValue();
                removeKey = entry.getKey();
            }
        }
        return removeKey;
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    public static int get(int key) {
        int result;
        Integer integerKey = key;
        try {
             result = caches.get(integerKey);
             modCount.put(key, modCount.get(key) + 1);
        }catch (Exception e) {
            result = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        new LFUCache(3);
        int result;
        set(1, 1);
        set(2, 2);
        set(3, 3);
        get(1);
        set(1,10);
        result = get(1);
        System.out.println(result);
        set(4, 40);
        result = get(4);
        System.out.println(result);
        result = get(3);
        System.out.println(result);
        result = get(2);
        System.out.println(result);
        result = get(1);
        System.out.println(result);
        set(5, 50);
        get(1);
        get(2);
        get(3);
        get(4);
        get(5);
    }

}
