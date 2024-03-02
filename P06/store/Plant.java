package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Holds the plant type.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.2
 */
public class Plant extends Product
{

    /**
     * Creates a species, price and exposure instance.
     * 
     * @author          Thomas Anderson
     * @param species   the plant's species
     * @param price     the plant's price
     * @param exposure  the plant's sun exposure
     * @version         0.2
     * @since           0.2
     */
    public Plant(String species, int price, Exposure exposure)
    {
        super("Plant: " + species, price);
        
        this.exposure = exposure;
    }
    public Plant(BufferedReader br) throws IOException
	{
		this.species = br.readLine();
		this.price = Integer.parseInt(br.readLine());
        this.exposure = 
	}
	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(	 + '\n');
		bw.write("" + price + '\n');
	}

    //methods

    /**
     * Gets the exposure type for the plant.
     * 
     * @author          Thomas Anderson
     * @return          the plant's exposure
     * @version         0.2
     * @since           0.2
     */
    public Exposure getExposure()
    {
        return exposure;
    }
    //fields
    private Exposure exposure;
}