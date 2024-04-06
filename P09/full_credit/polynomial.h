#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial
{
    double a,b,c;
    protected: 
        std::vector<double> _coefficents = {a, b, c};

    public:
        Polynomial(double coefficents);
        virtual ~Polynomial(){} 
        virtual double* solve() = 0;
};

#endif