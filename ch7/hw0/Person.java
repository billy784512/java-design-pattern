package hw0;

public abstract class Person{
  private String job;
  private Double weight;
  private Double height;

  public Person(String job, Double weight, Double height){
    this.job = job;
    this.weight = weight;
    this.height = height;
  }

  public String getJob(){
    return this.job;
  }

  public Double getWeight(){
    return this.weight;
  }

  public Double getHeight(){
    return this.height;
  }
}

class RealPerson extends Person{
  public RealPerson(String job, Double weight, Double height){
    super(job, weight, height);
  }
}

class NullPerson extends Person {
  public NullPerson() {
      super("Unknown", 0.0, 0.0);
  }
}