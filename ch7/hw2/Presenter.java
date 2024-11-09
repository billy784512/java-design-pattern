package hw2;

import java.util.ArrayList;

public abstract class Presenter {
  private Application app;

  public Presenter(Application app){
    this.app = app;
  }

  abstract public void depict(ArrayList<Data> dataArray);

  public void observe(String item, Integer value){
    app.refresh(item, value);
  }
}

class Spreadsheet extends Presenter{
  public Spreadsheet(Application app){
    super(app);
  }

  public void depict(ArrayList<Data> dataArray){
    for (Data data: dataArray){
      System.out.println(data.item + " " + data.value);
    }
  }
}

class Barchart extends Presenter{
  public Barchart(Application app){
    super(app);
  }

  public void depict(ArrayList<Data> dataArray){
    for (Data data: dataArray){
      String bar = "";
      for (int i = 1; i <= data.value; i++){
        bar += "=";
      }
      System.out.println(bar + " " + data.item);
    }
  }
}

class PieChart extends Presenter{
  public PieChart(Application app){
    super(app);
  }

  public void depict(ArrayList<Data> dataArray){
    Integer sum = 0;
    for (Data data: dataArray){
      sum += data.value;
    }
    for (Data data: dataArray){
      Double result = (double) data.value / sum;
      String formattedResult = String.format("%.1f%%", result * 100);
      System.out.println(data.item + " " + formattedResult);
    }
  }
}
