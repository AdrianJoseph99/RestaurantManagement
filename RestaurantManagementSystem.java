import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Queue;

import java.util.Scanner;
public class RestaurantManagementSystem implements ActionListener{
  Scanner input = new Scanner(System.in);
  public static ArrayList<Table> tablesArray;
  public static ArrayList<Server> servers;
  public static ArrayList<Manager> managers;
  public static ArrayList<MenuItem> menu;
  public static Queue<Order> toKitchen;
  public static Queue<Order> fromKitchen;
  public int masterPassW;
  
  public RestaurantManagementSystem(){
    masterPassW = Integer.parseInt(JOptionPane.showInputDialog("set a master pin of 4 digits"));
    int tables = Integer.parseInt(JOptionPane.showInputDialog("How many tables will you need?"));
    tablesArray = new ArrayList<Table>(tables);
    for(int i=0;i<tables;i++){
      int seats = Integer.parseInt(JOptionPane.showInputDialog("How many seats will be available for table "+(i+1)+"?"));
      Table obj = new Table(i+1,seats);
      tablesArray.add(obj);
    }
    int numWorkers = Integer.parseInt(JOptionPane.showInputDialog("How many employees have you hired?"));
    int numServers = Integer.parseInt(JOptionPane.showInputDialog("How many are servers?"));
    for(int i=0; i<numServers;i++){
      this.addServer();     
    }
    int numManagers = Integer.parseInt(JOptionPane.showInputDialog("How many are managers?"));
    for(int i=0;i<numManagers;i++){
      this.addManager();
    }
  }
  
  public void actionPerformed(ActionEvent e){
    
  }
  
  public void addServer(){
    JFrame server = new JFrame("Server");
    JTextField fName = new JTextField("First Name");
    JTextField lName = new JTextField("Last Name");
    JTextField empPW = new JTextField("4 digit pin");
    JButton submit = new JButton("Submit");
    server.add(fName);
    server.add(lName);
    server.add(empPW);
    server.add(submit);
    server.setLayout(new FlowLayout());
    server.setSize(400,400);
    server.setVisible(true);
    submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
          Server temp = new Server(Integer.parseInt(empPW.getText()), fName.getText(), lName.getText());
          servers.add(temp);
        }
      }
    });
    /*String fName = JOptionPane.showInputDialog("First Name?");
    String lName = JOptionPane.showInputDialog("Last Name?");
    int empPW = Integer.parseInt(JOptionPane.showInputDialog("input a pin of 4 digits"));*/
  }
  public void addManager(){
    String fName = JOptionPane.showInputDialog("First Name?");
    String LName = JOptionPane.showInputDialog("Last Name?");
    int manPW = Integer.parseInt(JOptionPane.showInputDialog("input a pin of 4 digits"));
    String masterP = JOptionPane.showInputDialog("enter the master password");
    while(Integer.parseInt(masterP) != masterPassW){
      masterP = JOptionPane.showInputDialog("the master password is incorrect, please enter a valid password or press q to quit");
      if(masterP.equals("q")){
        System.exit(0);
      }
    }
    Manager temp = new Manager(manPW, fName, LName, Integer.parseInt(masterP));
    managers.add(temp);
  }
  
  public boolean signIn(){
    String tempPW = JOptionPane.showInputDialog("Login with your pin");
    for(Manager x:managers){
      if(Integer.parseInt(tempPW)==x.getPassword()){
        return true;
      }
    }
    for(Server y:servers){
      if(Integer.parseInt(tempPW)==y.getPassword()){
        return true;
      }
    }
    if(Integer.parseInt(tempPW)==masterPassW){
        return true;
      }
    return false;
  }
  
  public static void main(String[] args){
    //sign in --> server or manager?
    //Server: seating(how many people?) or ordering(for which table)?
    //manager: seating or ordering or looking at info?
    //
    RestaurantManagementSystem res1 = new RestaurantManagementSystem();
    
    boolean Login = res1.signIn();
    if(Login == true){
      
    }
  }
}