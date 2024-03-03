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