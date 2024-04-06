#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial
{
    protected: 
        std::vector<double*> _coefficents;

    public:
        Polynomial(double coefficents)
        :   _coefficents{coefficents} {}
        virtual ~Polynomial(){}
        virtual double* solve() = 0;
};

#endif