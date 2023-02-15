package com.sparta;

import com.sparta.exceptions.ChildNotFoundException;
import com.sparta.logging.ConsoleHandlerConfig;
import com.sparta.logging.FileHandlerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree implements IBinaryTree {
    public static final Logger logger= Logger.getLogger(BinaryTree.class.getName());
    public static void initializeLogger(){
        FileHandlerConfig.getFileHandler(logger);
    }


    // Node node = new Node(6);
    static Node rootNode;

    static Node tempNode = rootNode;
    ArrayList<Node> treeArray = new ArrayList<>();

    @Override
    public int getRootElement() {

        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return treeArray.size();
    }

    @Override
    public void addElement(int element) {
        // Check if root exists, if not create one
        // If root does exist, carry on

        if(rootNode == null){
            BinaryTree.initializeLogger();
            rootNode = new Node(element);
            tempNode = rootNode;
            treeArray.add(rootNode);
            logger.log(Level.INFO, "A tree has been created");
        }

        Node currentNode = tempNode;
        int currentNodeValue = currentNode.getValue();
        if (element > currentNodeValue) {

            if (currentNode.isRightChildEmpty()) {
                Node rightNode = new Node(element);
                currentNode.setRightChild(rightNode);
                treeArray.add(currentNode.getRightChild());
            } else {
                tempNode = currentNode.getRightChild();
                addElement(element);
            }
        }
        if (element < currentNodeValue) {
            if (currentNode.isLeftChildEmpty()) {
                Node leftNode = new Node(element);
                currentNode.setLeftChild(leftNode);
                treeArray.add(currentNode.getLeftChild());
            } else {
                tempNode = currentNode.getLeftChild();
                addElement(element);
            }
        }
        if (element == currentNodeValue) {
            System.out.println("No doubles");
        }
        tempNode = currentNode;
    }



    @Override
    public void addElements(int[] elements) {

        for(int i : elements) {
            addElement(i);
        }
    }

    @Override
    public boolean findElement(int value) {
        int[] treeArrayValues = getSortedTreeAsc();

        for(int i = 0; i < treeArrayValues.length -1; i++){
            if (treeArrayValues[i] == value ){
                return true;
            }
        }

        return false;
    }

    @Override
    public int getLeftChild(int element) {
        Node current = tempNode;

        if(findElement(element)) {

            if(element == current.getValue()){
                if(!(current.isLeftChildEmpty())){
                    return current.getLeftChild().getValue();
                }
            }
            if(element < current.getValue()){
                if(!(current.isLeftChildEmpty())){
                    tempNode = current.getLeftChild();
                    return getLeftChild(element);
                }
            }
            if(element > current.getValue()){
                if(!(current.isRightChildEmpty())){
                    tempNode = current.getRightChild();
                    return getLeftChild(element);
                }
            }
        }
        return 0;
    }

    @Override
    public int getRightChild(int element)  {

        Node current = tempNode;

        if (findElement(element)) {

            if (element == current.getValue()) {
                if (!(current.isRightChildEmpty())) {
                    return current.getRightChild().getValue();
                }
            }
            if (element < current.getValue()) {
                if (!(current.isLeftChildEmpty())) {
                    tempNode = current.getLeftChild();
                    return getRightChild(element);
                }
            }
            if (element > current.getValue()) {
                if (!(current.isRightChildEmpty())) {
                    tempNode = current.getRightChild();
                    return getRightChild(element);
                }
            }
        }

        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedTreeAsc = new int[treeArray.size()];

        for(int i = 0; i < sortedTreeAsc.length; i++){
            sortedTreeAsc[i] = treeArray.get(i).getValue();
        }

        Arrays.sort(sortedTreeAsc);
        return sortedTreeAsc;
    }

    @Override
    public int[] getSortedTreeDesc() {
        Integer[] sortedTreeDesc = new Integer[treeArray.size()];

        for(int i = 0; i < sortedTreeDesc.length; i++){
            sortedTreeDesc[i] = treeArray.get(i).getValue();
        }
        Arrays.sort(sortedTreeDesc);
        Arrays.sort(sortedTreeDesc, Collections.reverseOrder());

        return Arrays.stream(sortedTreeDesc).mapToInt(Integer::intValue).toArray();
    }
}
