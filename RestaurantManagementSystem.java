import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Queue;

import java.util.Scanner;
public class RestaurantManagementSystem{
  Scanner input = new Scanner(System.in);
  public ArrayList<Table> tables;
  //public ArrayList<Employee> workers;
  //public ArrayList<MenuItem> menu;
  //public Queue<Order> toKitchen;
  //public Queue<Order> fromKitchen;
  
  public RestaurantManagementSystem(){
    int tables = (int)(input.nextLine("How many tables will you need?"));
    for(int i=0;i<tables;i++){
      int seats = input.nextLine("How many seats will be available for this table?");
      Table obj = new Table(i+1,seats);
      tables.add(obj);
    }
  }
}