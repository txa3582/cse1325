#include "linear.h"
#include "Polynomial.h"

class Linear : virtual public Polynomial
{
    public:
        Linear::Linear(std::vector<double>& coefficents)
            :   Polynomial(coefficents)
            {
                if ((coefficents.size() != 2) || (a == 0))
                {
                    throw std::runtime_error("a may not be 0");
                }
                
            };
        virtual Linear::~Linear();
        virtual double Linear::solve();
        virtual double Linear::solve() override
        {
            return -b/a;
        };
};
