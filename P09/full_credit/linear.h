#ifndef __LINEAR_H
#define __LINEAR_H

#include "polynomial.h"

class Linear : virtual public Polynomial
{
    
    public:
        Linear(std::vector<double>& coefficents);
        virtual std::vector<double> solve() override;
};


#endif