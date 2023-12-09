package org.example;
import java.util.*;
//Assumption:
//    Each drone can move to 8 directions and if a drone find the target the searching stops
public class Main {

    public static void main(String[] args) {
        Location drone1 = new Location(4, 1, "drone1");
        Location drone2 = new Location(5, 7, "drone2");
        Location drone3 = new Location(2, 1, "drone3");
        Location drone4 = new Location(7, 1, "drone4");

        Location target = new Location(20, 14, "target");
        List<String> path =
                Location.getPath(Location.bfs(new ArrayList<>(Arrays.asList(drone1, drone2, drone3, drone4)), target));
        System.out.println("The path from nearest drone to target is given below: ");
        for(String loc: path){
            System.out.print(loc+" ");
        }
    }
}