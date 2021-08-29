/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen_minhquan_assignment3_binarysearchtree;

/**
 *
 * @author james
 */
public class Node {
    private int frequency ;
    private Node leftChild, rightChild;
    private String words;
    
    public Node(String w){
        frequency = 1;
        leftChild = rightChild = null;
        words = w;
    }

    public String getWords() {
        return words;
    }
    public Node getLeftChild(){
        return leftChild;
    }
    public Node getRightChild(){
        return rightChild;
    }
    public void setLeftChild(Node p) {
        leftChild = p;
    }

    public void setRightChild(Node p) {
        rightChild = p;
    }
    
    public int getFrequency() {
        return frequency;
    }
    
    public void increaseFrequency(){
        frequency++;
    }
    
    @Override
    public String toString(){
        return words + " frequency is: " + frequency;
    }
}
