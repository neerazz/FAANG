/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.
Example:
INPUT: N = 5
       arr[] = 40 30 35 80 100
OUTPUT: 35 30 100 80 40
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class PreOrderToPostOrder {

	static class Node {
		int data;
		Node left, right;
		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] inputline = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputline[0]);
        inputline = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputline[i]);
        }  
        Node res = constructTree(arr, n);
        printPostorder(res);
        System.out.println();
    }
    
public static Node constructTreeUtil(int[] pre,int start,int end)
{
    if(start>end)
    return null;
    Node root=new Node(pre[start]);
    int i;
    for(i=start+1;i<=end;i++)
    {
        if(pre[i]>root.data)
        break;
    }
    root.left=constructTreeUtil(pre,start+1,i-1);
    root.right=constructTreeUtil(pre,i,end);
    return root;
}

public static Node constructTree(int pre[], int size) {
    return constructTreeUtil(pre,0,size-1);
} 


public static void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 
} 