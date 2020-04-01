package pl.adaroz.springboot2.homework7.model;

public class Car {

  private long id;
  private String make;
  private String model;
  private int year;

  public Car(long id, String make, String model, int year) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Car() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
