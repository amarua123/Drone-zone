package org.example;

import java.util.*;

public class Location implements Comparable<Location> {
    int x, y;
    Location next = null;
    String name = "";
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
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
        if(name != ""){
            name = "("+name+")";
        }
        return "[" + x + ", " + y + "]" + name;
    }
    public static Location bfs(List<Location> sources, Location target){
        Queue<Location> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        for(Location loc: sources){
            queue.add(loc);
        }
        int dirs[][] = new int[][]{{1, 0}, {0, 1},{-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        while(target.compareTo(queue.peek()) != 0){
            Location source = queue.poll();
            for(int[] dir: dirs){
                Location neighbor = new Location(source.x+dir[0], source.y+dir[1], source);
                String key = ""+neighbor.x+neighbor.y;
                if(!seen.contains(key)){
                    seen.add(key);
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
