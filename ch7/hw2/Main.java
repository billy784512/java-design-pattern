package hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args){
    if (args.length == 0) {
      System.out.println("Please provide the file path as a command-line argument.");
      System.exit(1);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
      String line;
      Application app = new Application();

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        String command = parts[0];

        switch (command) {
          case "data":
            Data data = new Data(parts[1], Integer.parseInt(parts[2]));
            app.addData(data);
            break;
          case "addChart":
            String type = parts[1];
            Presenter p = null;
            
            if (type.equals("Spreadsheet")){
              p = new Spreadsheet(app);
            }
            else if (type.equals("BarChart")){
              p = new Barchart(app);
            }
            else if (type.equals("PieChart")){
              p = new PieChart(app);
            }
            
            if (p != null){
              app.addPresenter(p);
            }
            break;
          case "change":
            String c_type = parts[1];
            String c_name = parts[2];
            Integer c_value = Integer.parseInt(parts[3]);

            Presenter c_p = app.getPresenters(c_type);
            c_p.observe(c_name, c_value);

            break;
        }
      }
    }
    catch (IOException e){
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}
