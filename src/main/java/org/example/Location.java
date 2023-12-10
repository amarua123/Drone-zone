package org.example;

import java.util.*;

public class Location implements Comparable<Location> {
    int x, y;
    Location next = null;
    String name = "";
    Location(int x, int y, Location next){
        this.x = x;
        this.y = y;
        this.next = next;
    }
    Location(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
    @Override
    public String toString() {
        if(name.isEmpty()){
            name = "("+name+")";
        }
        return "[" + x + ", " + y + "]" + name;
    }
    public static Location bfs(int [][]grid, List<Location> sources, Location target){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Location> queue = new LinkedList<>();
        for(Location loc: sources){
            queue.add(loc);
        }
        int dirs[][] = new int[][]{{1, 0}, {0, 1},{-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        while(target.compareTo(queue.peek()) != 0){
            Location source = queue.poll();
            for(int[] dir: dirs){
                int newX = source.x+dir[0];
                int newY = source.y+dir[1];
                if(newX < 0 || newY < 0) continue;
                if(newX >= row || newY >= col) continue;
                Location neighbor = new Location(newX, newY, source);
                if(grid[newX][newY] == 0){
                    grid[newX][newY] = 1;
                    queue.offer(neighbor);
                }
            }
        }
        return queue.peek();
    }
    public static List<String> getPath(Location source){
        List<String> revpath = new ArrayList<>();
        List<String> path = new ArrayList<>();
        while(source != null){
            revpath.add(source.toString());
            source = source.next;
        }
        while(!revpath.isEmpty()){
            path.add(revpath.remove(revpath.size()-1));
        }
        return path;
    }

    @Override
    public int compareTo(Location o) {
        if(x == o.x && y == o.y){
            return 0;
        }
        return 1;
    }
}
