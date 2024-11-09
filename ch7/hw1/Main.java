package hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args){
    if (args.length == 0) {
      System.out.println("Please provide the file path as a command-line argument.");
      System.exit(1);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
      String line;
      Composition composition = new Composition();

      while ((line = reader.readLine()) != null){
        String[] parts = line.split(" ");
        String command = parts[0];

        switch (command){
          case "Text":
            Integer t_id = Integer.parseInt(parts[1]);
            Integer t_currSize = Integer.parseInt(parts[2]);
            Integer t_lowerBound = Integer.parseInt(parts[3]);
            Integer t_upperBound = Integer.parseInt(parts[4]);
            String t_content = parts[5];

            composition.addText(t_id, t_currSize, t_upperBound, t_lowerBound, t_content);
            break;

          case "GraphicalElement":
            Integer g_id = Integer.parseInt(parts[1]);
            Integer g_currSize = Integer.parseInt(parts[2]);
            Integer g_lowerBound = Integer.parseInt(parts[3]);
            Integer g_upperBound = Integer.parseInt(parts[4]);
            String g_content = parts[5];

            composition.addGraphicalElement(g_id, g_currSize, g_upperBound, g_lowerBound, g_content);
            break;
          
          case "ChangeSize":
            Integer c_id = Integer.parseInt(parts[1]);
            Integer newSize = Integer.parseInt(parts[2]);

            composition.changeComponentSize(c_id, newSize);
            break;

          case "Require":
            String strategyName = parts[1];

            if (strategyName.equals("SimpleComposition")){
              BreakStrategy bs = new SimpleBreakStrategy();
              composition.setBreaker(bs);
            }
            if (strategyName.equals("TexComposition")){
              BreakStrategy bs = new TexBreakStrategy();
              composition.setBreaker(bs);
            }            
            if (strategyName.equals("ArrayComposition")){
              BreakStrategy bs = new ArrayBreakStrategy();
              composition.setBreaker(bs);
            }

            composition.compose();
            break;
        }
      }
    }
    catch (IOException e){
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}
