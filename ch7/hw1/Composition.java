package hw1;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

public class Composition {
  private ArrayList<Component> components;
  //private Map<String, BreakStrategy> breakers;
  BreakStrategy breaker;

  public Composition(){
    components = new ArrayList<>();
    //breakers = new HashMap<>();
  }

  public void addText(Integer id, Integer size, Integer upperBound, Integer lowerBound, String text){
    Text newText = new Text(id, size, upperBound, lowerBound, text);
    components.add(newText);
    return;
  }

  public void addGraphicalElement(Integer id, Integer size, Integer upperBound, Integer lowerBound, String fileName){
    GraphicalElement newGraphicalElement = new GraphicalElement(id, size, upperBound, lowerBound, fileName);
    components.add(newGraphicalElement);
    return;
  }

  //public void addBreaker(String name, BreakStrategy breaker){
  //  breakers.put(name, breaker);
  //  return;
  //}

  public void setBreaker(BreakStrategy breaker){
    this.breaker = breaker;
  }

  public void changeComponentSize(Integer id, Integer newSize){
    for (Component c: components){
      if (c.getId() == id){
        c.changeSize(newSize);
      }
    }
  }

  public void compose(){
    breaker.process(components);
  }
}
