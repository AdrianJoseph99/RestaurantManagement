import java.util.Calendar;
import java.util.*;

public class Order {
 
  protected int tableNumber;
  protected ArrayList<MenuItem> order;
  protected Calendar timeOfOrder;
  
  public Order(int tableNumber) {
    this.tableNumber = tableNumber;
    this.order = order;
    this.timeOfOrder = Calendar.getInstance();
  }
  
  public Order() {
  }
  
  public void setTimeOfOrder(Calendar timeOfOrder) {
    this.timeOfOrder = Calendar.getInstance();
  }
  public void setTableNumber(int tableNumber) {
    this.tableNumber = tableNumber;
  }
  public void setOrder(ArrayList<MenuItem> order) {
    this.order = order;
  }
  public Calendar getTimeOfOrder() {
    return this.timeOfOrder;
  }
  public int getTableNumber() {
    return this.tableNumber;
  }
  public ArrayList<MenuItem> getOrder() {
    return this.order;
  }
  
  public void addMenuItem(MenuItem item) {
    order.add(item);
  }
  public void removeMenuItem(MenuItem item) {
    order.remove(item);
  }
  public void printOrder(ArrayList<MenuItem> order) {
    String name;
    double cost;
    for (MenuItem item : order) {
      name = item.getName();
      cost = item.getPrice();
      System.out.printf("%s" + ", $" + "%.2f" + "\n", name, cost);
    }
  }
  
  public void printTotal(ArrayList<MenuItem> order) {
    double total = 0;
    for (MenuItem item : order) {
      total += item.getPrice();
    }
    System.out.printf("Total Cost = $" + "%.2f" + "\n", total);
  }
  
  public double calculateTotal(ArrayList<MenuItem> order) {
    double total = 0;
    for (MenuItem item : order) {
      total += item.getPrice();
    }
    return total;
  }
 
  public void orderTime() {
    System.out.println("Time of Order:"); 
    System.out.format("%tB %te, %tY%n", this.timeOfOrder, this.timeOfOrder, this.timeOfOrder);
    System.out.format("%tl:%tM %tp%n", this.timeOfOrder, this.timeOfOrder, this.timeOfOrder); 
  }

}
  
