package hw1;

public abstract class ViewDecorator implements View{
  public View view;

  public ViewDecorator(View view){
    this.view = view;
  }

  abstract public void display();
}
