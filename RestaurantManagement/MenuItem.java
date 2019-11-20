/**
 * Items to be placed on the menui
 *
 * @author Adrian
 * @version (a version number or a date)
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
