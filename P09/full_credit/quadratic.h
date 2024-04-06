#ifndef __QUADRATRIC_H
#define __QUADRATRIC_H

#include <iostream>
#include "polynomial.h"

class Quadratic : virtual public Polynomial
{
    public:
        Quadratic(std::vector<double>& coefficents);
        virtual ~Quadratic();
        virtual double solve() override;
};

#endif