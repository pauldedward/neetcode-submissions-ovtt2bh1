class Solution {
    public class DSU {
        private int[] parent;
        private int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            // Path compression
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if(px == py) {
                return false;
            }
            if(size[px] >= size[py]) {
                parent[py] = px;
                size[px] += size[py];
            } else {
                parent[px] = py;
                size[py] += size[px];
            }

            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length); // sinse edges == nodes;

        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }

        return new int[0];
    }
}
