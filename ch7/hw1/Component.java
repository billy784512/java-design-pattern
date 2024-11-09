package hw1;

public abstract class Component {
  private Integer id;
  private Integer currSize;
  private Integer sizeUpperBound;
  private Integer sizeLowerBound;
  private String payload;

  public Component(Integer id, Integer size, Integer upperBound, Integer lowerBound, String payload){
    this.id = id;
    currSize = size;
    sizeUpperBound = upperBound;
    sizeLowerBound = lowerBound;
    this.payload = payload;
  }
  
  public void changeSize(Integer newSize){
    if (newSize < sizeLowerBound || newSize > sizeUpperBound){
      System.out.println("component " + id + " failed to change size");
      return;
    }
    currSize = newSize;
    System.out.println("component " + id + " size changed to " + currSize);
    return;
  }

  public Integer getId(){
    return id;
  }

  public Integer getSize(){
    return currSize;
  }

  public String getContent(){
    return payload;
  }

  @Override
  public String toString(){
    return "[" + currSize + "]" + payload;
  }
}

class Text extends Component{
  public Text(Integer id, Integer size, Integer upperBound, Integer lowerBound, String text){
    super(id, size, upperBound, lowerBound, text);
  }
}

class GraphicalElement extends Component{
  public GraphicalElement(Integer id, Integer size, Integer upperBound, Integer lowerBound, String fileName){
    super(id, size, upperBound, lowerBound, fileName);
  }
}
