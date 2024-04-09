#include "linear.h"
#include "quadratic.h"

int main(int argc, char* argv[])
{
    if((argc < 3) || (argc > 4))
    {
        std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
        exit(-1);
    }
    
    std::vector<double> linearv = {1.0,2.0};
    Linear linear(linearv);

    Polynomial* p = &linear; 

    if(argc == 3)
    {
        double c1 = std::stod(argv[1]);
        double c2 = std::stod(argv[2]);
        std::vector<double> linearCoefficents = {c1,c2};
        p = new Linear(linearCoefficents);
    }
    if(argc == 4)
    {
        double c1 = std::stod(argv[1]);
        double c2 = std::stod(argv[2]);
        double c3 = std::stod(argv[3]);
        std::vector<double> QuadraticCoefficents = {c1,c2,c3};
        
        p = new Quadratic(QuadraticCoefficents);
    }

    std::vector<double> roots = p->solve();
    std::cout << "Root(s) are ";
    for (int i: roots)
    {
        std::cout << i;
        std::cout << " ";
    }
    
    delete p;

    // Fix destructors
    return 0;
}
