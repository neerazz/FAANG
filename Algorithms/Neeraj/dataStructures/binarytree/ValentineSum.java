/*
Cupid wants to strike maximum houses in Geek Land on Valentine's Day. The houses in Geek Land are arranged in the form of a binary tree. Cupid is standing at target node initially. 
Find the sum of all nodes within a maximum distance k from target node. The target node should be included in the sum.
Example:
INPUT: String: 1 2 3 N N 4 6 N 5 N N 7 N
       target=9 K=1
OUTPUT:22
*/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class ValentineSum {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
                
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
                
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        Node root = buildTree(line);
            
        line = br.readLine().trim();
        String target_k[] = line.split(" ");
        int target = Integer.parseInt(target_k[0]);
        int k = Integer.parseInt(target_k[1]);
            
        Solution x = new Solution();
        System.out.println( x.sum_at_distK(root, target, k) );
    }
}

class Solution{
      static int sum;
    static void add_subtree(Node n, int dist)
	{
        if ( (n==null) || (dist<0) ) return;
        sum += n.data;
        add_subtree(n.left, dist-1);
        add_subtree(n.right, dist-1);
    }
    
    static int traverse(Node n, int target, int k)
	{
        if (n==null) return -1;
        if (n.data==target)
        {
            add_subtree(n, k);
            return k-1;
        }
        
        int dist = traverse(n.left, target, k);
        if (-1 < dist)
        {
            sum += n.data;
            add_subtree(n.right, dist-1);
            return dist-1;
        }
        
        dist = traverse(n.right, target, k);
        if (-1 < dist)
        {
            sum += n.data;
            add_subtree(n.left, dist-1);
            return dist-1;
        }
        return -1;
	}
    static int sum_at_distK(Node root, int target, int k)
	{
        sum = 0;
        traverse(root, target, k);
        return sum;
    }
    
}