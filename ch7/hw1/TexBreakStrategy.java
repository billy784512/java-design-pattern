package hw1;

import java.util.ArrayList;

public class TexBreakStrategy implements BreakStrategy{
  public void process(ArrayList<Component> components){
    String line = "";
    for (Component c: components){
      line += c.toString() + " ";
      if (c.getContent().equals("<ParagraphEnd>")){
        System.out.println(line);
        line = "";
      }
    }
  }  
}
