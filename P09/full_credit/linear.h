#ifndef __LINEAR_H
#define __LINEAR_H

#include "linear.h"
#include "polynomial.h"

class Linear : virtual public Polynomial
{
    public:
        Linear(std::vector<double> coefficents);
        virtual double solve() override;
};


#endif