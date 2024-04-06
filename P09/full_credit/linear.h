#ifndef __LINEAR_H
#define __LINEAR_H
#include <iostream>
#include "polynomial.h"

class Linear : virtual Polynomial
{
    public:
        Linear(double coefficents);
        virtual ~Linear(){}

};

#endif