#include "linear.h"
#include "polynomial.h"


Linear::Linear(std::vector<double>& coefficents)
    :   Polynomial(coefficents)
    {
        if ((coefficents.size() != 2) || (a == 0))
        {
            throw std::runtime_error("a may not be 0");
        }
        
    };
    
double Linear::solve()
{
    return -b/a;
};

