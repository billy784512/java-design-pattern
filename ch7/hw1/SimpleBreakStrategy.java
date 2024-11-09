package hw1;

import java.util.ArrayList;

public class SimpleBreakStrategy implements BreakStrategy{
  public void process(ArrayList<Component> components){
    for (Component c: components){
      System.out.println(c);
    }
  }
}
