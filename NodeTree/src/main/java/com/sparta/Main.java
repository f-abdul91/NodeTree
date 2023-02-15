package com.sparta;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        BinaryTree tree = new BinaryTree();
        int[] elements = {4, 83, 2, 14, 32, 21, 90, 1001, 30, 6};
        tree.addElements(elements);
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));
        System.out.println(Arrays.toString(tree.getSortedTreeDesc()));
        System.out.println(tree.findElement(14));
        System.out.println(tree.getRightChild(14));
    }
}