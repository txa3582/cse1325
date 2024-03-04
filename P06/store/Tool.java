// Copyright 2024 by Thomas Anderson
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package store;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;


/**
 * Holds the tool type.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.2
 */
public class Tool extends Product
{
    /**
     * Creates a name and price instance.
     * 
     * @author          Thomas Anderson
     * @param name      the tool's name
     * @param price     the tool's price
     * @version         0.2
     * @since           0.2
     */
    public Tool(String name, int price)
    {
        super(name, price);
    }
    public Tool(BufferedReader br) throws IOException
    {
        super(br);
    }
} 