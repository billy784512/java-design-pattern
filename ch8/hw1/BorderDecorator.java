package hw1;

public class BorderDecorator extends ViewDecorator{
  public BorderDecorator(View view){
    super(view);
  }

  @Override
  public void display(){
    view.display();
    System.out.print("thickBlackBorder" + " ");
  }
}
