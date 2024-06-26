// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by Thomas Anderson
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Copyright 2024 by Thomas Anderson
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
    public Store(BufferedReader br) throws IOException
    {
        try
        {
            int sizeC = Integer.parseInt(br.readLine());
            this.customers = new ArrayList<>();

            while(sizeC-- > 0) customers.add(new Customer(br));

            int sizeP = Integer.parseInt(br.readLine());
            this.products = new ArrayList<>();

            while(sizeP-- > 0)
            {
                String type = br.readLine();
                if(type.contains("Tool")) products.add(new Tool(br));
                else if(type.contains("Plant")) products.add(new Plant(br));
                else throw new IOException("Bad product type: " + type);
            };
            
            int sizeO = Integer.parseInt(br.readLine());
            this.orders = new ArrayList<>();

            while(sizeO-- > 0) orders.add(new Order(br));

        }
        catch(Exception e)
        {
            System.err.println("Failed to read: " + e);
        }
    }
    public void save(BufferedWriter bw) throws IOException
    {
        try
        {
            bw.write("" + customers.size() + '\n');
            for(Customer i : customers) i.save(bw);


            bw.write("" + products.size() + '\n');
            for(Product i : products) 
            {
                bw.write(i.getClass().getName() + '\n');
                i.save(bw);
            }

            bw.write("" + orders.size() + '\n');
            for(Order i : orders) 
            {
                i.save(bw);
            }

        
        }
        catch(Exception e)
        {
            System.err.println("Failed to save: " + e);
        }
        
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
            customersBuild.append(String.format("%3d] %s\n", i, customers.get(i)));
        }
        return customersBuild.toString();
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
            productsBuild.append(String.format("%3d] %s\n", i, products.get(i)));
        }
        return productsBuild.toString();
    }
    public int newOrder(int customer)
    {
        Customer newCustomer = customers.get(customer);
        Order newOrder = new Order(newCustomer);

        orders.add(newOrder);
        return orders.indexOf(newOrder);
    }
    public void addToOrder(int order, int product, int quantity)
    {
        Order addOrder = orders.get(order);
        Product addProduct = products.get(product);

        Item newItem = new Item(addProduct, quantity);
        
        addOrder.addItem(newItem);
    }
    public String getOrderList()
    {
        StringBuilder ordersBuild = new StringBuilder();
        for(int i = 0; i < orders.size(); i++)
        {
            ordersBuild.append(String.format("\n%s\n", orders.get(i)));
        }
        return ordersBuild.toString();
    }
  
    

    // fields
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}