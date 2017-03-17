package cn.tzy.app.dataStructure.chapter6;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by tuzhenyu on 17-3-17.
 * @author tuzhenyu
 */
public class HuffmanTree {
    public HuffmanTree(Collection<? extends HuffmanNode> nodes){
        TreeSet<HuffmanNode> tree = new TreeSet<>(nodes);
        while (tree.size()>1){
            HuffmanNode left = tree.pollFirst();
            HuffmanNode right = tree.pollFirst();
            HuffmanNode parent = HuffmanNode.merge(left,right);
            tree.add(parent);
        }
    }
}
