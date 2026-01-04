package com.s2u2m.it_study.leetcode75.tree_graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=leetcode-75
public class MinReorderSolution {
    public int minReorder(int n, int[][] connections) {
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i);
        }
        for (int[] connection : connections) {
            int source = connection[0];
            int target = connection[1];
            cities[source].edges.add(new Edge(target, true));
            cities[target].edges.add(new Edge(source, false));
        }

        return dfs(0, -1, cities);
    }

    private int dfs(int target, int parent, City[] cities) {
        int count = 0;

        City city = cities[target];
        for (Edge edge : city.edges) {
            if (edge.targetCity == parent) {
                continue;
            }

            count += edge.isTo ? 1 : 0;
            count += dfs(edge.targetCity, target, cities);
        }

        return count;
    }

    private static class City {
        int code;
        private List<Edge> edges = new ArrayList<>();

        public City(int code) {
            this.code = code;
        }
    }

    private static record Edge(int targetCity, boolean isTo) {}
}
