package caloriecounter.demo.model;

public class Food {
  private Long id;
  private String name;
  private int amount;

  private static long counter = 1;

  public Food(String name, int amount){
    this.name = name;
    this.amount = amount;
    this.id = counter;
    ++counter;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
