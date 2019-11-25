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
    protected String category;
    /**
     * Constructor for objects of class MenuItem
     */
    public MenuItem(String name, double price, String category)
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
    
    public String getCategory()
    {
      return category;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setCategory(String category)
    {
      this.category = category;
    }
}
