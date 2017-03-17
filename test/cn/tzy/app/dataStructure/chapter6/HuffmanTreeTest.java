package cn.tzy.app.dataStructure.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-3-17.
 * @author tuzhenyu
 */
public class HuffmanTreeTest {
    @Test
    public void test(){
        HuffmanNode h1 = new HuffmanNode(1);
        HuffmanNode h3 = new HuffmanNode(3);
        HuffmanNode h5 = new HuffmanNode(5);
        HuffmanNode h7 = new HuffmanNode(7);
        List<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
        nodes.add(h1);
        nodes.add(h3);
        nodes.add(h5);
        nodes.add(h7);

        HuffmanTree huffmanTree = new HuffmanTree(nodes);
    }
}