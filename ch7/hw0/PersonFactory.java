package hw0;

public class PersonFactory {
  public static Person getPerson(String jobName, Double weight, Double height){
    if (jobName == null || jobName.equals("")){
      return new NullPerson();
    }

    if (weight == null || weight < 0.0){
      return new NullPerson();
    }

    if (height == null || height < 0.0){
      return new NullPerson();
    }

    return new RealPerson(jobName, weight, height);
  }
}
