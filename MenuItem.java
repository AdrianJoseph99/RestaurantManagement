/**
 * Write a description of class MenuItem here.
 *
 * @author Adrian
 * 
 */
public class MenuItem
{
    protected double price;
    protected String name;
    /**
     * Constructor for objects of class MenuItem
     */
    public MenuItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {

        return price;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
