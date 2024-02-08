package store;

//public static final string array

public enum Exposure
{
    SHADE("full sun"), PARTSUN("part sun"), SUN("full sun");
    
    private Exposure(String exposure)
    {
	this.exposure = exposure;
    }
    @Override
    public String toString()
    {
        return exposure;	
    } 

    private String exposure;

}
