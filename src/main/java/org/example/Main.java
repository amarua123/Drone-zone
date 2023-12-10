package org.example;
import java.util.*;
//Assumption:
//    Each drone can move to 8 directions and if a drone find the target the searching stops
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("The Grid will be X * Y");
        System.out.print("Enter the no. of Rows: ");
        int x = in.nextInt();
        System.out.print("Enter the no. of Columns: ");
        int y = in.nextInt();
        int[][] grid = new int[x][y];

        List<Location> drones = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            System.out.println("Enter the X, Y value of Drone " + (i+1));
            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();
            drones.add(new Location(x, y, "drone" + (i+1)));
            grid[x][y] = 1;
        }
        System.out.println("Enter the X, Y value of the target: ");
        System.out.print("X: ");
        x = in.nextInt();
        System.out.print("Y: ");
        y = in.nextInt();
        Location target = new Location(x, y, "target");
        List<String> path =
                Location.getPath(Location.bfs(grid, drones, target));
        System.out.println("The path from nearest drone to target is given below: ");
        for(String loc: path){
            System.out.print(loc+" -> ");
        }
        System.out.print("Target Reached !!");
    }
}