/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsalestaxes;

/**
 *
 * @author Ivan Setiawan
 * This is a header files defining the functionality of the basic sales tax 
 * calculation
 */
public class Items implements TaxesCalculation{
    // Some Initialization
    private int quantity = 0;
    
    //Initialize if items purchased is imported and exempted
    private boolean imported = false;
    private boolean exempted = false;
    
    //The prices, sales taxes, and total cost are in floating point
    private float price = 0.0f;
    private float sales_tax = 0.0f;
    private float total = 0.0f;
    
    //Get the name of the items
    private String Item_Name = null;


/* This computeTax() method will compute taxes based on whether it is imported or not
 * and whether it is exempted or not
 */

    public void computeTax()
    {
        float taxes = 0.0f;
        if(isImported() && isExempted())
        {
            taxes = 0.05f;
        }
        else if(!isImported() && !isExempted())
        {
            taxes = 0.1f;
        }
        else if(isImported() && !isExempted())
        {
            taxes = 0.15f;
        }
        else
        {
            taxes = 0.0f;
        }
        sales_tax = Round(taxes * price);
    }
    
    public float Round(float value)
    {
        float taxCalculation = ((float)(Math.ceil(value/0.05)*0.05));
        return taxCalculation;
    }
    
    //Declare quantity and its constructor
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    //Declare import and exempt products
    public boolean isImported()
    {
        return imported;
    }
    public void setImported(boolean imported){
        this.imported = imported;
    }
    public boolean isExempted()
    {
        return exempted;
    }
    public void setExempted(boolean exempted){
        this.exempted = exempted;
    }
    
    //Declare prices
    public float getPrice()
    {
        return price;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    
    //Declare sales taxes
    public float getTaxes()
    {
        return sales_tax;
    }
    
    //Declare total purchase along with the taxes
    public float getTotalPrice()
    {
        return total;
    }
    public void setTotalPrice(float total)
    {
        this.total = total;
    }
    
    //Declare the name of the items
    public String getItemName()
    {
        return Item_Name;
    }
    public void setItemName(String Item_Name)
    {
        this.Item_Name = Item_Name;
    }
}