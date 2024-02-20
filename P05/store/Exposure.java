package store;

/**
 * Holds the type of sun exposure a plant needs.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.2
 */
public enum Exposure
{
    SHADE("full sun"), PARTSUN("part sun"), SUN("full sun");
    
    private Exposure(String exposure)
    {
	    this.exposure = exposure;
    }
    /**
	 * Converts the exposure enum element to a string.
	 * 
	 * @author          Thomas Anderson
	 * @return			the exposure as a string
	 * @version         0.2
	 * @since           0.1
	 */
    @Override
    public String toString()
    {
        return exposure;	
    } 

    private String exposure;

}
