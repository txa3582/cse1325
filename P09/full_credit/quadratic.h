#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include "polynomial.h"

class Quadratic : virtual public Polynomial
{
    public:
        Quadratic(std::vector<double>& coefficents);
        virtual double solve() override;
};

#endif