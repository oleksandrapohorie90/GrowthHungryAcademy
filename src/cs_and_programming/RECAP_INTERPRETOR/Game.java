package cs_and_programming.RECAP_INTERPRETOR;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Game {

    static final String playerProperties = "player.properties";

    public static void main(String[] args) throws FileNotFoundException {
        //when program is starting on prod or any server, usually properties are sent through parameter
        //java read file line by line - stackOverflow
        //Scanner is better and simpler, in java we understand reading from disk is done through Buffer, and it reads by chunks
        File file = new File(playerProperties);
        Scanner input = new Scanner(file);

        HashMap<String, String> map = new HashMap<>();
        while (input.hasNext()) {
            String line = input.nextLine();
            String [] pair = line.split("="); //we have 2 elements
            map.put(pair[0],pair[1]);
        }

       //iterate through entries, map doesn't have indexes, only iterate through entries
        //Map.Entry - inside class in Map
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        }

    }
}
