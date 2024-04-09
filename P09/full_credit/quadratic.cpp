#include "quadratic.h"

Quadratic::Quadratic(std::vector<double>& coefficents)
    :   Polynomial(coefficents)
    {
        if ((coefficents.size() != 3) || (_coefficents[0] == 0))
        {
            throw std::runtime_error("a may not be 0");
        }
        
    };
    
std::vector<double> Quadratic::solve()
{

    
    double a = _coefficents[0];
    double b = _coefficents[1];
    double c = _coefficents[2];
    if ((b*b - (4 *a * c) < 0))
    {
        throw std::runtime_error("No real roots!");
    }
    std::vector<double> solved;

    solved.push_back((-b + std::sqrt((b*b - 4 * a * c))) / (2*a));
    solved.push_back((-b - std::sqrt((b*b - 4 * a * c))) / (2*a));
    return solved;
};

