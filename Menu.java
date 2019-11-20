import java.util.*;
/**
 * Write a description of class Menu here.
 *
 * @author Adrian
 */
public class Menu
{

    protected ArrayList<MenuItem> menu;

    /**
     * Constructor for objects of class Menu
     */
    public Menu(ArrayList<MenuItem> menu)
    {
        this.menu = menu;
    }

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        menu = new ArrayList<MenuItem>();
    }

    public void setMenu(ArrayList<MenuItem> menu){
        this.menu = menu;
    }

    public ArrayList<MenuItem> getMenu(){
        return menu;
    }

    public double getTotalPrice(){
        double total =0;
        for(MenuItem fud:menu)
            total+=fud.getPrice();
        return total;
    }
}
