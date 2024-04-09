#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial
{
    protected: 
        double a, b, c;
        std::vector<double> _coefficents = {a, b, c};

    public:
        
        Polynomial(std::vector<double>& coefficents);
        virtual ~Polynomial(){};
        virtual double solve() = 0;
};

#endif