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

        //    Number of connected components in this graph.
        int numberOfComponents;

        //    parent[i] will have the parent of node i (In case of single component parent[i] = i).
        //    size[i], has the size of component to which i belongs to.
        int[] parent, size;

        public UnionFindWithPathCompressionAndComponentsAndSize(int count) {
            this.numberOfComponents = count;
            parent = new int[count];
            size = new int[count];
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
//            If both the nodes has same parent or are in the same group.
            if (pa == pb) return false;
            // Merge smaller component/set into the larger one.
            if (size[a] < size[b]) {
                size[b] += size[a];
                parent[a] = b;
            } else {
                size[a] += size[b];
                parent[b] = a;
            }
            // Since the roots found are different we know that the
            // number of components/sets has decreased by one
            numberOfComponents--;
            return true;
        }

        private int find(int node) {
            int currentParent = node;
            while (parent[currentParent] != currentParent) {
//            Loop till you reach the node which is pointed to self.
                currentParent = parent[currentParent];
            }
//             Compress the path leading back to the currentParent. So that next time when the parent is you don't have to traverse back to the top node.
//              Doing this operation is called "path compression" and is what gives us amortized time complexity.
            while (node != currentParent) {
//                Take the parent of teh current node, and set the parent to the new parent value.
                int next = parent[node];
                parent[node] = currentParent;
//                And traverse one level up, so that the parent of current node also can be replaced.
                node = next;
            }
            return currentParent;
        }
    }
}
