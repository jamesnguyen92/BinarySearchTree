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
public class BinarySearchTree {
    private Node root;
    private int size;
    
    public BinarySearchTree(){
        root = null;
        size = 0;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(String w){
        //if tree is empty, put object at root
        if(isEmpty()){
            root = new Node(w);
            System.out.println("First node added to the tree: "+ w);
        }else{
            Node s = search(root, w);
            if( s != null){ //if there's a matching node
                s.increaseFrequency();
                System.out.println("Node frequency increased: " + w);
            }else{ //if no match found
                insert(root, w);
                size++;
            }
        }
        
        
    }
    
    public void insert(Node subRoot, String w){
        
            //determine wether it goes left or right
            if(w.compareTo(subRoot.getWords()) <= -1){ //left
                
                //is there a left child already  
                if(subRoot.getLeftChild() == null){ 
                //set p as the root's left child
                subRoot.setLeftChild(new Node(w));
                }else{
                    //recursively call add on the left child
                    insert(subRoot.getLeftChild(),w);
                }
            }else{ //right
                //is there a child already
                if(subRoot.getRightChild() == null){
                    //set p as the root's left child
                    subRoot.setRightChild(new Node(w));
                }else{
                    //recursively call add on the right child
                    insert(subRoot.getRightChild(),w);
                }
            }
    }
    public Node search(String w){
        Node found = search(root, w);
        //did we find a match?
        if(found == null){
            //HORRAY!!
            System.out.println(w +" is not found");
        }else{
            System.out.println(w + " found, "+ found.toString());
        }
        return found;
    }
    
    Node search (Node subRoot, String w){
        Node compare = null;
        // comparing node if they're equal
        if(w.compareTo(subRoot.getWords()) == 0){
            return subRoot;
        }else if(w.compareTo(subRoot.getWords()) <= -1){ //if left node is less than subroot
            if(subRoot.getLeftChild() == null){
                return null;
            }else{
                return search(subRoot.getLeftChild(),w);
            }
        }else{ //if right node is greater than subroot
            if(subRoot.getRightChild() == null){
                return null;
            }else{
                return search(subRoot.getRightChild(),w);
            }    
        }
    }
    
    public void printPreOrder(){
        System.out.println("Running preOrder traversal");
        printPreOrder(root);
        System.out.println(" -- - - - - - - - -- - - - - -");
    }
   void printPreOrder(Node subroot){
       if(subroot == null)
           return;
       
       //print subroot
       System.out.println(subroot.getWords());
        //left subtree
       printPreOrder(subroot.getLeftChild());
       //right subtree
       printPreOrder(subroot.getRightChild());
       
   } 
   
   //print in ascending order
   public void printInOrder(){
        System.out.println("Running inOrder traversal");
        printInOrder(root);
        System.out.println(" -- - - - - - - - -- - - - - -");
    }
   void printInOrder(Node subroot){
       if(subroot == null)
           return;              
       //left subtree
       printInOrder(subroot.getLeftChild());
       //print subroot
       System.out.println(subroot.getWords());
       //right subtree
       printInOrder(subroot.getRightChild());
       
   } 
   
   //print in descending order
   public void printPostOrder(){
       System.out.println("Running postOrder traversal");
       printPostOrder(root);
       System.out.println(" -- - - - - - - - -- - - - - -");
   }
   
   void printPostOrder(Node subroot){
       if(subroot == null)
           return;              
       //left subtree
       printInOrder(subroot.getLeftChild());
       //right subtree
       printInOrder(subroot.getRightChild());
       //print subroot
       System.out.println(subroot.getWords());
       
   } 
}
