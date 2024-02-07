package store;

public class Plant extends Product
{

    public Plant(String species, int price, Exposure exposure)
    {
        super(species, price);

        this.exposure = exposure;
    }

    //methods
    public Exposure getExposure()
    {
        return exposure;
    }
    //fields
    private Exposure exposure;
}