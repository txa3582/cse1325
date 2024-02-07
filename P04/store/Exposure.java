package store;

public enum Exposure
{
    SHADE
    {   
        @Override
        public String toString()
        {
            return "full shade";
        }
    }, 
    PARTSUN
    {
        @Override
        public String toString()
        {
            return "part shade";
        }
    }, 
    SUN
    {
        @Override
        public String toString()
        {
            return "full sun";
        }
    };
    

}