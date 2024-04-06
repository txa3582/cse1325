#include "linear.h"
#include "Polynomial.h"

#include <iostream>

class Linear : virtual public Polynomial
{
    public:
        Linear(std::vector<double>& coefficents)
            :   Polynomial(coefficents)
            {
                if ((coefficents.size() < 2) || (a = 0))
                {
                    std::runtime_error
                }
                
            };
        virtual ~Linear();
        virtual double solve();
        virtual double solve() override
        {
            return -b/a;
        };
};
