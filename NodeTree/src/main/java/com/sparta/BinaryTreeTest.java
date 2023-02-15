package com.sparta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BinaryTreeTest {

    @Test
    @DisplayName("When given an element in the tree, find element returns true")
    public void whenGivenAnElementInTheTree_FindElement_ReturnsTrue(){
        BinaryTree binaryTree = new BinaryTree();
        int[] elements = {1,2,3,4,5};
        binaryTree.addElements(elements);
        Assertions.assertTrue(binaryTree.findElement(3));
    }

    @Test
    @DisplayName("When given an element not in the tree, find element returns true")
    public void whenGivenAnElementNotInTheTree_FindElement_ReturnsTrue(){
        BinaryTree binaryTree = new BinaryTree();
        int[] elements = {1,2,3,4,5};
        binaryTree.addElements(elements);
        Assertions.assertFalse(binaryTree.findElement(6));
    }
}