package cs_and_programming.RECAP_INTERPRETOR;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    static final String playerProperties = "player.properties";

    public static void main(String[] args) throws FileNotFoundException {
        //when program is starting on prod or any server, usually properties are sent through parameter
        //java read file line by line - stackOverflow
        //Scanner is better and simpler, in java we understand reading from disk is done through Buffer, and it reads by chunks
        File file = new File(playerProperties);
        Scanner sc = new Scanner(file);
    }
}
