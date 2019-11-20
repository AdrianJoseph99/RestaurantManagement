import java.util.*;
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
}
