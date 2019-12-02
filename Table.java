public class Table{
  public boolean available;
  public int seats;
  public Order order;
  //public timeSeated;
  public int tableNum;
  
  public Table(int s, int n){
    tableNum = n;
    seats = s;
    available = true;
  }
  public boolean getAvail(){
    return available;
  }
  public int getSeats(){
    return seats;
  }
  public Order getOrder(){
      return order;
    }
  public int getTableNum(){
    return tableNum;
  }
  public void setAvail(boolean a){
    available = a;
  }
  public void setSeats(int s){
    seats = s;
  }
  public void setOrder(Order order){
      this.order = order;
    }
}