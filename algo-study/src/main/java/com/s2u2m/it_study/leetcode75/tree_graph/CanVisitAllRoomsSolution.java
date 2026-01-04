package com.s2u2m.it_study.leetcode75.tree_graph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// https://leetcode.cn/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
public class CanVisitAllRoomsSolution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int index, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[index]) {
            return;
        }

        visited[index] = true;
        List<Integer> keys = rooms.get(index);
        for (int key : keys) {
            dfs(key, rooms, visited);
        }
    }
}
