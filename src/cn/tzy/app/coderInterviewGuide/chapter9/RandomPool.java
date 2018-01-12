package cn.tzy.app.coderInterviewGuide.chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-1-12.
 * @author tuzhenyu
 */
public class RandomPool<K> {
    private Map<Integer,K> indexKeyMap;
    private Map<K,Integer> keyIndexMap;
    private int size;

    public RandomPool(){
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }

    public void insert(K key){
        if (!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key,size++);
            indexKeyMap.put(size,key);
        }
    }

    public void delete(K key){
        if (keyIndexMap.containsKey(key)){
            int idx = keyIndexMap.get(key);
            K k = indexKeyMap.get(size);
            indexKeyMap.remove(size);
            indexKeyMap.put(idx,k);
            keyIndexMap.put(key,idx);
            keyIndexMap.remove(key);
            size--;
        }
    }

    public K getRandom(){
        if (size==0)
            return null;
        int randomIndex = (int)(Math.random()*size);
        return indexKeyMap.get(randomIndex);
    }
}
