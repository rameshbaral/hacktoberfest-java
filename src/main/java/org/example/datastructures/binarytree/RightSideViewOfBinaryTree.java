package org.example.datastructures.binarytree;

import java.util.*;

public class RightSideViewOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Binarytree{
        static int idx =-1;
        public Node buildtree(int nodes[]) {
            idx++;
            if (nodes[idx]==-1) {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left= buildtree(nodes);
            newnode.right =buildtree(nodes);
            return newnode;
        }

    }
    
        // right side view of binary tree
        public static void rightSide(Node root, List<Integer> li ,int level){
       
            if(root==null){
                 return ;         
             }
            
             if(li.size()==level){
                 li.add(root.data); 
             }
             rightSide(root.right,li,level+1);
             rightSide(root.left,li,level+1);
        } 
         
         
         public static List<Integer> rightSideView(Node root) {
              List<Integer> li = new ArrayList<Integer>();
             rightSide(root,li,0);
          return li;
         }
    
        
    public static void main(String[] args) {
        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree t = new Binarytree();
        Node root = t.buildtree(nodes);
        System.out.println( rightSideView(root) );
      
    }
}
