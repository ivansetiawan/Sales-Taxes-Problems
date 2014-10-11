/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsalestaxes;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Ivan Setiawan
 * This is a programming exercise given by Liferay
 * Date Created: 10/07/2014
 */
public class BasicSalesTaxes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BasicSalesTaxes sales_taxes = new BasicSalesTaxes();
        try{
            Vector<Items> shop_cart = sales_taxes.Purchase();
            sales_taxes.getReceipt(shop_cart);
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /* This method will print the total prices of all items
     * along with the total taxes
     */
    public void getReceipt(Vector<Items> shop_cart)
    {
        float total_price = 0.0f;
        float total_taxes = 0.0f;
        float amount = 0.0f;
        
        //Get items in the shopping cart
        for(int i = 0; i<shop_cart.size(); i++){
            Items PurchasedItems = shop_cart.get(i);
            total_price = total_price + PurchasedItems.getPrice();
            total_taxes = total_taxes + PurchasedItems.getTaxes();
            PurchasedItems.setTotalPrice(PurchasedItems.getPrice()+PurchasedItems.getTaxes());
            System.out.println(PurchasedItems);
            amount = amount + PurchasedItems.getTotalPrice();
        }
        System.out.println("Sales Taxes: " + total_taxes);
        System.out.println("Total: " + amount);
    }
    
    /*
     * Vectors is used to create a collection of items stored in the shopping cart
     * The main disadvantage of this method is that the user must manually enter
     * the item name and decide if the item is imported and is exempted
     */
    public Vector<Items> Purchase()
    {
        //Get the user to manually enter the items
        Scanner keyboard = new Scanner(System.in);
        String InputItem = null;
        Vector<Items> shop_cart = new Vector<Items>();
        int count = 1;
        while(true){
            Items PurchasedItems = new Items();
            
            System.out.print("Item " + count + " Quantity: ");
            InputItem = keyboard.nextLine();
            PurchasedItems.setQuantity(Integer.parseInt(InputItem));
            
            System.out.print("Item " + count + " Item Name: ");
            InputItem = keyboard.nextLine();
            PurchasedItems.setItemName(InputItem);
            
            System.out.print("Item " + count + " Price: ");
            InputItem = keyboard.nextLine();
            PurchasedItems.setPrice(Float.parseFloat(InputItem));
            
            //Determine the imported items
            System.out.print("Item " + count + " Imported[y/n]: ");
            InputItem = keyboard.nextLine();
            if(InputItem.toLowerCase().equals("y")){
                PurchasedItems.setImported(true);
            }
            
            //Determine exempted items
            System.out.print("Item " + count + " Exempted[y/n]: ");
            InputItem = keyboard.nextLine();
            if(InputItem.toLowerCase().equals("y")){
                PurchasedItems.setExempted(true);
            }
            
            //Call the compute tax method for each item
            PurchasedItems.computeTax();
            
            //Add more items to the shopping cart
            shop_cart.add(PurchasedItems);
            count++;
            
            //Ask the user if he has the next item
            System.out.print("Do you have more items in your cart?[y/n]: ");
            InputItem = keyboard.nextLine();
            if(InputItem.toLowerCase().equals("n")){
                break;
            }
        }
        return shop_cart;
    }
}
