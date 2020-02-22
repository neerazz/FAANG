import java.io.*;
import java.util.*;

class Solution1 {

  static class Node {

    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }

    Node (int cost, int numberOfChild, Node parent){

      this.cost = cost;
      if (numberOfChild == 0)
        this.children = null;
      else
        this.children = new Node[numberOfChild];
      this.parent = parent;
    }
  }

  static class SalesPath {
    static int output = Integer.MAX_VALUE;
    static int getCheapestCost(Node rootNode) {

      getCheapestCost_Helper(rootNode,0);
      output = output == Integer.MAX_VALUE ? -1 : output;

      //System.out.println("result = " + output);
      return output;
    }

    static void getCheapestCost_Helper(Node rootNode, int sum) {
      System.out.println("sum = " + sum);
      if(rootNode == null){
        output = Math.min(sum,output);
        return;
      }
      if(rootNode.children != null ){
        for(int i= 0 ; i<rootNode.children.length; i++){
          Node node = rootNode.children[i];
          getCheapestCost_Helper(node, sum + rootNode.cost);
        }
      }else{
        output = Math.min(sum + rootNode.cost,output);
      }
      return;
    }
  }

  /*********************************************
   * Driver program to test above method     *
   *********************************************/

  public static void main(String[] args) {

    Node root = new Node(0,3,null);
    root.children[0] = new Node(5,1,root);
    root.children[1] = new Node(3,2,root);
    root.children[2] = new Node(6,0,root);

    root.children[0].children[0] = new Node(4,0,root.children[0]);

    //Node root3 = root.children[1];

    root.children[1].children[0] = new Node(2,1,root.children[1]);
    root.children[1].children[1] = new Node(0,1,root.children[1]);

    //Node root2 = root3.children[0];
    root.children[1].children[0].children[0] = new Node(1,1,root.children[1].children[0]);
    root.children[1].children[0].children[0].children[0] = new Node(1,0,root.children[1].children[0].children[0]);

    //Node root0 = root3.children[1];
    root.children[1].children[1].children[0] = new Node(10,0,root.children[1].children[1]);

    //Node root6 = root.children[2];

    //root.children[2].children[0] = new Node(1,0,root.children[2]);
    //root.children[2].children[1] = new Node(5,0,root.children[2]);

    SalesPath salesPath= new SalesPath();

    //getCheapestCost(root);
    System.out.println("min sales path = " + salesPath.getCheapestCost(root) + " should be [6]");


  }
}
