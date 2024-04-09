#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial
{
    protected: 
        std::vector<double> _coefficents;

    public:
        
        Polynomial(std::vector<double>& coefficents);
        virtual ~Polynomial(){};
        virtual std::vector<double> solve() = 0;
};

#endif