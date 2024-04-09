#include "quadratic.h"

Quadratic::Quadratic(std::vector<double>& coefficents)
    :   Polynomial(coefficents)
    {
        if ((coefficents.size() != 3) || (a == 0))
        {
            throw std::runtime_error("a may not be 0");
        }
        
    };
    
double Quadratic::solve()
{
    if ((b*b - (4 *a * c)) < 0)
    {
        throw std::runtime_error("No real roots!");
    }
    
    return (-b + sqrt((b*b - (4 *a * c))/(2*a)));
    return (-b - sqrt((b*b - (4 *a * c))/(2*a)));
};

