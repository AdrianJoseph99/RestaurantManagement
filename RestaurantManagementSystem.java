import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

import java.util.Scanner;
public class RestaurantManagementSystem implements ActionListener{
  Scanner input = new Scanner(System.in);
  public static ArrayList<Table> tablesArray = new ArrayList<Table>();
  public static ArrayList<Server> servers = new ArrayList<Server>();
  public static ArrayList<Manager> managers = new ArrayList<Manager>();
  public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
  public static ArrayList<JButton> tableButtons = new ArrayList<JButton>();
  public static Queue<Order> toKitchen = new LinkedList<Order>();
  public static Queue<Order> fromKitchen = new LinkedList<Order>();
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
    int numManagers = Integer.parseInt(JOptionPane.showInputDialog("How many managers have you hired?"));
    for(int i=0;i<numManagers;i++){
      this.addManager();
    }
    int numServers = Integer.parseInt(JOptionPane.showInputDialog("How many servers have you hired?"));
    for(int i=0;i<numServers;i++){
      this.addServer();     
    }
    
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    //open new panel or new section
  }
  
  public void addServer(){
    /*JFrame server = new JFrame("Server");
    JTextField fName = new JTextField("First Name");
    JTextField lName = new JTextField("Last Name");
    JTextField empPW = new JTextField("4 digit pin");
    JButton submit = new JButton("Submit");
    server.add(fName);
    server.add(lName);
    server.add(empPW);
    server.add(submit);
    server.setLayout(new FlowLayout());
    server.setSize(300,300);
    server.setVisible(true);
    submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
          Server temp = new Server(Integer.parseInt(empPW.getText()), fName.getText(), lName.getText());
          servers.add(temp);
        }
      }
   });*/
    String fName = JOptionPane.showInputDialog("First Name");
    String lName = JOptionPane.showInputDialog("Last Name");
    int empPW = Integer.parseInt(JOptionPane.showInputDialog("input a pin of 4 digits"));
    Server temp = new Server(empPW, fName, lName);
    servers.add(temp);
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
  
  public void addMenuItem(){
    String name = JOptionPane.showInputDialog("Item name?");
    double price = Double.parseDouble(JOptionPane.showInputDialog("Item price?"));
    String category = JOptionPane.showInputDialog("Item category: Drink or Food?");
    MenuItem food = new MenuItem(name, price, category);
    menu.add(food);
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
  
  public void sendToKitchen(){
    //drinks vs foods?
  }
  
  public void addToOrder(){
    
  }
  
  public static void main(String[] args){
    RestaurantManagementSystem res1 = new RestaurantManagementSystem();
    //to save time on other stuff, but there is still the option of adding later on
    MenuItem spag = new MenuItem("Spaghetti",11,"Food");
    menu.add(spag);
    MenuItem tor = new MenuItem("Tortellini",13,"Food");
    menu.add(tor);
    MenuItem rav = new MenuItem("Ravioli",12,"Food");
    menu.add(rav);
    MenuItem las = new MenuItem("Lasagna",15,"Food");
    menu.add(las);
    MenuItem pi = new MenuItem("Pizza",10,"Food");
    menu.add(pi);
    MenuItem cal = new MenuItem("Calzone",8,"Food");
    menu.add(cal);
    MenuItem pan = new MenuItem("Panini",8,"Food");
    menu.add(pan);
    MenuItem ca = new MenuItem("Caesar Salad",6,"Food");
    menu.add(ca);
    MenuItem so = new MenuItem("Soup of the Day",6,"Food");
    menu.add(so);
    MenuItem bo = new MenuItem("Bottled Water",1,"Drink");
    menu.add(bo);
    MenuItem wi = new MenuItem("Wine",20,"Drink");
    menu.add(wi);
    MenuItem be = new MenuItem("Beer",6,"Drink");
    menu.add(be);
    MenuItem sod = new MenuItem("Soda",1.25,"Drink");
    menu.add(sod);
    boolean Login = res1.signIn();
    if(Login == true){
      //open up the main screen with all tables
      JFrame frame = new JFrame("Restaurant Management System");
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel1.setBackground(Color.BLUE);
      panel2.setBackground(Color.RED);
      JMenuBar bar = new JMenuBar();
      JMenu file = new JMenu("File");
      bar.add(file);
      for(int i=0;i<tablesArray.size();i++){
        String temp = "Table"+Integer.toString(i+1);
        JButton button = new JButton(temp);
        panel1.add(button);
      }
      JButton kitchenView = new JButton("Kitchen");
      panel2.add(kitchenView);
      frame.add(bar);
      frame.add(panel1);
      frame.add(panel2);
      frame.setLayout(new GridLayout(1,2));
      
      frame.setLocationRelativeTo(null);
      frame.setPreferredSize(new Dimension(600,400));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
    }
  }
}