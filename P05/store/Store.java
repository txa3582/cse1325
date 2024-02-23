package store;

import java.util.ArrayList;


public class Store
{
    public Store(String name)
    {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.name = name;
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
    public void addProduct(Product product)
    {
        products.add(product);
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
        Customer newCustomer = new Customer();  
        Order newOrder = new Order(customer);

        orders.add(newOrder);
        return orders.indexOf(newOrder);
    }
    public void addToOrder(int order, int product, int quantity)
    {
        Item newItem = new Item(product, quantity);
        order.addItem(newItem); 
    }
    public String getOrderList()
    {
        StringBuilder ordersBuild = new StringBuilder();
        for(int i = 0; i < orders.size(); i++)
        {
            ordersBuild.append(orders.get(i));
        }
        return "" + ordersBuild;
    }

    // fields
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}