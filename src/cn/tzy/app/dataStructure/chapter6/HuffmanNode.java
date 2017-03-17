package cn.tzy.app.dataStructure.chapter6;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Created by tuzhenyu on 17-3-17.
 * @author tuzhenyu
 */
@Setter
@Getter
public class HuffmanNode implements Comparable<HuffmanNode>{
    public int frequence;
    public HuffmanNode parent;
    public int code;

    public HuffmanNode(){}

    public HuffmanNode(int frequence){
        this.frequence = frequence;
    }

    public static HuffmanNode merge(HuffmanNode left,HuffmanNode right){
        HuffmanNode parentNode = new HuffmanNode(left.getFrequence()+right.getFrequence());
        left.setCode(0);
        left.setParent(parentNode);
        right.setCode(1);
        right.setParent(parentNode);

        return parentNode;
    }

    @Override
    public int compareTo(HuffmanNode hn) {
        if (frequence > hn.getFrequence()){
            return 1;
        } else {
            return -1;
        }
    }

}
