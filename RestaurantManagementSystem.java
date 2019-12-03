import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.Scanner;
public class RestaurantManagementSystem{
    Scanner input = new Scanner(System.in);
    public static ArrayList<Table> tablesArray = new ArrayList<Table>();
    public static ArrayList<Server> servers = new ArrayList<Server>();
    public static ArrayList<Chef> chefs = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<Manager>();
    public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    public static ArrayList<JButton> tableButtons = new ArrayList<JButton>();
    public static Queue<Order> toKitchen = new LinkedList<Order>();
    //public static Queue<Order> fromKitchen = new LinkedList<Order>();
    public int masterPassW = 0;

    public RestaurantManagementSystem(){
        masterPassW = Integer.parseInt(JOptionPane.showInputDialog("set a master pin of 4 digits"));
        while(masterPassW>9999||masterPassW<1000){
            try{
                masterPassW = Integer.parseInt(JOptionPane.showInputDialog("please enter valid pin of 4 digits"));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR: please use 4 integers to build your pin");
                masterPassW = 0;
            }
        }
        int tables = Integer.parseInt(JOptionPane.showInputDialog("How many tables will you need?"));
        tablesArray = new ArrayList<Table>(tables);
        for(int i=0;i<tables;i++){
            int seats = Integer.parseInt(JOptionPane.showInputDialog("How many seats will be available for table "+(i+1)+"?"));
            Table obj = new Table(seats,i+1);
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
        int numChefs = Integer.parseInt((JOptionPane.showInputDialog("How many chefs have you hired?")));
        for(int i = 0; i < numChefs; i++){
            this.addChef();
        }
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

    public void addChef(){
        String fName = JOptionPane.showInputDialog("First Name");
        String lName = JOptionPane.showInputDialog("Last Name");
        int empPW = Integer.parseInt(JOptionPane.showInputDialog("input a pin of 4 digits"));
        Chef temp = new Chef(empPW, fName, lName);
        chefs.add(temp);
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
        for(Chef z:chefs){
            if(Integer.parseInt(tempPW)==z.getPassword()){
                return true;
            }
        }
        if(Integer.parseInt(tempPW)==masterPassW){
            return true;
        }
        return false;
    }

    /*  
    public void sendToKitchen(){
    //drinks vs foods?
    }*/

    public static void addToOrder(int tableNumber){

        Order order = tablesArray.get(tableNumber-1).getOrder();

        String tempO = JOptionPane.showInputDialog("Enter an item name from the menu");
        for(MenuItem a : menu){
            if(a.getName().equals(tempO)){
                order.addFood(a);
            }
        }
        //tablesArray.get(tableNumber-1).setOrder(order);
        //order.printOrder();
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
            frame.setLayout(new GridLayout(1,1));
            frame.setLocationRelativeTo(null);
            frame.setPreferredSize(new Dimension(600,400));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();

            frame.setVisible(true);
            /*
            JButton jb = new JButton("Add item to order");
            jb.setBounds(140,100,120,40);
            jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            for(int i = 0; i<tablesArray.size();i++){
            if(tablesArray.get(i).getAvail()){
            addToOrder(i+1);
            tablesArray.get(i).setAvail(false);
            }   
            }
            }
            });*/
            //add the tables as tabs
            JTabbedPane pane = new JTabbedPane();
            JPanel panel = new JPanel();
            //panel.add(jb);
            //add the tables as tabs
            //JTabbedPane pane = new JTabbedPane();
            for(int i=0;i<tablesArray.size();i++){
                String temp = "Table "+Integer.toString(i+1);
                tablesArray.get(i).setOrder((new Order(i+1)));
                //pane.addTab(temp, new JLabel("This is table "+Integer.toString(i+1)));
                pane.addTab(temp,new TablePanel(i+1));
            }
            //pane.add("Kitchen", new JLabel("This is the Kitchen")); //we'll send all the queues to show up in this tab
            pane.addTab("Kitchen", new KitchenPanel());
            /*JButton jb2 = new JButton("Complete Order");
            jb2.setBounds(140,100,120,40);
            //panel.add(jb2,BorderLayout.CENTER);
            panel.add(jb2);
            jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Order order = getFromKitchen();
            tablesArray.get(order.getTableNumber()-1).setAvail(true);
            }
            });*/

            frame.getContentPane().add(pane);
            frame.setVisible(true);
            /** Details @Hannah
             * an "Order Food" button under each table tab that opens the menu and has a way for you to select the
             * quantity of food item.
             * a "Total" button under each table tab that shows the total of the order.
             * and a "View Order" button under each table tab that that displays the current order.
             */
        }
    }

    private static class TablePanel extends JPanel {

        public TablePanel(Integer tableNum) {
            
            DecimalFormat df = new DecimalFormat("#.##");
            JButton jb = new JButton("Add item to order");
            JButton jb2 = new JButton("Complete Order");
            jb.setBounds(200,100,120,40);
            jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(tablesArray.get(tableNum-1).getAvail())
                            addToOrder(tableNum);
                    }   

                }
            );
            jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toKitchen.add(tablesArray.get(tableNum-1).getOrder());
                        tablesArray.get(tableNum-1).setAvail(false);
                        String foods = "";
                        for(int i = 0; i<tablesArray.get(tableNum-1).getOrder().getOrder().size();i++)
                            foods += tablesArray.get(tableNum-1).getOrder().getOrder().get(i).getName()+"\n";
                        JTextField food = new JTextField(foods);
                        add(food);
                        revalidate();
                    }
                }
            );
            add(new JLabel("This is Table "+tableNum+"."),SwingConstants.CENTER);
            add(new JLabel("It can seat "+tablesArray.get(tableNum-1).getSeats()+" people."),SwingConstants.CENTER);
            jb.setHorizontalAlignment(SwingConstants.RIGHT);
            jb2.setVerticalAlignment(SwingConstants.BOTTOM);
            add(jb);

            add(jb2);

            String menuText = "";
            for(int i = 0; i<menu.size();i++)
                menuText += (menu.get(i).getName()+ ", $" + df.format(menu.get(i).getPrice()) + "\n");

            JTextArea  JTA = new JTextArea(menuText);
            JPanel jp = new JPanel();
            jp.add(JTA);
            add(jp);
        }
    }
    private static class KitchenPanel extends JPanel {

        public KitchenPanel() {

            JButton jb2 = new JButton("Deliver Order");
            jb2.setBounds(140,100,120,40);
            //panel.add(jb2,BorderLayout.CENTER);
            jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Order order = toKitchen.poll();

                        String foods = "";
                        for(int i = 0; i<order.getOrder().size();i++)
                            foods += order.getOrder().get(i).getName()+"\n";
                        JTextField food = new JTextField(foods);
                        add(food);
                        tablesArray.get(order.getTableNumber()-1).setAvail(true);
                        revalidate();
                    }
                }
            );
            add(new JLabel("This is the Kitchen."));
            /*Order test = new Order(1);
            test.addFood(new MenuItem("Spaghetti",11,"Food"));
            test.addFood(new MenuItem("Baguette",11,"Food"));
            test.addFood(new MenuItem("Pineapple",11,"Food"));
            String[] foods = new String[test.getOrder().size()];
            for(int i = 0; i<test.getOrder().size();i++)
            foods[i] = test.getOrder().get(i).getName();
            JList food = new JList(foods);*/
            add(jb2);
            //add(food);
        }
    }
}