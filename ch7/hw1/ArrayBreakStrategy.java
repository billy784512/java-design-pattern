package hw1;

import java.util.ArrayList;

public class ArrayBreakStrategy implements BreakStrategy{
  public void process(ArrayList<Component> components){
    String line = "";
    Integer cnt = 0;

    for (Component c: components){
      line += c.toString() + " ";
      cnt += 1;
      if (cnt == 3){
        System.out.println(line);
        line = "";
        cnt = 0;
      }
    }
    if (!line.equals("")){
      System.out.println(line);
    }
  } 
}
