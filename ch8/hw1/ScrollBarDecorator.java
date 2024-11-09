package hw1;

public class ScrollBarDecorator extends ViewDecorator{
  public ScrollBarDecorator(View view){
    super(view);
  }

  @Override
  public void display(){
    view.display();
    System.out.print("scrollBar" + " ");
  }
}