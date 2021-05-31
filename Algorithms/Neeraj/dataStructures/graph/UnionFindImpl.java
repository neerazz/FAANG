/**
 * Created on:  May 31, 2021
 * Questions: https://www.youtube.com/watch?v=KbFlZYCpONw&t=0s
 */

public class UnionFindImpl {

    public static void main(String[] args) {

    }

    static class UnionFind {

        //    parent[i] will have the parent of node i (In case of single component parent[i] = i).
        int[] parent;

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
//                If parent of both the nodes are same then, no need to union them. Both of them belongs to same component.
                return false;
            }
//            Move all the b node parents to a node parents.
            parent[pb] = pa;
            return true;
        }

        private int find(int node) {
            int par = parent[node] == node ? node : find(parent[node]);
            return parent[node] = par;
        }
    }

    static class UnionFindWithPathCompressionAndComponentsAndSize {

        //    Number of elements in this union.
        int count;
        //    Number of connected components in this graph.
        int numberOfComponents;

        //    parent[i] will have the parent of node i (In case of single component parent[i] = i).
        //    size[i], has the size of component to which i belongs to.
        int[] parent, size;

        public UnionFindWithPathCompressionAndComponentsAndSize(int count) {
            this.count = numberOfComponents = count;
            parent = new int[count];
            size = new int[count];
        }
    }
}
