#include "linear.h"


Linear::Linear(std::vector<double>& coefficents)
    :   Polynomial(coefficents){
        if ((coefficents.size() != 2) || (_coefficents[0] == 0))
        {
            throw std::runtime_error("a may not be 0");
        }
        
    };
    
std::vector<double> Linear::solve()
{
    std::vector<double> solved;
    solved.push_back(-_coefficents[1]/_coefficents[0]);
    return solved;
};

