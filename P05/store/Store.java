package store;

import java.util.ArrayList;


public class Store
{
    public Store(String name)
    {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }
    public String getName()
    {
        return name;
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public String getCustomerList()
    {   
        StringBuilder customersBuild = new StringBuilder();
        for(int i = 0; i < customers.size(); i++)
        {
            customersBuild.append(customers.get(i));
        }
        return "" + customersBuild;
    }   
    public getProduct(Product product)
    {
        return products.add(product);
    }
    public String getProductList()
    {
        StringBuilder productsBuild = new StringBuilder();
        for(int i = 0; i < products.size(); i++)
        {
            productsBuild.append(products.get(i));
        }
        return "" + productsBuild;
    }
    public int newOrder(int customer)
    {
        Order newOrder = new Order(null);

        orders.add(newOrder);
        // ????
        // return ; 
    }
    public addToOrder(int order, int product, int quantity)
    {
        // ????
        orders.add()
    }
    public String getOrderList()
    {
        // ????
    }

    // fields
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}