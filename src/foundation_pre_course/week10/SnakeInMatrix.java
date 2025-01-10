package foundation_pre_course.week10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeInMatrix {
    /**
     * There is a snake in an n x n matrix grid and can move in four possible directions. Each cell in the grid is identified by the position: grid[i][j] = (i * n) + j.
     * <p>
     * The snake starts at cell 0 and follows a sequence of commands.
     * <p>
     * You are given an integer n representing the size of the grid and an array of strings commands where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT". It's guaranteed that the snake will remain within the grid boundaries throughout its movement.
     * <p>
     * Return the position of the final cell where the snake ends up after executing commands.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2, commands = ["RIGHT","DOWN"]
     * <p>
     * Output: 3
     * <p>
     * Explanation:
     * <p>
     * 0	1
     * 2	3
     * <p>
     * 0	1
     * 2	3
     * <p>
     * 0	1
     * 2	3
     */
    public static void main(String[] args) {
        int n = 2;
        List<String> list = List.of("RIGHT","DOWN");
//        list.add("DOWN");
//        list.add("RIGHT");
//        list.add("UP");
//        list.add("LEFT");
        System.out.println(finalPositionOfSnake(n, list));
    }

    public static int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int column = 0;
        for (String command : commands) {
            if (command.equals("UP")) {
                row--;
            } else if (command.equals("DOWN")) {
                row++;
            } else if (command.equals("RIGHT")) {
                column++;
            } else if (command.equals("LEFT")) {
                column--;
            }
        }
        return row * n + column;
        }

    public static int finalPositionOfSnake2(int n, List<String> commands) {
        int row = 0;
        int column = 0;
        for (String command : commands) {
            if (command.equals("UP")) {
                row -=n;
            } else if (command.equals("DOWN")) {
                row +=n;
            } else if (command.equals("RIGHT")) {
                column++;
            } else if (command.equals("LEFT")) {
                column--;
            }
        }
        return row * n + column;
    }
    }

