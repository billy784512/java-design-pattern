package hw2;

import java.util.ArrayList;

public class Application {
  private ArrayList<Data> dataArray;
  private ArrayList<Presenter> presenters;

  public Application(){
    dataArray = new ArrayList<>();
    presenters = new ArrayList<>();
  }

  public void addData(Data data){
    dataArray.add(data);
  }

  public void addPresenter(Presenter presenter){
    presenters.add(presenter);
  }

  public Presenter getPresenters(String presenterName){
    for (Presenter p: presenters){
      if (p.getClass().getSimpleName().equals(presenterName)){
        return p;
      }
    }
    return null;
  }

  public void present(){
    for (Presenter p: presenters){
      p.depict(dataArray);
    }
  }

  public void refresh(String item, Integer value){
    Boolean checkNewData = true;
    for (Data data: dataArray){
      if (data.item.equals(item)){
        data.value = value;
        checkNewData = false;
        break;
      }
    }
    if(checkNewData){
      dataArray.add(new Data(item, value));
    }
    present();
  }
}
