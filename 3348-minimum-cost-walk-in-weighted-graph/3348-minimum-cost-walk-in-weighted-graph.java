import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Step 1: Build the adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        // Step 2: Find connected components and their minimum AND value
        int[] component = new int[n]; // Stores component ID for each node
        Arrays.fill(component, -1);
        Map<Integer, Integer> minAndValue = new HashMap<>();
        int compId = 0;

        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                int minAnd = computeMinAnd(graph, i, component, compId);
                minAndValue.put(compId++, minAnd);
            }
        }

        // Step 3: Answer queries
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0], end = query[i][1];
            if (component[start] != component[end]) {
                result[i] = -1; // Nodes are not connected
            } else {
                result[i] = minAndValue.get(component[start]);
            }
        }

        return result;
    }

    private int computeMinAnd(Map<Integer, List<int[]>> graph, int node, int[] component, int compId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        component[node] = compId;
        int minAnd = -1;

        Set<Integer> visited = new HashSet<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                int nextNode = neighbor[0], weight = neighbor[1];
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(nextNode);
                    component[nextNode] = compId;
                }
                minAnd = (minAnd == -1) ? weight : (minAnd & weight);
            }
        }
        
        return minAnd == -1 ? 0 : minAnd;
    }
}
