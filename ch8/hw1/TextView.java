package hw1;

public class TextView implements View{
  public String text;

  public TextView(String text){
    this.text = text;
  }

  public void display(){
    System.out.print(text + " ");
  }
}
