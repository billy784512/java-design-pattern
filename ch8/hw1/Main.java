package hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

public class Main {
  public static void main(String[] args){
    if (args.length == 0) {
      System.out.println("Please provide the file path as a command-line argument.");
      System.exit(1);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
      String line;
      Map<String, View> map = new HashMap<>();

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        String textViewName = parts[0];

        if (!map.containsKey(textViewName)){
          String text = parts[1];
          map.put(textViewName, new TextView(text));
          continue;
        }

        String command = parts[1];
        if (command.equals("add")){
          for (int i = 2; i < parts.length; i++){
            View tv = map.get(textViewName);
            if (parts[i].equals("thickBlackBorder")){
              map.put(textViewName, new BorderDecorator(tv));
            }
            if (parts[i].equals("scrollBar")){
              map.put(textViewName, new ScrollBarDecorator(tv));
            }
          }
          continue;
        }

        if (command.equals("display")){
          View tv = map.get(textViewName);
          tv.display();
          System.out.println("");
          continue;
        }
      }
    }
    catch(IOException e){
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}
