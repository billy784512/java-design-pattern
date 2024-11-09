package hw0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please provide the file path as a command-line argument.");
      System.exit(1);
    }

    Map<String, Person> map = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
    
      String line;
        
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        String command = parts[0];
        
        switch (command) {
          case "Person":
            String personName = parts[1];
            String jobName = parts[2];
            Double weightVal = parseToDouble(parts[3]);
            Double heightVal = parseToDouble(parts[4]);

            Person p = PersonFactory.getPerson(jobName, weightVal, heightVal);
            
            map.put(personName, p); 
            break;
          
          case "Job":
            String queryName = parts[1];

            System.out.println(map.get(queryName).getJob());
            break;
          
          case "WeightSum":
            Double weightSum = 0.0;
            for (int i = 1; i < parts.length; i++){
              weightSum += map.get(parts[i]).getWeight();
            }

            System.out.println(weightSum.longValue());
            break;
          
          case "WeightAverage":
            Double weights = 0.0;
            Integer w_cnt = 0;
            for (int i = 1; i < parts.length; i++){
              weights += map.get(parts[i]).getWeight();
              w_cnt++;
            }
            Long weightAvg = Math.round(weights/w_cnt);
            
            System.out.println(weightAvg);
            break;
          
          case "HeightSum":
            Double heightSum = 0.0;
            for (int i = 1; i < parts.length; i++){
              heightSum += map.get(parts[i]).getHeight();
            }
            
            System.out.println(heightSum.longValue());
            break;
          
          case "HeightAverage":
            Double heights = 0.0;
            Integer h_cnt = 0;
            for (int i = 1; i < parts.length; i++){
              heights += map.get(parts[i]).getHeight();
              h_cnt++;
            }
            Long heightAvg = Math.round(heights/h_cnt);
            
            System.out.println(heightAvg);
            break;
        }
      }
    } 
    catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }

  private static Double parseToDouble(String value) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
